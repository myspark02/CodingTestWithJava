package codingwithscpark.network;

import java.net.*;
import java.io.*;

public class TranslationServer {
    public static void main(String[] args) throws Exception {
        System.out.println("영어 번역 서버가 실행 중입니다");

        int clientId = 0;

        try (ServerSocket serverSocket = new ServerSocket(9101)) {
            while(true) {
                clientId++;
                Socket socket = serverSocket.accept(); // 클라이언트와 연결되면 새로운 소켓을 생성하고
                Runnable runnable = new Translator(socket, clientId);   // 그 클라이언트와 통신을 전담할 새로운 스레드를 실행시킨다. 
                new Thread(runnable).start();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class Translator implements Runnable {
    private Socket socket;
    private int myClientId;

    public Translator(Socket socket, int clientId) {
        this.socket = socket;
        this.myClientId = clientId;
    }

    @Override
    public void run() {
        try {
            InputStream inStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

            OutputStream outStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outStream, true);
            writer.println("안녕하세요? 클라이언트 번호는 " + myClientId + " 입니다.");
            writer.println("번역할 단어를 입력하세요.");

            while(true) { // 클라이언트가 연결을 끝을 때까지 무한 반복하면서 단어를 번역해준다. 
                String word = reader.readLine();
                if (word == null) break; // 클라이언트가 연결을 종료하면 null 이 반환된다. 

                if (word.equalsIgnoreCase("java")) writer.println(word + "-> 자바");
                else writer.println("저는 자바밖에 몰라요...TT");
            }

        }catch(IOException e) {
            System.out.println("클라이언트 번호: " + myClientId + " 처리 실패:" + e.getMessage());
        }finally {
            try {socket.close();}
            catch(Exception ignore) {};
        }

        System.out.println("클라이언트 번호: " + myClientId + " : 처리 종료");
    }

}

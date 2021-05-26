package codingwithscpark.network;

import java.net.*;
import java.io.*;
import java.util.*;

public class DateServer {
    public static void main(String[] args) {
        // 9100번 port를 다른 프로그램이 이미 사용 중이면 bind 에러가 발생한다. 
        try (ServerSocket serverSocket = new ServerSocket(9100)) {
            Socket socket = null;
            while(true) {
                try {
                    System.out.println("waiting for client connection...");
                    /*  클라이언트의 연결 요청을 기다린다. 
                        클라이언트의 연결 요청이 승인되면 새로운 Socket 객체가 반환된다. 
                    */
                    socket = serverSocket.accept(); // 클라이언트 요청이 accept 될 때까지 이 메소드에 블록되어 있다. 
                    System.out.println("새로운 클라이언트 접속...["+socket.getRemoteSocketAddress()+"]");

                    // 클라이언트의 요청이 승인되면서 생성된 Socket 객체를 이용해 그 클라이언트와 통신한다. 

                    OutputStream ostream = socket.getOutputStream(); // 클라이언트에게 정보 전송을 위한 출력 스트림을 얻는다.
                    PrintWriter writer = new PrintWriter(ostream, true); // autoFlush 옵션을 true로 설정
                    writer.println(Calendar.getInstance().getTime());
                }catch(Exception e) {
                    e.printStackTrace();
                }finally {
                    socket.close();
                }
            }    
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

package codingwithscpark.network;

import java.net.*;
import java.io.*;

public class DateClient {
    public static void main(String[] args) {
        // 서버가 연결 요청을 기다리고 있는 포트로 연결을 시도.
        // 연결이 되면 Socket 객체가 반환된다. 
        try (Socket socket = new Socket("localhost", 9100)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println(line);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }    
}

package codingwithscpark.network;

import java.net.*;

import java.io.*;

public class HttpURLPostTest {
    public static void main(String[] args) {
        String site = "http://localhost:8080/board/test";
        
        try {
            URL url = new URL(site);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setDefaultUseCaches(false);
            con.setDoInput(true); // 읽기 모드 지정
            con.setDoOutput(true); // 쓰기 모드 지정
            con.setRequestMethod("POST");

            con.setRequestProperty("content-type", "application/x-www-form-urlencoded");

            // 서버로 값 전송
            StringBuffer buffer = new StringBuffer();

            buffer.append("id=scpark").append("&pw=1111");
            
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
            writer.println(buffer.toString());
            writer.flush();

            // 서버에서 값 받기
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line = "";
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        }catch(Exception e) {
            e.printStackTrace();
        } 
    }    
}

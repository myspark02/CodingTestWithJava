package codingwithscpark.fileio;

import java.io.*;

public class PrintStreamTest {
    public static void main(String[] args) {
        try(PrintStream out = new PrintStream("test2.txt")) {
            out.format("안녕 %s 오늘은 %d년 %d월 %d일이야...", "홍길동", 2021, 5, 27);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

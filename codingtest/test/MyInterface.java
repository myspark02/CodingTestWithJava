package codingtest.test;

import java.io.*;

public interface MyInterface {
    void printIt(String text);

    default public void printUtf8To(String text, OutputStream outputStream) {
        try {
            outputStream.write(text.getBytes("UTF-8"));
        }catch(IOException e) {
            throw new RuntimeException("Error writing String as UTF-8 to OutputStream", e);
        }
    }

    static void printItToSystemOut(String text) {
        System.out.println(text);
    }
}
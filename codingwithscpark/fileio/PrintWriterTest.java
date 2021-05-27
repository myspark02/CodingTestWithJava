package codingwithscpark.fileio;

import java.io.*;

public class PrintWriterTest {
    public static void main(String[] args) {
        String name = "Harry Porter";
        double age = 25;    

        try(PrintWriter writer = new PrintWriter(new FileWriter("test.txt"))) {
            writer.print(name);
            writer.print(' ');
            writer.print(age);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

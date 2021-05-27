package codingwithscpark.fileio;

import java.util.*;
import java.io.*;

public class ScannerTest2 {
    public static void main(String[] args) {
        
        double sum = 0.0;
        
        try(PrintWriter writer = new PrintWriter(new FileWriter("output.txt"), true); 
               Scanner scanner =  new Scanner(new FileReader("output.txt"))) {
        
            writer.println("9.5");
            writer.println("567,000");
            while(scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    sum += scanner.nextDouble();
                } else {
                    scanner.next();
                }
            }
            System.out.println("output.txt 파일에서 읽은 double 값의 합 :" + sum);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}

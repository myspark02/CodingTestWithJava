package codingwithscpark.fileio;

import java.io.*;
import java.util.*;

public class ScannerTest3 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new FileReader("input.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

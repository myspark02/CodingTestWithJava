package codingwithscpark.fileio;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        // copyFile1();
        // imageCopy();
        // copyFile2();
        // copyByLine();
        testCharEncoding();
    }

    public static void testCharEncoding() {
        File file = new File("input2.txt");
    //    try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
        try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
       }catch(Exception e) {
           System.out.println(e.getMessage());
       }
    }
    

    public static void copyByLine() {
        try ( BufferedReader bReader = new BufferedReader(new FileReader("input.txt"));
                PrintWriter pWriter = new PrintWriter(new FileWriter("output2.txt"))) {
            String line ;
            while ((line = bReader.readLine()) != null) {
                pWriter.println(line);
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("복사를 완료했습니다.");
    }

    public static void copyFile2() {
        try (FileReader fReader = new FileReader("input.txt"); 
                FileWriter fWriter = new FileWriter("output.txt")) {
            int c;
            while((c = fReader.read()) != -1) {
                fWriter.write(c);
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return ;
        }
        System.out.println("input.txt를 output.txt로 복사를 완료했습니다. ");
    }

    public static void imageCopy() {
        Scanner scan = new Scanner(System.in);
        System.out.println("원본 파일 이름을 입력하시오: " );
        String inputFileName = scan.nextLine();

        System.out.println("타겟 파일 이름을 입력하시오: ");
        String outputFileName = scan.nextLine();

        try (InputStream inputStream = new FileInputStream(inputFileName);
                OutputStream outputStream = new FileOutputStream(outputFileName)) {
            int c;

            while((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        
        } catch(Exception err) {
            System.out.println(err.getMessage());
            return;
        }
        System.out.println(inputFileName + "을 "+  outputFileName + "로 복사했습니다.");
        scan.close();
    }

    public static void copyFile1() {
        System.out.println("FilePath: " + new File("input.txt").getAbsolutePath());
        try (FileInputStream in = new FileInputStream ("input.txt"); 
                        FileOutputStream out = new FileOutputStream("output.txt")) {
        
            int c ;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch(IOException err) {
            System.out.println(err.getMessage());
        }
    }
}


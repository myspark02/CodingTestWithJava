package codingwithscpark.fileio;

import java.io.*;
import java.util.Date;

public class ObjectStreamTest {
    public static void main(String[] args) {
        // 출력 스트림부터 열고 입력 스트림 열기!
        // 순서를 바꾸면 입력 스트림 열 때 파일이 없기 때문에  FileNotFoundException 발생
        try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("object.dat"));
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream("object.dat"))){
                
                oout.writeObject(new Date());
                oout.flush();

                Date date = (Date)oin.readObject();
                System.out.println(date);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
     
}

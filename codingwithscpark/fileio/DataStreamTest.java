package codingwithscpark.fileio;
import java.io.*;
public class DataStreamTest {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(new FileInputStream("data.bin")); 
                DataOutputStream out = new DataOutputStream(new FileOutputStream("data.bin")) ) {
        
            out.writeDouble(3.14);
            out.writeInt(100);
            // out.writeByte(300);
            out.writeByte(120);
            // out.writeShort(65536);
            out.writeShort(5432);
            out.writeUTF("자신의 생각을 바꾸지 못하는 사람은 결코 현실을 바꿀 수 없다. ");
            // System.out.printf("%x\n", 300);
            // System.out.printf("%x\n", 65536);
           

            System.out.println(in.readDouble());
            System.out.println(in.readInt());
            System.out.println(in.readByte());
            System.out.println(in.readShort());
            System.out.println(in.readUTF());

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package codingtest.test;

import java.io.FileOutputStream;

public class LamdaExample2 {
    public static void main(String[] args) throws Exception{

        // Java lamda expression can implement interfaces with a single unimplented (abstract) method, 
        // but as many default or static methods you like.
        MyInterface myInterface = (String text) -> {
            System.out.println(text);
        };

        myInterface.printIt("Hello World");

        myInterface.printUtf8To("Hello File", new FileOutputStream("data.txt"));

        MyInterface.printItToSystemOut("Hellow Interface");
    }
}

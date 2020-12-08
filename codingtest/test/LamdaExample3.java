package codingtest.test;

public class LamdaExample3 {

    private static String thirdText = " Hey, a third text";

    private String forthText = " Fourth Text";

    public void doIt() {
        final String otherText = "Hello: " ;

        MyInterface myInterface = (text) -> {
            System.out.println(otherText + text + forthText);
        };
        
        myInterface.printIt("World");

        forthText = " Hey, I'm an instance variable ...";

        myInterface.printIt("World");
    }

    
    public static void main(String[] args) {
        final String otherText = "Hello: " ;

        MyInterface myInterface = (text) -> {
            System.out.println(otherText + text + thirdText);
        };
        
        myInterface.printIt("World");

        thirdText = " Hey, I'm changed...";

        myInterface.printIt("World");

        System.out.println("---------------------------------");

        LamdaExample3 le3 = new LamdaExample3();

        le3.doIt();
    }
    
}

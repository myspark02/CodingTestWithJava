package codingtest.test.javaswitch;

public class SwitchExample {

    public static void main(String[] args) {
        //  switchOnEnum(Size.SMALL);
        // char digitInHex = numericSwitchExpression(12);
        // System.out.println(digitInHex);
    }

    // private static char numericSwitchExpression(int digitalInDecimal) {
    //     char digitInHex = 
    //         switch(digitalInDecimal) {
    //             case  0 -> '0';
    //             case  1 -> '1';
    //             case  2 -> '2';
    //             case  3 -> '3';
    //             case  4 -> '4';
    //             case  5 -> '5';
    //             case  6 -> '6';
    //             case  7 -> '7';
    //             case  8 -> '8';
    //             case  9 -> '9';
    //             case 10 -> 'A';
    //             case 11 -> 'B';
    //             case 12 -> 'C';
    //             case 13 -> 'D';
    //             case 14 -> 'E';
    //             case 15 -> 'F';

    //             default ->  '?';

    //         };
    //     return digitInHex;    
    // }

    private static void switchOnEnum(Size size) {
        switch(size) {
            case SMALL : System.out.println("size is small"); break;
            case MEDIUM : System.out.println("size is medium"); break;
            case LARGE : System.out.println("size is large"); break;
            case X_LARGE : System.out.println("size is x-large"); break;
        }
    }


    private static enum Size {
        SMALL, MEDIUM, LARGE, X_LARGE
    }
    
}

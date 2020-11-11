package codingtest.test;

import java.util.Scanner;

public class Practice {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //testAlaram();
        //testFor();
        //printStars01();
        printStars02();
        
    }   
    
    private static void testAlaram() {
        int h, m;

        h = input.nextInt();
        m = input.nextInt();

        /*
            m >= 45 이면
                h (m-45)
            그렇지 않으면
                만약 h가 0이면 h = 24
            (h-1) 60-(45-m)
        */

        if (m >= 45) {
            System.out.println(h + " " + (m-45));
        }
        else {
            if (h == 0) h = 24;
            System.out.println((h-1) + " " + (60-(45-m)));
        }
    }

    private static void testFor() {
        int n, x;
        n = input.nextInt();
        x = input.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < x) {
                System.out.print(nums[i] + " ");
            }
        }
        System.out.println();
    }

    private static void printStars01() {
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= (n-1-i)) 
                    System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void printStars02() {
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= i) 
                    System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }   
}

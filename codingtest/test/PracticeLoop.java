package codingtest.test;

import java.util.Scanner;

public class PracticeLoop {
    private static Scanner input = new Scanner(System.in);
        
    public static void main(String[] args) {
        //test01();
        cycleAdd();
    }

    private static void test01() {
        int count = input.nextInt();

        for (int i = 0; i < count ; i++) {
            int num1 = input.nextInt();
            int num2 = input.nextInt();
            System.out.println(num1+num2);
        }
    }

    private static void cycleAdd() {
        int num = input.nextInt();
        int org = num;
        int cnt = 0; 
        int sum = -1;
        int left, right;
        while (true) {
            if (num < 10) {
                left = 0; 
                right = num;
            } else {
                left = num/10;
                right = num%10;
            }
            sum = left+right;
            
            if (sum < 10) {
                num = right*10 + sum;
            } else {
                num = right*10 + sum%10;
            }
            cnt++;
            if (num == org) break;
        }
        System.out.println(cnt);

    }
}
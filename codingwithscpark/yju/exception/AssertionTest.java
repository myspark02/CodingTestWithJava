package codingwithscpark.yju.exception;

import java.util.Scanner;

public class AssertionTest {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // System.out.print("날짜를 입력하시오:");
        // int date = input.nextInt();

        // assert date >=1 && date <= 31 : "잘못된 날짜: " + date;
        
        // System.out.printf("입력된 날짜는 %d 입니다.\n", date);

        int[] nums = {0, 3, 4, 6};
        System.out.println(sumArray(nums));
    }

    public static int sumArray(int[] nums) {
        assert nums != null : "array is null!";
        assert nums.length > 0 : "No element in array";
        assert nums[0] > 1 : "The first element must be larger than 1";
        int total = 0;

        for (int i = 0; i < nums.length; i++) 
            total += nums[i];

        return total;
    }
}

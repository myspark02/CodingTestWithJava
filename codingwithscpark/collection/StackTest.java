package codingwithscpark.collection;

import java.util.*;
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < 10; i++) {
            stack.push(String.valueOf((char)('A'+i)));
        }

        System.out.println(stack);

        System.out.println("다음에 인출될 원소는 " + stack.peek());
        System.out.println(stack);

        System.out.println("인출시작");

        int size = stack.size();
        for (int i = 0; i < size; i++) 
            System.out.print(stack.pop() + " ");
        
        System.out.println("\n인출끝");

        System.out.println(stack);

    }
}

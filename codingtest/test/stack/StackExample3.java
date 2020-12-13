package codingtest.test.stack;

import java.util.*;

public class StackExample3 {
    public static void main(String[] args) {
        // Stack<String> stack = new Stack<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push("one");
        stack.push("two");

        String two = stack.pop();
        String one = stack.peek();

        // int distanceFromTop = stack.search("one");

        System.out.println(two);
        System.out.println(one);
        // System.out.println(distanceFromTop);
    }
    
}

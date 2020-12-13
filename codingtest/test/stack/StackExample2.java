package codingtest.test.stack;

import java.util.*;

public class StackExample2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println(list);

        
        while(list.size() > 0) {
            stack.push(list.remove(0));
        }

        while(stack.size() > 0) {
            list.add(stack.pop());
        }

        System.out.println(list);
    }
    
}

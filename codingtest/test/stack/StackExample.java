package codingtest.test.stack;

import java.util.*;

public class StackExample {
    public static void main(String[]  args)  {
        Stack<String> stack = new Stack<>();
        
        stack.push("one");
        int distanceFromTop1 = stack.search("one"); // top is 1

        stack.push("two");
        int distanceFromTop2 = stack.search("one"); // top is 1

        stack.push("three");
        int distanceFromTop3 = stack.search("one"); // top is 1

        System.out.println(distanceFromTop1);
        System.out.println(distanceFromTop2);
        System.out.println(distanceFromTop3);

        System.out.println("\n#################");
        Iterator<String> iter = stack.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        System.out.println("\n#################");
        for (String elem : stack) {
            System.out.println(elem);
        }

        System.out.println("\n#################");
        stack.stream().forEach(System.out::println);
    }
    
}

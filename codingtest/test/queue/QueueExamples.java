package codingtest.test.queue;

import java.util.*;

public class QueueExamples {
    public static void main(String[] args) {
        // Queue<String> queue = new LinkedList<>();

        // queue.add("Anna");
        // queue.add("Nick");

        // String anna = queue.poll();
        // String nick = queue.poll();

        // System.out.println(anna);
        // System.out.println(nick);

        // example02();
        example03();

    }    

    private static void example03() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Patricia");
        queue.offer("John");

        System.out.println("\n##################");
        Iterator<String> iter = queue.iterator();
        while(iter.hasNext()) {
            String elem = iter.next();
            System.out.println(elem);
        }
        
        System.out.println("\n##################");
        for (String elem : queue) {
            System.out.println(elem);
        }

        System.out.println("\n##################");
        queue.stream().forEach(System.out::println);

    }

    private static void example02() {
        Queue<String> queue1 = new LinkedList<>();
        queue1.add("Joanna");
        queue1.add("Rick");


        Queue<String> queue2 = new ArrayDeque();
        queue2.offer("Joanna");
        queue2.offer("Rick");

        Queue<String> queue3 = new PriorityQueue<>();
        queue3.offer("Joanna");
        queue3.offer("Rick");

        System.out.println(queue1);
        System.out.println(queue2);
        System.out.println(queue3);
        
        String customer1 = queue3.peek();
        System.out.println(queue3.size());

        customer1 = queue3.poll();
        String customer2 = queue3.remove();

        System.out.println(customer1);
        System.out.println(customer2);

        System.out.println(queue3.size());

        queue2.clear();

        System.out.println(queue2);
        System.out.println(queue2.size());

        System.out.println(queue1.contains("Joanna"));
        System.out.println(queue1.contains("Jhon"));


    }
}

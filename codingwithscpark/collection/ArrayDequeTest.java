package codingwithscpark.collection;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayDequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Random rand = new Random(System.currentTimeMillis());

        IntStream.rangeClosed(1, 20).forEach(i -> {
            deque.add(rand.nextInt(100) + 1);
        });
        System.out.println(deque);
        while(deque.size() > 0) {
            // System.out.print(deque.pop() + " ");
            // System.out.print(deque.poll() + " ");
            System.out.print(deque.pollFirst() + " ");
            // System.out.print(deque.pollLast() + " ");
        } 
        System.out.println();

    }
}

package codingwithscpark.collection;

import java.util.*;

public class PriorityQueueTest {
    public static void main(String[] args) {
        MyComparator comparator = new MyComparator();
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(comparator);
        pqueue.add(30);
        pqueue.add(80);
        pqueue.add(20);

        for (int n : pqueue)
            System.out.println(n);

        System.out.println("원소 삭제");
        System.out.println(pqueue.comparator());

        while (!pqueue.isEmpty())
            System.out.println(pqueue.remove());

        PriorityQueueTest test = new PriorityQueueTest();
        System.out.println(test.hashCode());
    }
}

class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        int result = (int) o2 - (int) o1;
        return result;
    }

}

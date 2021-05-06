package codingwithscpark.collection;

import java.util.*;

public class PriorityQueueTest2 {
    public static void main(String[] args) {
        test1();
    }
    private static void test1() {
        PriorityQueue<Task> queue = new PriorityQueue<>();

        queue.offer(new Task("Print Doc1", 5));
        queue.offer(new Task("Print Doc2", 5));
        queue.offer(new Task("Print Doc3", 5));
        queue.offer(new Task("Print Doc4", 5));
        queue.offer(new Task("Print Doc5", 5));
        queue.offer(new Task("Print Doc6", 5));
        queue.offer(new Task("Print Doc7", 5));
        queue.offer(new Task("Print Doc8", 5));
        queue.offer(new Task("Print Doc9", 3));
        queue.offer(new Task("Print Doc10", 1));

 
        while(queue.isEmpty() == false) {
            System.out.println(queue.poll());       
                
        }
    }
}

class Task implements Comparable<Task> {
    String desc ;
    int priority;
    public Task() {
        this.desc = "Normal Task";
        priority = 5;
    }
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }
    @Override
    public String toString() {
        return "(desc:"+desc+", priority:"+priority+")";
    }
    @Override
    public int compareTo(Task o) {
        
        return this.priority -  o.priority;
    }

}

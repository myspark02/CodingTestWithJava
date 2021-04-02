package codingwithscpark.yju.thread;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Test {
    private static int sum = 0;
    public static void main(String[] args) {
        // testExecutorService();
        // testParallelStream();
        testForkJoinPool();
        
    }

    public static void testForkJoinPool() {
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1, 100).forEach(i -> list.add(i));

        ForkJoinPool forkjoinPool = new ForkJoinPool(5);
        try {
                forkjoinPool.submit(() -> {
                list.parallelStream().forEach(index -> {
                    System.out.println("Thread : " + Thread.currentThread().getName() + ", index =" + index + ", " + new Date());
                    sum += index;
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                    }
                });
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("sum:" + sum);
    }

    public static void testParallelStream() {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","6");
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1, 100).forEach(i -> list.add(i));
    
        list.parallelStream().forEach(index -> {
            System.out.println("Starting " + Thread.currentThread().getName() 
                + ", index=" + index + ", " + new Date());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
        });
    }

    public static void testExecutorService() {
        ArrayList<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1, 100).forEach(i -> list.add(i));
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < list.size(); i++) {
            final int index = i;
            executor.submit(() -> {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                }    
                System.out.println(Thread.currentThread().getName() 
                    + ", index=" + index + ", ended at " + new Date()); 	 
            });
        }       
        executor.shutdown();
    }
}

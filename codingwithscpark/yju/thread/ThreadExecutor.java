package codingwithscpark.yju.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadExecutor {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            for (int i = 0; i <= 10; i++) 
                System.out.println("첫 번째 쓰레드:" + i);
            System.out.println("첫 번째 쓰레드 종료...");
        };

        Runnable r2 = () -> {
            for (int i = 10; i >= 0; i--) 
                System.out.println("두 번째 쓰레드:" + i);
            System.out.println("두 번째 쓰레드 종료...");    
        };

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(r1);
        executor.execute(r2);
    }
    
}

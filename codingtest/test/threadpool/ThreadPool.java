package codingtest.test.threadpool;

import java.util.*;
import java.util.concurrent.*;
public class ThreadPool {

    private BlockingQueue<Runnable> taskQueue = null;

    private List<PoolThreadRunnable> runnables = new ArrayList<>();

    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue  = new ArrayBlockingQueue<>(maxNoOfTasks);

        for (int i = 0; i < noOfThreads; i++) {
            PoolThreadRunnable PoolThreadRunnable = new PoolThreadRunnable(taskQueue);
            runnables.add(PoolThreadRunnable);
        }

        for(PoolThreadRunnable runnable : runnables) {
            new Thread(runnable).start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception {
        if (this.isStopped) throw new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.offer(task);
    }

    public synchronized void stop() {
        this.isStopped = true;

        for (PoolThreadRunnable runnable : runnables) {
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while(this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);;
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

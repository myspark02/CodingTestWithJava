package codingtest.test.threadpool;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable {
    private Thread thread = null;
    private BlockingQueue<Runnable> taskQueue = null;
    private boolean isStopped = false;
    

    public PoolThreadRunnable(BlockingQueue queue) {
        taskQueue = queue;
    }

    public void run() {
        this.thread = Thread.currentThread();
        while(!isStopped()) {
            try {
                Runnable runnable = taskQueue.take();
                runnable.run();
            }catch(Exception e) {
                // e.printStackTrace();
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        // break pool thread out of dequeue() call.
        this.thread.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}

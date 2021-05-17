package codingwithscpark.yju.thread;

public class CounterTestThread extends Thread {
    private Counter counter;

    public CounterTestThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        int i = 0;
        while (i < 20000) {
            counter.inc();
            counter.desc();
            // if (i % 40 == 0) {
            //     counter.print();
            // }
            // try {
            //     Thread.sleep((int) (Math.random() * 2));
            // } catch (InterruptedException e) {
            // }
            i++;
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new CounterTestThread(counter);
        Thread thread2 = new CounterTestThread(counter);
        Thread thread3 = new CounterTestThread(counter);
        Thread thread4 = new CounterTestThread(counter);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
        }
        System.out.println("After all threads finished.... :" + counter.getValue());
    }
}

class Counter {
    private int value = 0;
    public int getValue() {
        return value;
    }

    public synchronized void inc() {
        value++;
    }

    public synchronized void desc() {
        value--;
    }

    public void print() {
        System.out.println(value);
    }
}
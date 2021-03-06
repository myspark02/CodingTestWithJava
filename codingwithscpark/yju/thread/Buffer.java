package codingwithscpark.yju.thread;

public class Buffer {
    private int data;
    private boolean empty = true;

    public synchronized int get() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("[get]interrupted wait");
            }
        }
        empty = true;
        notifyAll();
        System.out.println("소비자[" + Thread.currentThread().getName() + "]: " + data + "번째 케익을  소비하였습니다.");
        return data;
    }

    public synchronized void put(int data) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("[put] interrupted wait");
            }
        }
        empty = false;
        this.data = data;
        System.out.println("생산자 [" + Thread.currentThread().getName() + "]: " + data + "번째 케익을  생산하였습니다.");
        notifyAll();
    }

    // public synchronized int get() {
    // return data;
    // }

    // public synchronized void put(int data) {
    // this.data = data;
    // }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread t1 = new Thread(new Producer(buffer, 0));
        Thread t2 = new Thread(new Consumer(buffer, 1));
        Thread t3 = new Thread(new Consumer(buffer, 2));
        t1.start();
        t2.start();
        t3.start();
    }
}

class Producer implements Runnable {
    private Buffer buffer;
    private int id;

    public Producer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
        Thread.currentThread().setName(String.valueOf(id));
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            buffer.put(i);
            // System.out.println("생산자["+id+"]: " + i + "번째 케익을 생산하였습니다.") ;
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("[producer] interrupted sleep");
            }
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;
    private int id;

    public Consumer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
        Thread.currentThread().setName(String.valueOf(id));
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            int data = buffer.get();
            // System.out.println("소비자["+id+"]: " + data + "번째 케익을 소비하였습니다.") ;
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("[consumer] interrupted sleep");
            }
        }
    }
}

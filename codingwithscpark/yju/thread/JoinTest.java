package codingwithscpark.yju.thread;

public class JoinTest implements Runnable {
    private int sum = 0;
    private int start;
    private int end;
    private String name;

    public int getSum() {
        return sum;
    }

    public JoinTest(String name, int start, int end) {
        this.start = start;
        this.end = end;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
            if (i % 100 == 0) {
                try {
                    Thread.sleep(300);
                }catch(InterruptedException e) {

                }
                System.out.println("["+name+"] working....");
            }
        }
        System.out.println("["+name+"] terminating....");
    }

    public static void main(String[] args) {
        JoinTest worker1 = new JoinTest("Worker1", 501, 1500);
        JoinTest worker2 = new JoinTest("Worker2", 1501, 2000);

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);

        t1.start();
        t2.start();

        int sum = 0;
        for (int i  = 1; i <= 500; i++) {
            sum += i;
        }

        try {
            t1.join();
            sum += worker1.getSum();
            t2.join();
            sum += worker2.getSum();
        }catch(Exception e) {

        }
        System.out.println("1에서 2000까지의 합:" + sum);
    }
    
}

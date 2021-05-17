package codingwithscpark.yju.thread;

public class DaemonThreadTest implements Runnable{
    static boolean autoSave = false;

    public void run() {
        while(true) {
            try {
                Thread.sleep(2*1000);
            }catch(InterruptedException e) {

            }
            System.out.println("[daemon thread] checking autosave....");
            if (autoSave)  autoSave();
        }
       
    }

    private void autoSave() {
        System.out.println("[daemon thread] 작업 파일이 자동 저장되었습니다.");
        autoSave = false;
    }

    public static void main(String[] args) {
        Runnable runnable = new DaemonThreadTest();
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {

            }
            System.out.println(i);

            if (i%5 == 0) autoSave = true;
        }
        System.out.println("프로그램을 종료합니다");
    }
    
}

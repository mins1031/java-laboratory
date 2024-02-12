package java_lab._동시성._volatile_atomic;

public class Start extends Thread{

    static int share;

    public static void main(String[] args) {
        Start thread1 = new Start();
        Start thread2 = new Start();

        thread1.start();
        thread2.start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(share++);

            try {
                sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

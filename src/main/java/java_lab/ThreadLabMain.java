package java_lab;

import java.util.concurrent.TimeUnit;

public class ThreadLabMain {
    public int mainMemoryInt = 10;
    private static boolean stopRequested = true;

    public static void main(String[] args) throws InterruptedException {
        Thread background = new Thread(() -> {
            for (int i = 0; !stopRequested ; i++);
            System.out.println("background 쓰레드가 종료되었습니다!");
        });

        background.start(); // (A)

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true; // (B)
        System.out.println("main 쓰레드가 종료되었습니다!");
    }
}


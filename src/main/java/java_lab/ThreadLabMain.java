package java_lab;

import java.util.concurrent.TimeUnit;

public class ThreadLabMain {
    public static Integer mainMemoryInt = 10;
    private static boolean stopRequested = true;

    public static void main(String[] args) throws InterruptedException {
//        threadRun();
        new Thread(() -> {
            for (int i = 0; i < 1000 ; i++) {
                mainMemoryInt += 2;
            }
            System.out.println("1 = " +mainMemoryInt);
            System.out.println("background 쓰레드1가 종료되었습니다!");
        }).start();

        System.out.println("1 main = " + mainMemoryInt);
        Thread.sleep(10);
        System.out.println("2 = " + mainMemoryInt);
        System.out.println("main down");
    }

    private static void threadRun() throws InterruptedException {
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


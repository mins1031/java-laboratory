package java_lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadLabMainTest {
    ThreadLabMain threadLabMain = new ThreadLabMain();
    public boolean mainMemoryInt = false;

    @Test
    public void name() throws InterruptedException {
        //given

        //when
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                if (mainMemoryInt) {
                    System.out.println("break!!");
                    break;
                }
            }
            System.out.println("background 쓰레드가 종료되었습니다!");
        }).start();

        Thread.sleep(1000);
        mainMemoryInt = true;
    }

    static long count = 0;

    @Test
    void threadNotSafe() throws InterruptedException {
        int maxCnt = 10;

        for (int i = 0; i < maxCnt; i++) {
            new Thread(() -> {
                count++;
                System.out.println(count);
            }).start();
        }

        Thread.sleep(100); // 모든 스레드가 종료될 때까지 잠깐 대기
        Assertions.assertEquals(count,maxCnt);
    }

    @DisplayName("Runnable과 Thread")
    @Test
    void 스레드_테스트() {
        RunnableSample runnableSample = new RunnableSample();
        ThreadSample threadSample = new ThreadSample();

        new Thread(runnableSample).start();
        threadSample.start();

        System.out.println("테스트 메서드 종료.");
    }

    public class RunnableSample implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableSample 클래스 run() 실행");
        }
    }

    public class ThreadSample extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadSample 클래스 run() 실행");
        }
    }
}
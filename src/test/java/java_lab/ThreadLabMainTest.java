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
}
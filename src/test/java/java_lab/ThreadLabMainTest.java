package java_lab;

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

}
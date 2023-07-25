package java_lab._동시성._volatile_atomic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class SafeCounterWithLockTest {

    @DisplayName("동기화가 없는 경우 세개의 스레드의 연산결과가 보장되는가")
    @Test
    public void synchronized가_없음() throws InterruptedException {
        //given
        NormalCounter normalCounter = new NormalCounter();

        Thread a = new Thread(() -> {
            for (int i = 0; i<3000; i++) {
                normalCounter.increment();
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i<3000; i++) {
                normalCounter.increment();
            }
        });

        Thread c = new Thread(() -> {
            for (int i = 0; i<3000; i++) {
                normalCounter.increment();
            }
        });


        //when
        a.start();
        b.start();
        c.start();

        //then
        Thread.sleep(1000);
        Assertions.assertEquals(9000, normalCounter.getCounter());
        System.out.println("plus counter value = " + normalCounter.getCounter());
    }

    @DisplayName("동기화가 있는 경우 세개의 스레드의 연산결과가 보장되는가")
    @Test
    public void synchronized가_있음() throws InterruptedException {
        //given
        SafeCounterWithLock safeCounterWithLock = new SafeCounterWithLock();

        Thread a = new Thread(() -> {
            for (int i = 0; i<3000; i++) {
                safeCounterWithLock.increment();
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i<3000; i++) {
                safeCounterWithLock.increment();
            }
        });
        Thread c = new Thread(() -> {
            for (int i = 0; i<3000; i++) {
                safeCounterWithLock.increment();
            }
        });


        //when
        a.start();
        b.start();
        c.start();

        //then
        Thread.sleep(1000);
        Assertions.assertEquals(9000, safeCounterWithLock.getCounter());
        System.out.println("plus counter value = " + safeCounterWithLock.getCounter());
    }

    @DisplayName("volatile 변수로 선언한 경우 세개의 스레드의 연산결과가 보장되는가")
    @Test
    public void volatilet로_선언() throws InterruptedException {
        //given
//        SafeCounterWithLock safeCounterWithLock = new SafeCounterWithLock();
//
//        Thread a = new Thread(() -> {
//            for (int i = 0; i<1000; i++) {
//                safeCounterWithLock.decrement();
//            }
//        });
//        Thread b = new Thread(() -> {
//            for (int i = 0; i<1000; i++) {
//                safeCounterWithLock.decrement();
//            }
//        });
//        Thread c = new Thread(() -> {
//            for (int i = 0; i<1000; i++) {
//                safeCounterWithLock.decrement();
//            }
//        });
//
//
//        //when
//        a.start();
//        b.start();
//        c.start();
//
//        //then
//        Thread.sleep(1000);
//        Assertions.assertEquals(3000, safeCounterWithLock.getCounter());
//        System.out.println("plus counter value = " + safeCounterWithLock.getCounter());

        //TODO volatile은 이런 테스트가 의마가 없다. 당연히 연산은 보장됨. 다만 a스레드에서 수행한수 해당 값으로 어떤 작업을 수행해야했을때
        // 1000값으로 진행되야했지만 b,c 스레드에 의해 3000값으로 다른 작업을 수행하게 되므로 데이터의 불일치 현상이 발생할 수 있음.
        // 그러므로 해당 테스트는 의미가 x
    }
}
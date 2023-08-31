package java_lab.reference;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SoftCacheMain {
    static SoftCache<UUID, TestContent> softCache = new SoftCache<>();
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        String key = UUID.randomUUID().toString();
//        TestContent content = new TestContent(random.nextInt(5000001));
//        for (int i = 0; i < 10_000_000; i++) {
//            TestContent content = new TestContent(random.nextInt(5000001));
//            softCache.put(i++, content);
//        }
        SoftCacheLoop softCacheLoop = new SoftCacheLoop();
        for (int i = 0; i < 100; i++) {
            System.out.println("cache size = " + softCache.size());
            if (i % 10 == 0) {
                System.out.println(i);
            }
            softCacheLoop.first_loop();
        }

    }

    public static class SoftCacheLoop {
        public void first_loop() {
            for (int i = 0; i < 10000; i++) {
                second_loop();
            }
        }

        private void second_loop() {
            for (int i = 0; i < 10; i++) {
                UUID key = UUID.randomUUID();
                TestContent value = new TestContent(random.nextInt());
                softCache.put(key, value);
            }
        }

    }

}

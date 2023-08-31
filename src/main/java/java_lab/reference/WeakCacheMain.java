package java_lab.reference;

import java.util.Random;
import java.util.UUID;

public class WeakCacheMain {
    static WeakCache<String, TestContent> weakCache = new WeakCache<>();
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 10_000_000; i++) {
//            TestContent content = new TestContent(random.nextInt(5000001));
//            weakCache.put(i++, content);
//        }

        for (int i = 0; i < 100; i++) {
            System.out.println("cache size = " + weakCache.size());
            if (i % 10 == 0) {
                Thread.sleep(500);
                System.out.println(i);
            }
            first_loop();
        }
        System.out.println("last cache size = " + weakCache.size());
    }

    public static void first_loop() {
        for (int i = 0; i < 10000; i++) {
            second_loop();
        }
    }

    private static void second_loop() {
        for (int i = 0; i < 10; i++) {
            String key = UUID.randomUUID().toString();
            TestContent value = new TestContent(random.nextInt());
            weakCache.put(key, value);
        }
    }
}

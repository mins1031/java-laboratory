package java_lab.reference;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SoftCacheMain {
    static SoftCache<String, TestContent> softCache = new SoftCache<>();

    public static void main(String[] args) {
        Random random = new Random();
        String key = UUID.randomUUID().toString();
        TestContent content = new TestContent(random.nextInt(5000001));
        for (int i = 0; i < 10_000_000; i++) {
            softCache.put(key, content);
        }
//        for (int i = 0; i < 100; i++) {
//            first_loop();
//        }

    }

    public static void first_loop() {
        for (int i = 0; i < 100; i++) {
            second_loop();
        }

        for (int i = 0; i < 100; i++) {
            second_loop();
        }
    }

    private static void second_loop() {
        for (int i = 0; i < 10; i++) {
            String key = UUID.randomUUID().toString();
            TestContent value = new TestContent((int) Math.random());
            softCache.put(key, value);
        }
    }
}

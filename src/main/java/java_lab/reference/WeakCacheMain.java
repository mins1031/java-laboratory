package java_lab.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class WeakCacheMain {
    static WeakCache<String, TestContent> weakCache = new WeakCache<>();

    public static void main(String[] args) {
        WeakCacheMain weakCacheMain = new WeakCacheMain();
        for (int i = 0; i < 500; i++) {
            weakCacheMain.first_loop();
            if (i == 250) {
                System.out.println("250");
            }

            if (i == 400) {
                System.out.println("400");
            }
        }
    }

    private void first_loop() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            List<String> keys = new ArrayList<>();
            List<TestContent> values = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                keys.add(UUID.randomUUID().toString());
                values.add(new TestContent(random.nextInt(5000001)));
            }

            second_loop(keys, values);
            keys = null;
            values = null;
        }

//        for (int i = 0; i < 100; i++) {
//            second_loop();
//        }
    }

    private void second_loop(List<String> keys, List<TestContent> values) {
        for (int i = 0; i < 100; i++) {
            weakCache.put(keys.get(i), values.get(i));
        }
    }

    private void second_loop() {
        for (int i = 0; i < 100; i++) {
            String key = UUID.randomUUID().toString();
            Random random = new Random();
            int value = random.nextInt(5000001);
//            WeakCacheContent<String, Integer> value = new WeakCacheContent<>(key, value);
//            weakCache.put(key, value);
        }
    }
}

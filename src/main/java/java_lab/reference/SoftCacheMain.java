package java_lab.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SoftCacheMain {
    static SoftCache<String, Integer> weakCache = new SoftCache<>();

    public static void main(String[] args) {
        SoftCacheMain softCacheMain = new SoftCacheMain();
        for (int i = 0; i < 500; i++) {
            softCacheMain.first_loop();
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
//        for (int i = 0; i < 100; i++) {
//            List<WeakCacheContent<String, Integer>> value = new ArrayList<>();
//            for (int j = 0; j < 100; j++) {
//                String key = UUID.randomUUID().toString();
//                value.add(new WeakCacheContent<>(key, random.nextInt(5000001)));
//            }
//
//            second_loop(value);
//            value = null;
//        }

        for (int i = 0; i < 100; i++) {
            second_loop();
        }
    }

    private void second_loop(List<WeakCacheContent<String, Integer>> value) {
        for (WeakCacheContent<String, Integer> integerWeakCacheContent : value) {
            weakCache.put(integerWeakCacheContent.getKey(), integerWeakCacheContent);
        }
    }

    private void second_loop() {
//        for (int i = 0; i < 100; i++) {
//            String key = UUID.randomUUID().toString();
//            Random random = new Random();
//            WeakCacheContent<String, Integer> value = new WeakCacheContent<>(key, random.nextInt(5000001));
//            weakCache.put(key, value);
//        }
    }
}

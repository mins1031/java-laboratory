package java_lab.reference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.UUID;

class WeakCacheTest {
    WeakCache<String, Integer> weakCache = new WeakCache<>();
    Random random = new Random();

    @Test
    void weakCache_OOM_Test() {
        for (int i = 0; i < 500; i++) {
            first_loop();
        }
    }

    private void first_loop() {
        for (int i = 0; i < 100; i++) {
            second_loop();
        }
    }

    private void second_loop() {
        for (int i = 0; i < 100; i++) {
            String key = UUID.randomUUID().toString();
            WeakCacheContent<Integer> value = new WeakCacheContent<>(random.nextInt(5000001));
            weakCache.put(key, value);
        }
    }

    @Test
    void weakCache_Test() throws InterruptedException {
        WeakCacheContent<Integer> min = new WeakCacheContent<>(1014);
        WeakCacheContent<Integer> gang = new WeakCacheContent<>(0612);
        WeakCacheContent<Integer> pyo = new WeakCacheContent<>(1217);
        weakCache.put("min", min);
        weakCache.put("gang", gang);
        weakCache.put("pyo", pyo);
        weakCache.displayCache();
        System.out.println("first display weakCache end!");

        gang = null;
        weakCache.displayCache();
        System.out.println("second display weakCache end!");
        Assertions.assertEquals(weakCache.size(), 3);
        Assertions.assertNotNull(weakCache.get("gang").getValue());

        System.gc();
        Thread.sleep(2000);

        weakCache.displayCache();
        System.out.println("third display weakCache end!");
        Assertions.assertEquals(weakCache.size(), 3);
        Assertions.assertNull(weakCache.get("gang"));
        Assertions.assertNotNull(weakCache.get("min"));
        Assertions.assertNotNull(weakCache.get("pyo"));

        Thread.sleep(5000);
        Assertions.assertEquals(weakCache.size(), 3);
    }
}
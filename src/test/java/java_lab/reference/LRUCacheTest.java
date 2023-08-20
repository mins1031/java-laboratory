package java_lab.reference;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


class LRUCacheTest {
    static Map<String, CacheContent<String, Integer>> normalMap = new HashMap<>();
    Random random = new Random();

    LRUCache lruCache = new LRUCache(20);

    @Test
    public void normal_HashMap_OOM_Test() throws InterruptedException {
        Thread.sleep(3000);
        for (int i = 0; i < 5000000; i++) {
            String key = UUID.randomUUID().toString();
            int value = random.nextInt();
            normalMap.put(key, new CacheContent<>(key, value));
        }
    }

    @Test
    public void LRUCache_OOM_Test() {
        for (int i = 0; i < 5000000; i++) {
            String key = UUID.randomUUID().toString();
            int value = random.nextInt();
            lruCache.put(key, new CacheContent<>(key, value));
        }
    }

    @Test
    public void LRUCache_Test() {
        LRUCache<String, String> objectObjectLRUCache = new LRUCache<>(3);
        objectObjectLRUCache.put("min", "1014");
        objectObjectLRUCache.put("gang", "0612");
        objectObjectLRUCache.put("pyo", "1217");
        objectObjectLRUCache.get("min");

        objectObjectLRUCache.displayPriority();
        System.out.println("first displayPriority end!");

        objectObjectLRUCache.put("yeon", "0828");
        objectObjectLRUCache.displayPriority();
    }
}
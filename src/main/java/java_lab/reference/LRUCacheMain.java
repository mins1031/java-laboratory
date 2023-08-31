package java_lab.reference;

import java.util.Random;
import java.util.UUID;

public class LRUCacheMain {
    static LRUCache lruCache = new LRUCache(200);

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Thread.sleep(5000);
        for (int i = 0; i < 10_000_000; i++) {
            String key = UUID.randomUUID().toString();
            int value = random.nextInt();
            lruCache.put(key, new CacheContent<>(key, value));
        }
    }
}

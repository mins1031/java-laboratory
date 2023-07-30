package java_lab.staticlap;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class TotalCacheMain {

    public static void main(String[] args) throws InterruptedException {
        HashMap<UUID, Cache> staticCacheMap = ViewCountCache.cacheMap;
        HashMap<UUID, Cache> normalCacheMap = new HashMap();
        Random random = new Random();
        //1
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        //2
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        Thread.sleep(1000);
        //3
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        //4
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        Thread.sleep(1000);
        //5
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        //6
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        //7
        Thread.sleep(1000);
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        //8
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        //9
        Thread.sleep(1000);
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        //10
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        System.out.println(staticCacheMap.size());
    }
}

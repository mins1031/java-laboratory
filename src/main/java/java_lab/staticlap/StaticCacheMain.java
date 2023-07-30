package java_lab.staticlap;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class StaticCacheMain {
    public static HashMap<UUID, Cache> staticCacheMap = new HashMap();

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        //1
        for (int i = 0; i < 200000; i++) {
            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        Thread.sleep(1000);
//

        System.out.println(staticCacheMap.size());
    }


    //2
//        for (int i = 0; i < 200000; i++) {
//            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//        }
//
//        Thread.sleep(1000);
//        //3
//        for (int i = 0; i < 200000; i++) {
//            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//        }
//
//        Thread.sleep(1000);
//        //4
//        for (int i = 0; i < 200000; i++) {
//            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//        }
//
//        Thread.sleep(1000);
//        //5
//        for (int i = 0; i < 200000; i++) {
//            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//        }
//
//        Thread.sleep(1000);
//        //6
//        for (int i = 0; i < 200000; i++) {
//            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//        }
//
//        //7
//        Thread.sleep(1000);
//        for (int i = 0; i < 200000; i++) {
//            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//        }
//
//        //8
//        Thread.sleep(1000);
//        for (int i = 0; i < 200000; i++) {
//            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//        }
//
//        //9
//        Thread.sleep(1000);
//        for (int i = 0; i < 200000; i++) {
//            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//        }
//
//        //10
//        for (int i = 0; i < 200000; i++) {
//            staticCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//        }
}

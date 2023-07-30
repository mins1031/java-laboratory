package java_lab.staticlap;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class NormalCacheMain {
    public HashMap<UUID, Cache> normalCacheMap = new HashMap();

    public static void main(String[] args) throws InterruptedException {
        HashMap<UUID, Cache> normalCacheMap = new HashMap();
        Random random = new Random();
        //1
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        Thread.sleep(1000);
        //2
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        //3
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        Thread.sleep(1000);
        //4
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        //5
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        System.out.println(normalCacheMap.size());
    }

//    //2
//        for (int i = 0; i < 200000; i++) {
//        normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//    }
//
//    //3
//        for (int i = 0; i < 200000; i++) {
//        normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//    }
//
//        Thread.sleep(1000);
//    //4
//        for (int i = 0; i < 200000; i++) {
//        normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//    }
//
//    //5
//        for (int i = 0; i < 200000; i++) {
//        normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//    }
//
//        Thread.sleep(1000);
//    //6
//        for (int i = 0; i < 200000; i++) {
//        normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//    }
//
//    //7
//        for (int i = 0; i < 200000; i++) {
//        normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//    }
//
//    //8
//        Thread.sleep(1000);
//        for (int i = 0; i < 200000; i++) {
//        normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//    }
//
//    //9
//        for (int i = 0; i < 200000; i++) {
//        normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//    }
//
//    //10
//        for (int i = 0; i < 200000; i++) {
//        normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
//    }
}

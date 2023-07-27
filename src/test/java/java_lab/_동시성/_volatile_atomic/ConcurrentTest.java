package java_lab._동시성._volatile_atomic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ConcurrentTest {

    //    private Map<String, Integer> productHashMap = new HashMap<>();
//    private Map<String, Integer> productHashMap = new Hashtable<>();
    private Map<String, Integer> productConcurrentHashMap = new ConcurrentHashMap<>(3);
    private Map<String, Integer> productHashMap = Collections.synchronizedMap(new HashMap<>(3));

    private String bed = "침대";
    private int startBedCount = 1;
    private String chair = "의자";
    private int startChairCount = 2;
    private String table = "식탁";
    private int startTableCount = 3;
    private String test = "test";
    private int testCount = 4;

    @BeforeEach
    void setUp() {
        productHashMap.put(bed, startBedCount);
        productHashMap.put(chair, startChairCount);
        productHashMap.put(table, startTableCount);
        productHashMap.put(test, testCount);

        productConcurrentHashMap.put(bed, startBedCount);
        productConcurrentHashMap.put(chair, startChairCount);
        productConcurrentHashMap.put(table, startTableCount);
        productConcurrentHashMap.put(test, testCount);
    }

    @DisplayName("")
    @Test
    public void 해시테이블로_동시접근_시간측정() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> {
            for (int j = 0; j < 50000000; j++) {
                productHashMap.put(bed, productHashMap.get(bed) + 1);
                productHashMap.put(chair, productHashMap.get(chair) + 1);
                productHashMap.put(table, productHashMap.get(table) + 1);
                productHashMap.put(test, productHashMap.get(test) + 1);
            }
        });
        executor.shutdown();

        if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("end");
        } else {
            executor.shutdownNow();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("수행시간 = " + (endTime - startTime));

        for (String s : productHashMap.keySet()) {
            System.out.println(productHashMap.get(s));
        }
        // 수행시간 = 3006
    }

    @DisplayName("")
    @Test
    void concurrent해시맵_동시접근_시간측정() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> {
            for (int j = 0; j < 50000000; j++) {
                productConcurrentHashMap.put(bed, productConcurrentHashMap.get(bed) + 1);
                productConcurrentHashMap.put(chair, productConcurrentHashMap.get(chair) + 1);
                productConcurrentHashMap.put(table, productConcurrentHashMap.get(table) + 1);
                productConcurrentHashMap.put(test, productConcurrentHashMap.get(test) + 1);
            }
        });
        executor.shutdown();

        if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("end");
        } else {
            executor.shutdownNow();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("수행시간 = " + (endTime - startTime));
        // 수행시간 = 2119

        for (String s : productConcurrentHashMap.keySet()) {
            System.out.println(productConcurrentHashMap.get(s));
        }
    }

    private static final Map<String, Integer> testHashTable = Collections.synchronizedMap(new HashMap<>());
    private static final Map<String, Integer> testConcurrentHashMap = new ConcurrentHashMap<>();

    @Test
    @Disabled
    void test() throws Exception {
        long hashTableAvgTime = measure_GetPut(testHashTable);
        long concurrentHashMapAvgTime = measure_GetPut(testConcurrentHashMap);

        System.out.println("hashTableAvgTime = " + hashTableAvgTime);
        System.out.println("concurrentHashMapAvgTime = " + concurrentHashMapAvgTime);

    }

    private static long measure_GetPut(Map<String, Integer> map) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        long startTime = System.nanoTime();

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 1_000_000; j++) {
                    int value = ThreadLocalRandom
                            .current()
                            .nextInt(100_000);
                    map.put(String.valueOf(value), value);
                    map.get(value);
                }
            });
        }
        executor.shutdown();
        if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println(map.getClass());
        } else {
            executor.shutdownNow();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 5000000;
    }

}


//    ExecutorService executor = Executors.newFixedThreadPool(3);
//        executor.submit(() -> {
//            for (int j = 0; j < 100000000; j++) {
//                productConcurrentHashMap.put(bedKey, productConcurrentHashMap.get(bedKey) + 1);
//                productConcurrentHashMap.put(chairKey, productConcurrentHashMap.get(chairKey) + 1);
//                productConcurrentHashMap.put(tableKey, productConcurrentHashMap.get(tableKey) + 1);
//            }
//        });
//        executor.shutdown();
//        for (int i = 0; i < 10; i++) {
//
//        new Thread(() -> {
//        for (int j = 0; j < 100000; j++) {
//        productConcurrentHashMap.put(bedKey, productConcurrentHashMap.get(bedKey) + 1);
//        }
//        }).start();
//        new Thread(() -> {
//        for (int j = 0; j < 100000; j++) {
//        productConcurrentHashMap.put(chairKey, productConcurrentHashMap.get(chairKey) + 1);
//        }
//        }).start();
//        new Thread(() -> {
//        for (int j = 0; j < 100000; j++) {
//        productConcurrentHashMap.put(tableKey, productConcurrentHashMap.get(tableKey) + 1);
//        }
//        }).start();
//        }
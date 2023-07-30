package java_lab.staticlap;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TestStaticGC {
    private NormalCacheMain normalCacheMain = new NormalCacheMain();
    Random random = new Random();

    @Test
    void name3() throws InterruptedException {
        addCacheInNormalList(StaticListCacheMain.staticList);

        System.out.println("now = " + LocalDateTime.now());
//        extracted(StaticListCacheMain.staticList);

        System.out.println("List size = " + StaticListCacheMain.staticList.size());
        System.out.println("static 테스트 메서드 종료");
    }

    NormalListCacheMain normalListCacheMain = new NormalListCacheMain();

    @Test
    void name2() throws InterruptedException {
        //1
        addCacheInNormalList(normalList);

        System.out.println(normalList.size());
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("5초 대기");
        }
        System.out.println("일반 테스트 메서드 종료");
    }

    private List<Cache> addCacheInNormalList() throws InterruptedException {
        System.out.println(LocalDateTime.now());
        List<Cache> tempList = new ArrayList<>();
        for (int j = 0; j < 100_000; j++) {
            tempList.add(new Cache(random.nextInt(50000)));
        }
        return tempList;
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("5초 대기");
        }

    }

    private void extracted(List<Cache> normalList) {
        normalList.get(20);
        normalList.get(5000);
        normalList.get(52000);
        normalList.get(2030);
        normalList.get(2023);
    }

    @Test
    void name() throws InterruptedException {
        HashMap<UUID, Cache> normalCacheMap = normalCacheMain.normalCacheMap;
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

        Thread.sleep(1000);
        //3
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        Thread.sleep(1000);
        //4
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }
        Thread.sleep(1000);

        //5
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }
        Thread.sleep(1000);

        //1
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        Thread.sleep(1000);
        //2
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        Thread.sleep(1000);
        //3
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }

        Thread.sleep(1000);
        //4
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }
        Thread.sleep(1000);

        //5
        for (int i = 0; i < 200000; i++) {
            normalCacheMap.put(UUID.randomUUID(), new Cache(random.nextInt(50000)));
        }
        Thread.sleep(1000);

        System.out.println(normalCacheMap.size());
    }
}

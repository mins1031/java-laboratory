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
        for (int i = 0; i < 5; i++) {
            StaticListCacheMain.staticList = addCacheInNormalList();
        }
        System.out.println("now = " + LocalDateTime.now());
//        extracted(StaticListCacheMain.staticList);

        System.out.println("List size = " + StaticListCacheMain.staticList.size());
        System.out.println("static 테스트 메서드 종료");
    }

    NormalListCacheMain normalListCacheMain = new NormalListCacheMain();

    @Test
    void name2() throws InterruptedException {
        //1
        for (int i = 0; i < 5; i++) {
            normalListCacheMain.normalList = addCacheInNormalList();
        }

        System.out.println("일반 테스트 메서드 종료");
    }

    private List<Cache> addCacheInNormalList() throws InterruptedException {
//        System.out.println(LocalDateTime.now());
        List<Cache> tempList = new ArrayList<>();
        for (int j = 0; j < 100_000; j++) {
            tempList.add(new Cache(random.nextInt(50000)));
        }

//        Thread.sleep(500);

//        System.out.println("0.5초 대기");
        return tempList;
        //16546K->7081K(34304K), 0.0055811
    }


    List<Cache> cacheList2 = new ArrayList<>();
    @Test
    void name() throws InterruptedException {
        for (int j = 0; j < 100_000_000; j++) {
            cacheList2.add(new Cache(random.nextInt(50000)));
        }
    }
}

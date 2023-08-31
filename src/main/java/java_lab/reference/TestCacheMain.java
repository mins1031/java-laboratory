package java_lab.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TestCacheMain {

    static TestCache<Integer, TestContent> contentTestCache = new TestCache();

    public static void main(String[] args) {
        Random random = new Random();
        String key = UUID.randomUUID().toString();
        TestContent content = new TestContent(random.nextInt(5000001));
        for (int i = 0; i < 10000000; i++) {
            contentTestCache.put(i++, content);
        }
    }

    private void first_loop() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            List<String> keys = new ArrayList<>();
            List<TestContent> values = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                keys.add(UUID.randomUUID().toString());
                values.add(new TestContent(random.nextInt(5000001)));
            }
        }
    }

}

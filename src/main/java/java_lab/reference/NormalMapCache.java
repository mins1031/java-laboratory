package java_lab.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class NormalMapCache {
    static Map<String, CacheContent<String, Integer>> normalMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Thread.sleep(5000);
        for (int i = 0; i < 5000000; i++) {
            String key = UUID.randomUUID().toString();
            int value = random.nextInt();
            normalMap.put(key, new CacheContent<>(key, value));
        }
    }
}

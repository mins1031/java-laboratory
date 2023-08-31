package java_lab.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SoftCache<K, V> {
    private Map<K, SoftCacheContent<K, V>> softCacheMap = new HashMap<>();
    private final ReferenceQueue<V> queue = new ReferenceQueue<>();

    public SoftCacheContent get(K key) {
        return this.softCacheMap.get(key);
    }

    public void put(K key, V value) {
        cleanWeakCache();
        SoftCacheContent<K, V> value1 = new SoftCacheContent<>(key, value, queue);
        softCacheMap.put(key, value1);
    }

    private void cleanWeakCache()  {
        if (softCacheMap.isEmpty()) {
            return;
        }
        SoftCacheContent<K, V> wrappedCacheContent;
        while ((wrappedCacheContent = (SoftCacheContent<K, V>) queue.poll()) != null) {
            softCacheMap.remove(wrappedCacheContent.getKey());
        }
    }

    public void displayCache() {
        for (Map.Entry<K, SoftCacheContent<K, V>> kWeakReferenceEntry : softCacheMap.entrySet()) {
            System.out.println("map key = " + kWeakReferenceEntry.getKey());
//            System.out.println("map value = " + Optional.ofNullable(kWeakReferenceEntry.getValue()).map(value -> value.get).orElse(null));
            System.out.println("----------------");
        }
    }

    public int size() {
        return this.softCacheMap.size();
    }
}

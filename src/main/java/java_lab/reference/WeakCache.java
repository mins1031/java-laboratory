package java_lab.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WeakCache<K, V> {
    private Map<K, WeakCacheContent<K, V>> weakCacheMap = new HashMap<>();
    private final ReferenceQueue<V> queue = new ReferenceQueue<>();

    public WeakCacheContent get(K key) {
        return this.weakCacheMap.get(key);
    }

    public void put(K key, V value) {
        cleanWeakCache();
        weakCacheMap.put(key, new WeakCacheContent<K, V>(key, value, queue));
    }

    private void cleanWeakCache()  {
        if (weakCacheMap.isEmpty()) {
            return;
        }
        WeakCacheContent<K, V> wrappedCacheContent;
        while ((wrappedCacheContent = (WeakCacheContent<K, V>) queue.poll()) != null) {
            weakCacheMap.remove(wrappedCacheContent.getKey());
        }
    }

    public void displayCache() {
        for (Map.Entry<K, WeakCacheContent<K, V>> kWeakReferenceEntry : weakCacheMap.entrySet()) {
            System.out.println("map key = " + kWeakReferenceEntry.getKey());
            System.out.println("map value = " + Optional.ofNullable(kWeakReferenceEntry.getValue()).map(value -> value.getValue()).orElse(null));
            System.out.println("----------------");
        }
    }

    public int size() {
        return this.weakCacheMap.size();
    }
}

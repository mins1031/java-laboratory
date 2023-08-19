package java_lab.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SoftCache<K, V> {
    private Map<K, SoftReference<WeakCacheContent<K, V>>> weakCacheMap = new HashMap<>();
    private final ReferenceQueue<WeakCacheContent<K, V>> queue = new ReferenceQueue<>();

    public WeakCacheContent get(K key) {
        return this.weakCacheMap.get(key).get();
    }

    public void put(K key, WeakCacheContent<K, V> value) {
        cleanWeakCache();
        weakCacheMap.put(key, new SoftReference<>(value, queue));
    }

    private void cleanWeakCache()  {
        if (weakCacheMap.isEmpty()) {
            return;
        }
        Reference<? extends WeakCacheContent<K, V>> wrappedCacheContent;
        while ((wrappedCacheContent = queue.poll()) != null) {
            K key = wrappedCacheContent.get().getKey();
            weakCacheMap.remove(key);
        }
    }

    public void displayCache() {
        for (Map.Entry<K, SoftReference<WeakCacheContent<K, V>>> kWeakReferenceEntry : weakCacheMap.entrySet()) {
            System.out.println("map key = " + kWeakReferenceEntry.getKey());
            System.out.println("map value = " + Optional.ofNullable(kWeakReferenceEntry.getValue().get()).map(value -> value.getValue()).orElse(null));
            System.out.println("----------------");
        }
    }

    public int size() {
        return this.weakCacheMap.size();
    }
}

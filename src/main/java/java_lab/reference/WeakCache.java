package java_lab.reference;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WeakCache<K, V> {
    private Map<K, WeakReference<WeakCacheContent<V>>> weakCacheMap = new HashMap<>();

    public WeakCacheContent get(K key) {
        return this.weakCacheMap.get(key).get();
    }

    public void put(K key, WeakCacheContent<V> value) {
        weakCacheMap.put(key, new WeakReference<>(value));
    }

    public void displayCache() {
        for (Map.Entry<K, WeakReference<WeakCacheContent<V>>> kWeakReferenceEntry : weakCacheMap.entrySet()) {
            System.out.println("map key = " + kWeakReferenceEntry.getKey());
            System.out.println("map value = " + Optional.ofNullable(kWeakReferenceEntry.getValue().get()).map(value -> value.getValue()).orElse(null));
            System.out.println("----------------");
        }
    }

    public int size() {
        return this.weakCacheMap.size();
    }
}

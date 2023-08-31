package java_lab.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

public class WeakCacheContent<K, V> extends WeakReference<V> {
    private final K key;

    public WeakCacheContent(K key, V value, ReferenceQueue<V> queue) {
        super(value, queue);
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeakCacheContent<?, ?> that = (WeakCacheContent<?, ?>) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}

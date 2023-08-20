package java_lab.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Objects;

public class SoftCacheContent<K, V> extends SoftReference<V> {
    private final K key;
    private final V value;

    public SoftCacheContent(K key, V value, ReferenceQueue<V> queue) {
        super(value, queue);
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoftCacheContent<?, ?> that = (SoftCacheContent<?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}

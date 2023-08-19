package java_lab.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

public class WeakCacheContent<K, V> extends WeakReference<V> {
    private final K key;
    private final V value;

    public WeakCacheContent(K key, V value, ReferenceQueue<V> queue) {
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

}

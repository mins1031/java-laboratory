package java_lab.reference;

public class WeakCacheContent<V> {
    private final V value;

    public WeakCacheContent(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }
}

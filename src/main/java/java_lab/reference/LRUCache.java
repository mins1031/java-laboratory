package java_lab.reference;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

public class LRUCache<K, V> {
    private int cacheSize;
    private Map<K, CacheContent<K,V>> cacheNodeMap;
    private LinkedList<CacheContent<K,V>> nodePriorityList;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cacheNodeMap = new HashMap<>();
        this.nodePriorityList = new LinkedList<>();
    }

    public Optional<CacheContent<K, V>> get(K key) {
        CacheContent<K, V> findCacheContent = cacheNodeMap.get(key);
        if (findCacheContent == null) {
            return Optional.empty();
        }
        nodePriorityList.remove(findCacheContent);
        nodePriorityList.addFirst(findCacheContent);
        return Optional.of(findCacheContent);
    }

    public void put(K key, V value) {
        CacheContent<K, V> cacheContent = new CacheContent<>(key, value);
        if (cacheNodeMap.containsKey(key)) {
            cacheNodeMap.put(key, cacheContent);
            return ;
        }

        if (nodePriorityList.size() == this.cacheSize) {
            CacheContent<K, V> last = nodePriorityList.getLast();
            cacheNodeMap.remove(last.getKey());
            nodePriorityList.removeLast();
        }

        cacheNodeMap.put(key, cacheContent);
        nodePriorityList.addFirst(cacheContent);
    }

    public void displayPriority() {
        for (CacheContent<K, V> kvCacheContent : nodePriorityList) {
            System.out.println("priority = " + kvCacheContent.getKey());
            System.out.println("priority = " + kvCacheContent.getValue());
            System.out.println("--------");
        }

        for (Map.Entry<K, CacheContent<K, V>> kCacheContentEntry : cacheNodeMap.entrySet()) {
            System.out.println("map = " + kCacheContentEntry.getKey());
            System.out.println("map = " + kCacheContentEntry.getValue().getValue());
            System.out.println("--------");
        }
    }
}
package java_lab.reference;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

public class LRUCache<K, V> {
    //LRU 구현은 키-값을 저장하는 map 자료구조와 해당 map의 우선순위를 저장하는 linkedlist가 핵심이다.
    //get은 확실히 리턴값이 Optional이 좋은듯하다
    //get의 핵심은 get과 동시에 우선순위 리스트 상위권에 적용되야하고 get한 값을 삭제, 맨앞(head)추가 가 이루어 져야한다.
    //put은 넣는 과정에서 정해진 값을 넘기면 map과 우선순위에서 각각 삭제후 put 해야 한다.
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
//        cacheNodeMap.put(key, findCacheContent);
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
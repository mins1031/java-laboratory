package java_lab.datastructure.hashtable;

import java.util.LinkedList;

public class MakedHashTable {
    class HashTableNode {
        private String key;
        private String value;

        public HashTableNode(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private LinkedList<HashTableNode>[] data;

    public MakedHashTable(int size) {
        this.data = new LinkedList[size];
    }

    public int getHashCode(String key) {
        int hashcode = 0;
        for (char c : key.toCharArray()) {
            hashcode += c;
        }

        return hashcode;
    }

    public int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    public HashTableNode searchKey(LinkedList<HashTableNode> linkedList, String key) {
        if (linkedList == null) {
            return null;
        }

        for (HashTableNode hashTableNode : linkedList) {
            if (hashTableNode.key.equals(key)) {
                return hashTableNode;
            }
        }
        return null;
    }

    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<HashTableNode> list = data[index];
        if (list == null) {
            list = new LinkedList<HashTableNode>();
            data[index] = list;
        }
        HashTableNode hashTableNode = searchKey(list, key);
        if (hashTableNode == null) {
            list.addLast(new HashTableNode(key, value));
        } else {
            hashTableNode.setValue(value);
        }
    }

    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<HashTableNode> list = data[index];
        HashTableNode hashTableNode = searchKey(list, key);
        if (hashTableNode == null) {
            return "not found";
        }

        return hashTableNode.value;
    }
}

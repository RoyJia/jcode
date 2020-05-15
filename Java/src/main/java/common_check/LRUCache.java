package common_check;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, LinkedNode> map;
    LinkedTable cache;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new LinkedTable();
    }

    public void put(int key, int value) {
        LinkedNode node = new LinkedNode(key, value);

        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.add(node);
            map.put(key, node);
        } else {
            if (cache.size == capacity) {
                LinkedNode last = cache.removeLast();
                map.remove(last.key);
            }
            cache.add(node);
            map.put(key, node);
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        int value = map.get(key).value;

        put(key, value);

        return value;
    }
}

class LinkedNode {
    LinkedNode prev;
    LinkedNode next;
    int key;
    int value;

    public LinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LinkedTable {
    LinkedNode head;
    LinkedNode tail;
    int size;

    public LinkedTable() {
        head = new LinkedNode(0, 0);
        tail = new LinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void add(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void remove(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public LinkedNode removeLast() {
        if (tail.prev == head) {
            return null;
        }

        LinkedNode last = tail.prev;
        remove(last);

        return last;
    }
}
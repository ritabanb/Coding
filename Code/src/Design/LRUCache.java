package Design;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key, val;
    Node prev, next;
    public Node(int k, int v) {
        key = k;
        val = v;
    }
}

public class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }


    void removeSelf(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    void insertHead(Node n) {
        n.next = head.next;
        n.next.prev = n;
        head.next = n;
        n.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if(n == null)
            return -1;
        removeSelf(n);
        insertHead(n);
        return n.val;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if(n != null) {
            removeSelf(n);
            map.remove(key);
        }

        if(map.size() == capacity) {
            map.remove(tail.prev.key);
            removeSelf(tail.prev);
        }

        map.put(key, new Node(key, value));
        insertHead(map.get(key));
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));
    }
}

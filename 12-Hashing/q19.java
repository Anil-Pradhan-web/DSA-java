import java.util.HashMap;
import java.util.Map;

public class q19 {
    /*
     * Pattern: Hashing / HashMap + Doubly Linked List
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Medium
     *
     * LeetCode #146: LRU Cache
     *
     * Problem samajh lo:
     * Humein LRU (Least Recently Used) Cache design karna hai.
     * - get(key): value return karo, agar exist karta hai to
     * - put(key, value): value store karo, agar capacity full hai to
     * sabse purana (least recently used) element remove karo
     *
     * Example:
     * LRUCache(2)
     * put(1, 1) -> cache = {1:1}
     * put(2, 2) -> cache = {1:1, 2:2}
     * get(1) -> 1 (1 ab recently used ho gaya)
     * put(3, 3) -> 2 remove hoga (sabse purana), cache = {1:1, 3:3}
     *
     * Best idea:
     * HashMap + Doubly Linked List use karo.
     * - HashMap: key -> node (O(1) lookup)
     * - Doubly Linked List: recency order maintain karta hai
     * (head ke paas = most recent, tail ke paas = least recent)
     *
     * Kyun doubly linked list?
     * Kisi bhi node ko O(1) me remove karke head par add kar sakte hain.
     * HashMap se node O(1) me mil jata hai.
     *
     * Time Complexity: O(1) for both get and put
     * Space Complexity: O(capacity)
     */
    static class LRUCache {
        private Map<Integer, Node> map;
        private int capacity;
        private Node head; // most recent
        private Node tail; // least recent

        static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                removeNode(node);
                addToHead(node);
            } else {
                if (map.size() >= capacity) {
                    // Least recently used remove karo
                    map.remove(tail.prev.key);
                    removeNode(tail.prev);
                }

                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addToHead(newNode);
            }
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("get(1) = " + cache.get(1)); // 1
        cache.put(3, 3); // 2 remove hoga
        System.out.println("get(2) = " + cache.get(2)); // -1
        System.out.println("get(3) = " + cache.get(3)); // 3
    }
}
import java.util.HashMap;

public class q20 {

    /*
     * Pattern: HashMap + Doubly Linked List
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #146: LRU Cache
     *
     * Problem samajh lo:
     * Ek cache design karna hai jisme:
     * - get(key) → O(1)
     * - put(key, value) → O(1)
     *
     * RULE:
     * - Jo item sabse least recently use hua hai → sabse pehle remove hoga
     *
     * APPROACH:
     * - HashMap → fast access (key → node)
     * - Doubly Linked List → order maintain (recent → front, old → back)
     *
     * Time Complexity: O(1) per operation
     * Space Complexity: O(capacity)
     */

    // Doubly Linked List Node
    static class Node {
        int key, val;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    static class LRUCache {

        private int capacity;
        private HashMap<Integer, Node> map;

        // Dummy head & tail (easy insertion/deletion)
        private Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        /*
         * Helper: Node ko front (most recent) pe add karo
         */
        private void addNode(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        /*
         * Helper: Node ko list se remove karo
         */
        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        /*
         * Helper: Node ko move to front (recently used)
         */
        private void moveToFront(Node node) {
            removeNode(node);
            addNode(node);
        }

        /*
         * get operation
         */
        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1; // not found
            }

            Node node = map.get(key);

            // use hua → front pe le aao
            moveToFront(node);

            return node.val;
        }

        /*
         * put operation
         */
        public void put(int key, int value) {

            if (map.containsKey(key)) {
                // agar already hai → value update + front pe move
                Node node = map.get(key);
                node.val = value;
                moveToFront(node);
            } else {
                // naya node create karo
                Node newNode = new Node(key, value);

                // map me daalo
                map.put(key, newNode);

                // list ke front pe daalo
                addNode(newNode);

                // agar capacity exceed ho gayi
                if (map.size() > capacity) {
                    // tail ke just pehle wala node = least recently used
                    Node lru = tail.prev;

                    // list se remove
                    removeNode(lru);

                    // map se remove
                    map.remove(lru.key);
                }
            }
        }
    }

    public static void main(String[] args) {

        // Example run
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // 2 remove hoga (LRU)

        System.out.println(cache.get(2)); // -1
    }
}
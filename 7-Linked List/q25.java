import java.util.HashMap;

public class q25 {

    /*
     * Pattern: HashMap + Doubly Linked List
     * Company Names: Google, Amazon
     * Difficulty: Hard
     *
     * LeetCode #460: LFU Cache
     *
     * Problem samajh lo:
     * - Least Frequently Used item remove karna hai
     * - Same frequency wale me LRU remove hoga
     *
     * APPROACH:
     * - key → Node (value + freq)
     * - freq → Doubly LL (same freq nodes)
     * - minFreq track karte hain
     *
     * Time Complexity: O(1) per operation
     * Space Complexity: O(capacity)
     */

    // Node structure
    static class Node {
        int key, val, freq;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            val = v;
            freq = 1; // initially frequency = 1
        }
    }

    // Doubly Linked List for each frequency
    static class DoublyLL {
        Node head, tail;
        int size;

        DoublyLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // node add at front (most recent in this freq)
        void add(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // remove a node
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // remove least recently used (tail.prev)
        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    static class LFUCache {

        private int capacity;
        private int minFreq;

        // key → node
        private HashMap<Integer, Node> keyMap;

        // freq → list of nodes
        private HashMap<Integer, DoublyLL> freqMap;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.minFreq = 0;

            keyMap = new HashMap<>();
            freqMap = new HashMap<>();
        }

        /*
         * Helper: frequency update
         */
        private void updateFreq(Node node) {

            int freq = node.freq;

            // old freq list se remove
            DoublyLL list = freqMap.get(freq);
            list.remove(node);

            // agar ye last node tha aur freq = minFreq tha → minFreq update
            if (freq == minFreq && list.size == 0) {
                minFreq++;
            }

            // node ka freq badhao
            node.freq++;

            // new freq list me add karo
            freqMap.putIfAbsent(node.freq, new DoublyLL());
            freqMap.get(node.freq).add(node);
        }

        public int get(int key) {

            if (!keyMap.containsKey(key)) {
                return -1;
            }

            Node node = keyMap.get(key);

            // access hua → freq badhega
            updateFreq(node);

            return node.val;
        }

        public void put(int key, int value) {

            if (capacity == 0) return;

            if (keyMap.containsKey(key)) {
                // update value
                Node node = keyMap.get(key);
                node.val = value;

                // freq update
                updateFreq(node);
            } else {

                // capacity full → remove LFU
                if (keyMap.size() == capacity) {

                    // minFreq list se remove karo (LRU within same freq)
                    DoublyLL list = freqMap.get(minFreq);
                    Node toRemove = list.removeLast();

                    keyMap.remove(toRemove.key);
                }

                // new node create
                Node newNode = new Node(key, value);

                // map me daalo
                keyMap.put(key, newNode);

                // freq 1 list me daalo
                freqMap.putIfAbsent(1, new DoublyLL());
                freqMap.get(1).add(newNode);

                // minFreq reset
                minFreq = 1;
            }
        }
    }

    public static void main(String[] args) {

        // Example run
        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // remove key 2 (LFU)

        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 3
    }
}
public class q24 {

    // Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Pattern: Design
     * Company Names: Microsoft, Google
     * Difficulty: Medium
     *
     * LeetCode #707: Design Linked List
     *
     * Problem samajh lo:
     * Apni khud ki linked list design karni hai jisme following operations hon:
     * - get(index)
     * - addAtHead(val)
     * - addAtTail(val)
     * - addAtIndex(index, val)
     * - deleteAtIndex(index)
     *
     * APPROACH:
     * - Dummy head use karte hain taaki edge cases easy ho jayein
     * - Size maintain karte hain fast validation ke liye
     *
     * Time Complexity: O(N) per operation
     * Space Complexity: O(1)
     */

    static class MyLinkedList {

        private ListNode head; // dummy head
        private int size;      // list size track karne ke liye

        public MyLinkedList() {
            head = new ListNode(0); // dummy node
            size = 0;
        }

        /*
         * get(index): given index ka value return karo
         */
        public int get(int index) {

            // invalid index
            if (index < 0 || index >= size) return -1;

            ListNode curr = head.next; // actual first node

            // index tak traverse karo
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            return curr.val;
        }

        /*
         * addAtHead(val): start me node add karo
         */
        public void addAtHead(int val) {
            addAtIndex(0, val); // reuse logic
        }

        /*
         * addAtTail(val): end me node add karo
         */
        public void addAtTail(int val) {
            addAtIndex(size, val); // last index pe add
        }

        /*
         * addAtIndex(index, val):
         * - valid index pe node insert karo
         */
        public void addAtIndex(int index, int val) {

            // invalid index (greater than size)
            if (index > size) return;

            // negative index → treat as 0
            if (index < 0) index = 0;

            ListNode curr = head;

            // insert position ke previous node tak jao
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            // new node create karo
            ListNode newNode = new ListNode(val);

            // linking
            newNode.next = curr.next;
            curr.next = newNode;

            size++; // size update
        }

        /*
         * deleteAtIndex(index):
         * - given index ka node delete karo
         */
        public void deleteAtIndex(int index) {

            // invalid index
            if (index < 0 || index >= size) return;

            ListNode curr = head;

            // delete hone wale node ke previous tak jao
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            // node skip karke delete
            curr.next = curr.next.next;

            size--; // size update
        }
    }

    public static void main(String[] args) {

        // Example run
        MyLinkedList list = new MyLinkedList();

        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2); // 1 → 2 → 3

        System.out.println(list.get(1)); // 2

        list.deleteAtIndex(1); // 1 → 3

        System.out.println(list.get(1)); // 3
    }
}
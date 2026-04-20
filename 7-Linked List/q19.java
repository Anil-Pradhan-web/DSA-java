public class q19 {

    // Node structure (random pointer ke saath)
    static class ListNode {
        int val;
        ListNode next;
        ListNode random; // extra pointer

        ListNode(int x) {
            val = x;
            next = null;
            random = null;
        }
    }

    /*
     * Pattern: Interweaving (Optimal) / HashMap
     * Company Names: Amazon, Microsoft, Meta
     * Difficulty: Medium
     *
     * LeetCode #138: Copy List with Random Pointer
     *
     * Problem samajh lo:
     * Linked list ka deep copy banana hai jisme:
     * - next pointer bhi copy ho
     * - random pointer bhi correct node pe point kare
     *
     * APPROACH (O(1) Space - Interweaving Trick):
     *
     * Step 1: Original nodes ke beech copy nodes insert karo
     * Example:
     * A → B → C
     * A → A' → B → B' → C → C'
     *
     * Step 2: Random pointers set karo
     * A'.random = A.random.next
     *
     * Step 3: Dono lists (original & copy) ko alag karo
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode copyRandomList(ListNode head) {

        if (head == null) return null;

        // =========================
        // Step 1: Copy nodes insert (interweaving)
        // =========================
        ListNode curr = head;

        while (curr != null) {
            ListNode copy = new ListNode(curr.val); // new node

            copy.next = curr.next; // original next preserve
            curr.next = copy;      // copy ko original ke beech insert

            curr = copy.next; // next original node pe jump
        }

        /*
         * Structure ab:
         * A → A' → B → B' → C → C'
         */

        // =========================
        // Step 2: Random pointers set karo
        // =========================
        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                // copy node ka random set karo
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // next original node
        }

        // =========================
        // Step 3: Separate original & copied list
        // =========================
        curr = head;
        ListNode dummy = new ListNode(0);
        ListNode copyCurr = dummy;

        while (curr != null) {

            ListNode copy = curr.next; // copy node

            // copy list build
            copyCurr.next = copy;
            copyCurr = copyCurr.next;

            // original list restore
            curr.next = copy.next;

            curr = curr.next;
        }

        // final copied list ka head
        return dummy.next;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Copy List with Random Pointer - Run successful");
    }
}
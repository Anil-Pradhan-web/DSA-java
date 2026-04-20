public class q23 {

    // Linked List ka basic node structure
    static class ListNode {
        int val;        // node ka data
        ListNode next;  // next node ka reference

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Pattern: Pointer Manipulation
     * Company Names: Amazon, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #61: Rotate List
     *
     * Problem samajh lo:
     * Linked list ko right side me k steps rotate karna hai.
     *
     * Example:
     * Input: 1 → 2 → 3 → 4 → 5, k = 2
     * Output: 4 → 5 → 1 → 2 → 3
     *
     * CORE IDEA:
     * - List ko circular bana do (last → head)
     * - Fir new head find karo (n - k steps)
     * - Cycle break kar do
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode rotateRight(ListNode head, int k) {

        // Edge cases
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Length find karo + tail locate karo
        ListNode curr = head;
        int length = 1;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // curr ab tail pe hai

        // Step 2: k ko optimize karo (extra rotations useless hain)
        k = k % length;

        // Agar k = 0 ho gaya → same list return
        if (k == 0) return head;

        // Step 3: List ko circular bana do
        curr.next = head;

        /*
         * Step 4:
         * New head = (length - k) steps aage
         * Isse pehle wala node new tail banega
         */
        int stepsToNewHead = length - k;

        ListNode newTail = curr; // currently tail pe hai

        // newTail ko correct position pe le jao
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // new head
        ListNode newHead = newTail.next;

        // Step 5: Cycle break karo
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Rotate List - Run successful");
    }
}
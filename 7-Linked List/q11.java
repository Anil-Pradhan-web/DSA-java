public class q11 {

    // Linked List ka basic node structure
    static class ListNode {
        int val;        // node ka data
        ListNode next;  // next node ka reference

        ListNode(int x) {
            val = x;        // value assign
            next = null;    // initially next null
        }
    }

    /*
     * Pattern: Reversal + Merge
     * Company Names: Amazon, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #143: Reorder List
     *
     * Problem samajh lo:
     * List ko is format mein convert karna hai:
     * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 ...
     *
     * Example:
     * Input:  1 → 2 → 3 → 4 → 5
     * Output: 1 → 5 → 2 → 4 → 3
     *
     * APPROACH (3 Steps):
     * 1. Middle find karo (fast-slow pointer)
     * 2. Second half ko reverse karo
     * 3. Dono halves ko alternate merge karo
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static void reorderList(ListNode head) {

        // Edge case: agar list empty ya single node hai → kuch karna nahi
        if (head == null || head.next == null) return;

        // =========================
        // Step 1: Find Middle
        // =========================

        ListNode slow = head, fast = head;

        /*
         * slow → 1 step
         * fast → 2 steps
         * Jab fast end pe pahunchta hai → slow middle pe hota hai
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /*
         * Example:
         * 1 → 2 → 3 → 4 → 5
         * slow at 3 (middle)
         */

        // =========================
        // Step 2: Reverse Second Half
        // =========================

        ListNode prev = null;

        // slow.next se second half start hoti hai
        ListNode curr = slow.next;

        // first half aur second half ko disconnect kar diya
        slow.next = null;

        /*
         * Ab second half ko reverse kar rahe hain
         * Standard linked list reversal
         */
        while (curr != null) {
            ListNode nextTemp = curr.next; // next node save

            curr.next = prev;  // reverse link

            prev = curr;       // prev aage badhao
            curr = nextTemp;   // curr aage badhao
        }

        /*
         * Ab 'prev' reversed second half ka head hai
         * Example:
         * 4 → 5  → reverse → 5 → 4
         */

        // =========================
        // Step 3: Merge Alternate
        // =========================

        ListNode first = head;   // first half ka start
        ListNode second = prev; // reversed second half ka start

        /*
         * Dono lists ko alternate merge karenge:
         * first → second → first → second ...
         */
        while (second != null) {

            // next pointers store kar lete hain taaki link break na ho
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            // linking step (main logic)
            first.next = second;   // first ke baad second
            second.next = tmp1;   // second ke baad next first

            // pointers aage badhao
            first = tmp1;
            second = tmp2;
        }
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Reorder List - Run successful");
    }
}
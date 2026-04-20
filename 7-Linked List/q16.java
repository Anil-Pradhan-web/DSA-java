public class q16 {

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
     * Pattern: Pointer Manipulation
     * Company Names: Adobe, Paytm
     * Difficulty: Easy
     *
     * LeetCode #203: Remove Linked List Elements
     *
     * Problem samajh lo:
     * Linked list mein se saare nodes delete karne hain jinki value = given val
     *
     * Example:
     * Input: 1 → 2 → 6 → 3 → 4 → 5 → 6, val = 6
     * Output: 1 → 2 → 3 → 4 → 5
     *
     * APPROACH:
     * - Dummy node use karte hain taaki head removal easily handle ho
     * - Ek pointer se traverse karte hain
     * - Agar next node ka value match kare → skip kar dete hain
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode removeElements(ListNode head, int val) {

        // Step 1:
        // Dummy node create karte hain (edge case: head delete ho sakta hai)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Current pointer dummy se start karega
        ListNode curr = dummy;

        /*
         * Step 2:
         * Traverse karo jab tak list khatam nahi hoti
         */
        while (curr.next != null) {

            /*
             * Agar next node ki value match karti hai,
             * toh us node ko skip kar dete hain
             */
            if (curr.next.val == val) {
                curr.next = curr.next.next; // delete (skip)
            } else {
                // warna normal aage badho
                curr = curr.next;
            }
        }

        // Final head return (dummy.next hi actual head hai)
        return dummy.next;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Remove Linked List Elements - Run successful");
    }
}
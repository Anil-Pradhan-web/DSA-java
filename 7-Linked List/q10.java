public class q10 {

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
     * Pattern: Fast-Slow Pointer (Floyd’s Cycle Detection)
     * Company Names: Amazon, Adobe
     * Difficulty: Medium
     *
     * LeetCode #142: Linked List Cycle II
     *
     * Problem samajh lo:
     * Agar linked list me cycle hai, to uska starting node find karna hai.
     *
     * Example:
     * 1 -> 2 -> 3 -> 4 -> 5
     *           ^         |
     *           |_________|
     *
     * Cycle start = 3
     *
     * APPROACH:
     * 1. Fast & Slow pointer use karke cycle detect karo
     * 2. Agar cycle mil gayi:
     *      → ek pointer head se start karo
     *      → ek pointer meeting point (slow) se start karo
     *      → dono 1 step move karenge
     *      → jahan milenge = cycle start
     *
     * IMPORTANT MATH INTUITION:
     * - Distance head → cycle start = distance meeting point → cycle start
     * - Isliye dono pointers ek hi jagah milte hain
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode detectCycle(ListNode head) {

        // Step 1: slow aur fast pointers initialize
        ListNode slow = head, fast = head;

        /*
         * Cycle detect karne ke liye loop:
         * slow → 1 step
         * fast → 2 steps
         */
        while (fast != null && fast.next != null) {

            slow = slow.next;         // slow ek step
            fast = fast.next.next;   // fast do step

            /*
             * Step 2:
             * Agar slow aur fast mil gaye → cycle exist karti hai
             */
            if (slow == fast) {

                /*
                 * Step 3:
                 * Ab cycle ka starting point find karna hai
                 *
                 * Ek naya pointer head se start karte hain
                 */
                ListNode start = head;

                /*
                 * Dono pointers (start & slow) ek-ek step move karenge
                 * Jahan ye milenge wahi cycle ka starting node hoga
                 */
                while (start != slow) {
                    start = start.next; // head side se move
                    slow = slow.next;   // meeting point se move
                }

                // Cycle ka starting node return
                return start;
            }
        }

        // Agar loop se bahar aa gaye → cycle nahi hai
        return null;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Linked List Cycle II - Run successful");
    }
}
public class q12 {

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
     * Company Names: Amazon, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #24: Swap Nodes in Pairs
     *
     * Problem samajh lo:
     * Har do adjacent nodes ko swap karna hai.
     *
     * Example:
     * Input:  1 → 2 → 3 → 4
     * Output: 2 → 1 → 4 → 3
     *
     * APPROACH:
     * - Dummy node use karte hain taaki head change easily handle ho
     * - Har iteration mein 2 nodes ko pick karke swap karte hain
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode swapPairs(ListNode head) {

        // Step 1:
        // Dummy node create kar rahe hain (edge case handle: head swap)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 'prev' pointer har pair ke pehle wale node ko represent karega
        ListNode prev = dummy;

        /*
         * Step 2:
         * Loop tab tak chalega jab tak 2 nodes available hain
         * (kyunki hume pair mein swap karna hai)
         */
        while (prev.next != null && prev.next.next != null) {

            // Current pair ke do nodes
            ListNode first = prev.next;         // pehla node (swap ke baad second banega)
            ListNode second = prev.next.next;   // dusra node (swap ke baad first banega)

            /*
             * Step 3: Actual swapping (3 pointer changes)
             *
             * Initial:
             * prev → first → second → next
             */

            // (1) first ko third node se connect karo
            first.next = second.next;

            // (2) second ko first se connect karo (swap ho gaya internally)
            second.next = first;

            // (3) prev ko second se connect karo (new head of this pair)
            prev.next = second;

            /*
             * Ab structure:
             * prev → second → first → next
             */

            // Step 4:
            // prev ko aage badhao next pair ke liye
            // (first ab pair ka last node hai)
            prev = first;
        }

        // Final head return (dummy.next hi new head hai)
        return dummy.next;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Swap Nodes in Pairs - Run successful");
    }
}
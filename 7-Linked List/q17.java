public class q17 {

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
     * Pattern: Reversal
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Hard
     *
     * LeetCode #25: Reverse Nodes in k-Group
     *
     * Problem samajh lo:
     * Linked list ko k size ke groups me reverse karna hai.
     * Agar last me nodes k se kam bache ho → unhe reverse nahi karna.
     *
     * Example:
     * Input: 1 → 2 → 3 → 4 → 5, k = 2
     * Output: 2 → 1 → 4 → 3 → 5
     *
     * APPROACH:
     * - Har group ke liye check karo ki k nodes available hain ya nahi
     * - Agar hain → reverse karo
     * - Fir next group ke saath connect karo
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode reverseKGroup(ListNode head, int k) {

        // Dummy node taaki head changes easily handle ho
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // groupPrev har group ke start se pehle wala node track karega
        ListNode groupPrev = dummy;

        while (true) {

            // Step 1: Check karo ki k nodes available hain
            ListNode kth = groupPrev;

            // kth ko k steps aage le jao
            for (int i = 0; i < k; i++) {
                kth = kth.next;

                // Agar null aa gaya → k nodes nahi mile → stop
                if (kth == null) {
                    return dummy.next;
                }
            }

            // groupNext = next group ka start
            ListNode groupNext = kth.next;

            // Step 2: Reverse current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            /*
             * Reverse logic:
             * current group ke nodes ko reverse karte hain
             * jab tak curr groupNext tak nahi pahunchta
             */
            while (curr != groupNext) {
                ListNode temp = curr.next;

                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            /*
             * Ab:
             * prev = new head of reversed group
             * groupPrev.next = old head (jo ab last ban gaya)
             */

            // Step 3: Connect reversed group with previous part
            ListNode temp = groupPrev.next; // ye old head hai (ab last ban gaya)

            groupPrev.next = kth; // new head connect
            groupPrev = temp;    // next group ke liye move
        }
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Reverse Nodes in k-Group - Run successful");
    }
}
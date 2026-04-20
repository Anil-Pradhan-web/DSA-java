public class q9 {

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
     * Pattern: Two Pointer
     * Company Names: Amazon, Microsoft, Adobe
     * Difficulty: Medium
     *
     * LeetCode #19: Remove Nth Node from End
     *
     * Problem samajh lo:
     * Linked list ke end se Nth node ko delete karna hai.
     *
     * Example:
     * 1 -> 2 -> 3 -> 4 -> 5, n = 2
     * Output: 1 -> 2 -> 3 -> 5   (4 delete hua)
     *
     * CORE IDEA:
     * - Fast pointer ko n+1 steps aage le jao
     * - Fir fast aur slow dono ko ek saath move karo
     * - Jab fast end pe pahunch jaye → slow exactly us node pe hoga
     *   jo delete hone wale node se JUST PEHLE hai
     *
     * Dummy node kyun use kiya?
     * - Agar head hi delete karna ho (edge case), toh easily handle ho jata hai
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1:
        // Dummy node create kar rahe hain jo head se pehle lagega
        // Ye edge cases (jaise head delete hona) handle karta hai
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Dono pointers dummy se start kar rahe hain
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 2:
        // Fast pointer ko (n + 1) steps aage le ja rahe hain
        // Taaki fast aur slow ke beech exact gap create ho jaye
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        /*
         * Ab situation:
         * fast aur slow ke beech (n+1) nodes ka gap hai
         */

        // Step 3:
        // Dono pointers ko ek saath move karte rahenge
        // Jab fast null ho jayega → slow correct position pe hoga
        while (fast != null) {
            fast = fast.next;   // fast aage badh raha hai
            slow = slow.next;   // slow bhi aage badh raha hai
        }

        /*
         * Ab slow exactly us node pe hai jo delete hone wale node se pehle hai
         * Example:
         * slow -> 3, slow.next -> 4 (delete hona hai)
         */

        // Step 4:
        // Node delete karna by skipping it
        slow.next = slow.next.next;

        // Final head return (dummy.next hi actual head hai)
        return dummy.next;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Remove Nth Node from End - Run successful");
    }
}
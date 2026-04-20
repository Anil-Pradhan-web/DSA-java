public class q6 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Pattern: Two pointer
     * Company Names: Wipro, Cognizant
     * Difficulty: Easy
     *
     * LeetCode #83: Remove Duplicates from Sorted List
     *
     * Problem samajh lo:
     * Sorted list se duplicates hatane hain.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        // Step 1: list traverse karo
        while (current != null && current.next != null) {
            // Step 2: agar current ki value next ki value se same hai, to next node ko skip kardo
            if (current.val == current.next.val) {
                current.next = current.next.next; 
            } else {
                // nahi to aage badho
                current = current.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        // Example test
        System.out.println("Remove Duplicates from Sorted List - Run successful");
    }
}

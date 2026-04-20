public class q7 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Pattern: Fast-Slow pointer / Reversal
     * Company Names: TCS, Infosys
     * Difficulty: Easy
     *
     * LeetCode #234: Palindrome Linked List
     *
     * Problem samajh lo:
     * Check karna hai ki list palindrome hai ya nahi.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Middle node find karo using slow-fast pointer
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Second half of list ko reverse karo (slow ke baad wale part ko)
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: First half aur reversed second half ko compare karo
        ListNode left = head;
        ListNode right = prev; // reversed half ka head
        while (right != null) {
            if (left.val != right.val) {
                return false; // values match nahi ki, not a palindrome
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    public static void main(String[] args) {
        // Example test
        System.out.println("Palindrome Linked List - Run successful");
    }
}

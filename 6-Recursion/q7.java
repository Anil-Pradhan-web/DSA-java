public class q7 {
    /*
     * Pattern: Pure Recursion
     * Company Names: Amazon, Microsoft
     * Difficulty: Easy
     *
     * LeetCode #206: Reverse Linked List
     *
     * Problem samajh lo:
     * Linked list ko recursion se reverse karna hai.
     *
     * Recursive idea:
     * Chhoti list ko reverse hone do.
     * Phir current node ko end par attach kar do.
     *
     * Base case:
     * empty list ya single node
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode reversed = reverseList(head);
        printList(reversed);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

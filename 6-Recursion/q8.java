public class q8 {
    /*
     * Pattern: Pure Recursion
     * Company Names: Amazon, Microsoft, Google
     * Difficulty: Easy
     *
     * LeetCode #21: Merge Two Sorted Lists
     *
     * Problem samajh lo:
     * Do sorted linked lists ko recursively merge karna hai.
     *
     * Idea:
     * Jo head chhota ho usse answer ka head banao,
     * aur baaki merge recursively kar do.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m) recursion
     */
    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged = mergeTwoLists(first, second);
        printList(merged);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
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

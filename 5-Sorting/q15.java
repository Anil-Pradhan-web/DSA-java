public class q15 {
    /*
     * Pattern: Sorting / Merge Sort on Linked List
     * Company Names: Amazon, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #148: Sort List
     *
     * Problem samajh lo:
     * Linked list ko O(n log n) time me sort karna hai.
     *
     * Linked list me random access nahi hota,
     * isliye Merge Sort sabse natural choice hoti hai.
     *
     * Steps:
     * 1. slow-fast pointers se middle dhoondo
     * 2. list ko do halves me todo
     * 3. recursively sort karo
     * 4. sorted halves merge karo
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(log n) recursion
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode sorted = sortList(head);
        printList(sorted);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(second);

        return merge(left, right);
    }

    private static ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }

        tail.next = first != null ? first : second;
        return dummy.next;
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

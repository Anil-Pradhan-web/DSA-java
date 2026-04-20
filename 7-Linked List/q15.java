public class q15 {

    // Linked List ka node structure
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Pattern: Merge Sort
     * Company Names: Amazon, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #148: Sort List
     *
     * Approach:
     * Linked List ko merge sort se sort karenge:
     * 1. Middle find karo (slow-fast pointer)
     * 2. List ko 2 parts mein tod do
     * 3. Recursively dono ko sort karo
     * 4. Merge karke final sorted list bana do
     *
     * Time Complexity: O(N log N)
     * Space Complexity: O(1) (ignore recursion stack)
     */

    // MAIN FUNCTION jo list ko sort karega
    public static ListNode sortList(ListNode head) {

        // Base case: agar list empty hai ya sirf 1 element hai → already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // STEP 1: middle find karna (slow-fast pointer approach)
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // ye track karega slow ke piche wala node

        while (fast != null && fast.next != null) {
            prev = slow;          // slow ke piche wala node store
            slow = slow.next;     // slow 1 step
            fast = fast.next.next; // fast 2 steps
        }

        // STEP 2: list ko 2 halves mein todna
        prev.next = null; // yahan cut lag gaya → 2 alag lists ban gayi

        // left half = head se prev tak
        // right half = slow se end tak

        // STEP 3: recursively dono halves sort karo
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // STEP 4: merge sorted halves
        return merge(left, right);
    }

    // 2 sorted linked lists ko merge karega (same as merge in merge sort)
    public static ListNode merge(ListNode l1, ListNode l2) {

        // dummy node banate hain taaki easily result build kar sake
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy; // tail pointer jo result list ko build karega

        // jab tak dono lists mein elements hain
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tail.next = l1;   // chhota element attach
                l1 = l1.next;     // l1 aage badhao
            } else {
                tail.next = l2;   // chhota element attach
                l2 = l2.next;     // l2 aage badhao
            }

            tail = tail.next; // tail ko aage move karo
        }

        // agar kisi ek list mein elements bach gaye ho
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        // dummy ka next hi actual sorted list ka head hoga
        return dummy.next;
    }

    public static void main(String[] args) {

        // Example: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        // sort kar rahe hain
        head = sortList(head);

        // output print
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
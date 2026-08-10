import java.util.PriorityQueue;

public class q10 {
    /*
     * Pattern: Heap / K-way Merge
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Hard
     *
     * LeetCode #23: Merge K Sorted Lists
     *
     * Problem samajh lo:
     * Humein k sorted linked lists di gayi hain.
     * Inhe ek single sorted linked list me merge karna hai.
     *
     * Example:
     * lists = [[1, 4, 5], [1, 3, 4], [2, 6]]
     * Answer = [1, 1, 2, 3, 4, 4, 5, 6]
     *
     * Best idea:
     * Min heap use karo jisme har list ka current head daalo.
     * Har baar heap ka top (sabse chhota) nikalo aur usse result me add karo.
     * Us node ka next wala element heap me daalo.
     *
     * Kyun efficient hai?
     * Normal merge 2 lists ka O(n + m) hai. K lists ke liye ek-ek karke merge
     * karne par O(k^2 * n) ho jata hai. Heap se O(n log k) me ho jata hai.
     *
     * Time Complexity: O(n log k) where n = total nodes
     * Space Complexity: O(k)
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = createList(new int[] { 1, 4, 5 });
        ListNode list2 = createList(new int[] { 1, 3, 4 });
        ListNode list3 = createList(new int[] { 2, 6 });

        ListNode[] lists = { list1, list2, list3 };

        ListNode result = mergeKLists(lists);
        printList(result);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min heap by node value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val));

        // Saare lists ka head daalo
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Heap se ek-ek karke smallest nikalo
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.add(node.next);
            }
        }

        return dummy.next;
    }

    private static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
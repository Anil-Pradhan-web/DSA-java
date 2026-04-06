import java.util.PriorityQueue;

public class q14 {
    /*
     * Pattern: Sorting / Heap Merge
     * Company Names: Amazon, Google, MS
     * Difficulty: Hard
     *
     * LeetCode #23: Merge k Sorted Lists
     *
     * Problem samajh lo:
     * Humein k sorted linked lists ko merge karke ek final sorted linked list banani hai.
     *
     * Best idea:
     * Min-heap use karo.
     * Har list ka current smallest node heap me daalo.
     * Heap se minimum nikaal kar answer me jodo,
     * phir us node ka next agar exist karta hai to heap me daal do.
     *
     * Isse hamesha globally smallest available node milta rahega.
     *
     * Time Complexity: O(N log k)
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode third = new ListNode(2, new ListNode(6));
        ListNode[] lists = {first, second, third};

        ListNode merged = mergeKLists(lists);
        printList(merged);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap =
            new PriorityQueue<>((first, second) -> Integer.compare(first.val, second.val));

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            tail.next = node;
            tail = tail.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

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

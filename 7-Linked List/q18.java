import java.util.PriorityQueue;

public class q18 {

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
     * Pattern: Merge / Priority Queue (Min-Heap)
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Hard
     *
     * LeetCode #23: Merge k Sorted Lists
     *
     * Problem samajh lo:
     * K sorted linked lists diye gaye hain, unhe merge karke ek sorted list banani hai.
     *
     * APPROACH (Min-Heap):
     * - Har list ka first node heap me daalo
     * - Sabse chhota element nikaalo
     * - Uska next node heap me daal do
     * - Repeat until heap empty
     *
     * Time Complexity: O(N log K)
     *   (N total nodes, aur har insertion/removal heap me log K)
     *
     * Space Complexity: O(K)  (heap size max K)
     */

    public static ListNode mergeKLists(ListNode[] lists) {

        // Step 1: Min-Heap create karo (value ke basis pe compare)
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Step 2: Har list ka first node heap me daalo
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Dummy node for result list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        /*
         * Step 3:
         * Jab tak heap empty nahi hota:
         * - smallest node nikalo
         * - result me add karo
         * - uska next heap me daalo
         */
        while (!pq.isEmpty()) {

            // smallest node nikaala
            ListNode minNode = pq.poll();

            // result list me attach kiya
            curr.next = minNode;
            curr = curr.next;

            // agar is node ka next hai → heap me daal do
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        // final sorted list ka head
        return dummy.next;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Merge k Sorted Lists - Run successful");
    }
}
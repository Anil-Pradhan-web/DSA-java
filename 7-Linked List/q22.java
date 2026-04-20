public class q22 {

    // Doubly Linked List node with child pointer
    static class ListNode {
        int val;
        ListNode prev, next, child; // extra child pointer

        ListNode(int x) {
            val = x;
            next = null;
            prev = null;
            child = null;
        }
    }

    /*
     * Pattern: DFS / Pointer Manipulation
     * Company Names: Amazon, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #430: Flatten a Multilevel Doubly LL
     *
     * Problem samajh lo:
     * Har node ke paas next ke saath ek "child" pointer bhi ho sakta hai.
     * Isko flatten karke ek single-level doubly linked list banana hai.
     *
     * APPROACH:
     * - DFS (depth-first) traversal
     * - Jab child mile → usko flatten karo aur beech me insert karo
     * - Tail ko original next se connect karo
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1) (ignore recursion stack)
     */

    public static ListNode flatten(ListNode head) {

        if (head == null) return null;

        // DFS helper call
        dfs(head);

        return head;
    }

    /*
     * DFS helper function:
     * Ye function flatten karke last node (tail) return karta hai
     */
    private static ListNode dfs(ListNode node) {

        ListNode curr = node;
        ListNode last = null; // current level ka last node track karega

        while (curr != null) {

            ListNode next = curr.next; // next ko save kar lo

            /*
             * Agar current node ke paas child hai
             */
            if (curr.child != null) {

                // Step 1: child list ko flatten karo
                ListNode childHead = curr.child;
                ListNode childTail = dfs(childHead);

                // Step 2: current node ko child ke head se connect karo
                curr.next = childHead;
                childHead.prev = curr;

                // Step 3: child ke tail ko original next se connect karo
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // child pointer ko null kar do (flatten ho gaya)
                curr.child = null;

                // last ko update karo
                last = childTail;
            } else {
                // agar child nahi hai → current hi last ho sakta hai
                last = curr;
            }

            // next node pe move karo
            curr = next;
        }

        // is segment ka last node return karo
        return last;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Flatten a Multilevel Doubly LL - Run successful");
    }
}
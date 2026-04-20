public class q4 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Pattern: Fast-Slow pointer
     * Company Names: Infosys, Capgemini
     * Difficulty: Easy
     *
     * LeetCode #876: Middle of Linked List
     *
     * Problem samajh lo:
     * Linked list ka middle node find karna hai. Slow 1 step, fast 2 steps chalega.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode middleNode(ListNode head) {
        // Step 1: do pointers slow aur fast head par rakho
        ListNode slow = head;
        ListNode fast = head;

        // Step 2: fast pointer 2 steps, slow 1 step chalega
        // Jab fast last node pe ya null pe pahunchega, slow exact middle pe hoga
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: slow pointer middle node hai, usko return kardo
        return slow;
    }


    public static void main(String[] args) {
        // Example test
        System.out.println("Middle of Linked List - Run successful");
    }
}

public class q3 {
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
     * Company Names: TCS, Wipro, Cognizant
     * Difficulty: Easy
     *
     * LeetCode #141: Linked List Cycle
     *
     * Problem samajh lo:
     * Check karna hai ki linked list mein koi cycle hai ya nahi. Fast aur slow pointers use karenge.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static boolean hasCycle(ListNode head) {
        // Step 1: do pointers set karo, dono head se start honge
        ListNode slow = head;
        ListNode fast = head;

        // Step 2: fast pointer 2 steps chalega aur slow 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;         // 1 step aage
            fast = fast.next.next;    // 2 steps aage

            // Step 3: agar cycle hai, to fast aur slow kabhi na kabhi milenge
            if (slow == fast) {
                return true;          // Cycle mil gayi
            }
        }

        // Step 4: agar fast null pe pahunch gaya, matlab cycle nahi hai
        return false;
    }


    public static void main(String[] args) {
        // Example test
        System.out.println("Linked List Cycle - Run successful");
    }
}

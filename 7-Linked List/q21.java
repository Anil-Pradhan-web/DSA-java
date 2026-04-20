import java.util.Stack;

public class q21 {

    // Linked List ka basic node structure
    static class ListNode {
        int val;        // node ka data (digit)
        ListNode next;  // next node ka reference

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Pattern: Stack / Reversal
     * Company Names: Amazon, Meta
     * Difficulty: Medium
     *
     * LeetCode #445: Add Two Numbers II
     *
     * Problem samajh lo:
     * Do numbers linked list mein diye gaye hain (NORMAL order mein).
     *
     * Example:
     * l1: 7 → 2 → 4 → 3   (7243)
     * l2: 5 → 6 → 4       (564)
     *
     * Output:
     * 7 → 8 → 0 → 7       (7807)
     *
     * PROBLEM:
     * - Hum direct left to right add nahi kar sakte (carry issue)
     *
     * APPROACH (Stack):
     * - Dono lists ke values stack me daal do
     * - Last se addition start karo (pop karke)
     * - Result ko head insertion se build karo
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)  (stacks use ho rahe hain)
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Step 1: Dono lists ke values stacks me push karo
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null; // result list ka head

        /*
         * Step 2:
         * Jab tak stack me elements hain ya carry bacha hai
         */
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {

            int sum = carry;

            // stack 1 se value lo
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            // stack 2 se value lo
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            /*
             * sum ready:
             * digit = sum % 10
             * carry = sum / 10
             */
            carry = sum / 10;

            // Step 3:
            // New node create karke front me insert karte hain
            ListNode node = new ListNode(sum % 10);

            node.next = head; // head insertion
            head = node;
        }

        return head;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Add Two Numbers II - Run successful");
    }
}
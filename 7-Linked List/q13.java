public class q13 {

    // Linked List ka basic node structure
    static class ListNode {
        int val;        // node ka data (single digit)
        ListNode next;  // next node ka reference

        ListNode(int x) {
            val = x;        // value assign
            next = null;    // initially next null
        }
    }

    /*
     * Pattern: Math + Pointer Manipulation
     * Company Names: Amazon, Microsoft, Meta
     * Difficulty: Medium
     *
     * LeetCode #2: Add Two Numbers
     *
     * Problem samajh lo:
     * Do numbers linked list ke form mein diye gaye hain (REVERSED order mein).
     * Har node ek digit represent karta hai.
     *
     * Example:
     * l1: 2 → 4 → 3   (represents 342)
     * l2: 5 → 6 → 4   (represents 465)
     *
     * Output:
     * 7 → 0 → 8  (represents 807)
     *
     * APPROACH:
     * - Digit by digit addition karenge (school addition jaisa)
     * - Carry maintain karenge
     * - Result ko new linked list mein build karenge
     *
     * Time Complexity: O(max(N, M))
     * Space Complexity: O(max(N, M))
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node taaki result list easily build ho sake
        ListNode dummy = new ListNode(0);

        // 'curr' pointer result list ko build karega
        ListNode curr = dummy;

        // Carry (jaise normal addition mein hota hai)
        int carry = 0;

        /*
         * Step 1:
         * Loop tab tak chalega jab tak:
         * - l1 ya l2 mein nodes bache hain
         * - ya carry bacha hai
         */
        while (l1 != null || l2 != null || carry != 0) {

            // Current sum start hota hai carry se
            int sum = carry;

            // Agar l1 available hai, uska value add karo
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next; // l1 ko aage badhao
            }

            // Agar l2 available hai, uska value add karo
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next; // l2 ko aage badhao
            }

            /*
             * Ab sum ready hai:
             * - sum % 10 → current digit
             * - sum / 10 → next carry
             */

            // Naya carry calculate
            carry = sum / 10;

            // Current digit ka node bana ke result list me add karo
            curr.next = new ListNode(sum % 10);

            // curr pointer ko aage badhao
            curr = curr.next;
        }

        // Dummy ka next hi actual result list ka head hoga
        return dummy.next;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Add Two Numbers - Run successful");
    }
}
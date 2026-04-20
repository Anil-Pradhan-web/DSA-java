public class q14 {

    // Linked List ka basic node structure
    static class ListNode {
        int val;        // node ka data
        ListNode next;  // next node ka reference

        ListNode(int x) {
            val = x;        // value assign
            next = null;    // initially next null
        }
    }

    /*
     * Pattern: Pointer Manipulation
     * Company Names: Flipkart, Amazon
     * Difficulty: Medium
     *
     * LeetCode #328: Odd Even Linked List
     *
     * Problem samajh lo:
     * Linked list ke nodes ko unke INDEX ke basis pe group karna hai:
     * - Pehle saare odd index wale nodes
     * - Phir saare even index wale nodes
     *
     * IMPORTANT:
     * - Indexing 1-based hoti hai (head = position 1 = odd)
     *
     * Example:
     * Input:  1 → 2 → 3 → 4 → 5
     * Output: 1 → 3 → 5 → 2 → 4
     *
     * APPROACH:
     * - 2 separate chains maintain karte hain:
     *   → odd nodes chain
     *   → even nodes chain
     * - End me dono ko connect kar dete hain
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode oddEvenList(ListNode head) {

        // Edge case: agar list empty hai
        if (head == null) return null;

        // Step 1:
        // odd pointer head se start karega (index 1)
        ListNode odd = head;

        // even pointer second node se start karega (index 2)
        ListNode even = head.next;

        // evenHead store karte hain taaki baad me connect kar sake
        ListNode evenHead = even;

        /*
         * Step 2:
         * Loop tab tak chalega jab tak even aur uska next exist karta hai
         * (kyunki hum pair-wise jump kar rahe hain)
         */
        while (even != null && even.next != null) {

            /*
             * odd.next ko next odd node se connect karte hain
             * (even.next actually next odd hota hai)
             */
            odd.next = even.next;

            // odd pointer ko aage badhao
            odd = odd.next;

            /*
             * even.next ko next even node se connect karte hain
             * (odd.next actually next even hota hai)
             */
            even.next = odd.next;

            // even pointer ko aage badhao
            even = even.next;
        }

        /*
         * Step 3:
         * Ab odd list ke end pe even list ko attach kar dete hain
         */
        odd.next = evenHead;

        // Head unchanged rehta hai
        return head;
    }

    public static void main(String[] args) {

        // Sirf run check
        System.out.println("Odd Even Linked List - Run successful");
    }
}
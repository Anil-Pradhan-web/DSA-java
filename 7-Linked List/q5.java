public class q5 {

    // Linked List ka basic node structure
    static class ListNode {
        int val;        // node ki value
        ListNode next;  // next node ka reference

        // constructor
        ListNode(int x) {
            val = x;        // value assign
            next = null;    // initially next null
        }
    }

    /*
     * Pattern: Pointer Manipulation
     * Company Names: TCS, HCL
     * Difficulty: Easy
     *
     * LeetCode #237: Delete Node in Linked List
     *
     * Problem samajh lo:
     * Tumhe head nahi diya gaya hai, sirf ek node diya hai jo delete karna hai.
     *
     * IMPORTANT CONCEPT:
     * Normally delete karne ke liye previous node chahiye hota hai,
     * lekin yahan trick use karte hain:
     *
     * → Given node ko directly delete nahi karte
     * → Uski value ko next node se replace kar dete hain
     * → Fir next node ko skip karke "delete" kar dete hain
     *
     * Example:
     * 4 -> 5 -> 1 -> 9  (delete 5)
     *
     * Step 1: copy next value → 4 -> 1 -> 1 -> 9
     * Step 2: skip next node → 4 -> 1 -> 9
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */

    public static void deleteNode(ListNode node) {

        // Edge case (generally problem guarantee karta hai ki node last nahi hoga)
        // Agar last node hua toh yeh approach kaam nahi karega

        // Step 1:
        // current node ki value ko next node ki value se replace kar rahe hain
        // matlab logically hum next node ka data current node mein copy kar rahe hain
        node.val = node.next.val;

        // Step 2:
        // next node ko skip kar diya → effectively delete ho gaya
        // current node ab directly next ke next ko point karega
        node.next = node.next.next;
    }

    public static void main(String[] args) {

        // Yeh sirf run check ke liye hai (actual deletion test nahi)
        System.out.println("Delete Node in Linked List - Run successful");
    }
}
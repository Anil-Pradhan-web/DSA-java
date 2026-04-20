public class q8 {

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
     * Pattern: Two Pointer
     * Company Names: Cognizant, Amazon
     * Difficulty: Easy
     *
     * LeetCode #160: Intersection of Two Linked Lists
     *
     * Problem samajh lo:
     * Do linked lists diye gaye hain, unka intersection point (common node) find karna hai.
     *
     * IMPORTANT:
     * Intersection ka matlab value same hona nahi hai,
     * balki SAME NODE reference hona hai (same memory location).
     *
     * Example:
     * A: 1 -> 2 -> 3 \
     *                  -> 7 -> 8
     * B:       4 -> 5 /
     *
     * Intersection node = 7
     *
     * Approach (Two Pointer Trick):
     * - Dono pointers ko unke respective lists pe chalao
     * - Jab pointer end (null) pe pahunch jaye:
     *      → usko dusri list ke head pe bhej do
     *
     * WHY IT WORKS?
     * - Pointer A travel karega: lengthA + lengthB
     * - Pointer B travel karega: lengthB + lengthA
     * - Dono equal distance cover karenge → intersection pe milenge
     *
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Agar koi bhi list empty hai → intersection possible nahi
        if (headA == null || headB == null) return null;

        // Dono pointers initialize kar rahe hain
        ListNode a = headA;
        ListNode b = headB;

        /*
         * Loop tab tak chalega jab tak dono pointers same node pe na aa jayein
         * (ya dono null na ho jayein)
         */
        while (a != b) {

            /*
             * Agar 'a' end pe pahunch gaya (null):
             * → use list B ke head pe bhej do
             * warna normal next pe move karo
             */
            a = (a == null) ? headB : a.next;

            /*
             * Agar 'b' end pe pahunch gaya (null):
             * → use list A ke head pe bhej do
             * warna normal next pe move karo
             */
            b = (b == null) ? headA : b.next;
        }

        /*
         * Yahan 2 cases possible hain:
         * 1. Dono kisi intersection node pe mile → wahi return hoga
         * 2. Dono null pe mile → matlab intersection nahi hai
         */
        return a;
    }

    public static void main(String[] args) {

        // Sirf run check (actual intersection test yahan nahi likha)
        System.out.println("Intersection of Two Linked Lists - Run successful");
    }
}
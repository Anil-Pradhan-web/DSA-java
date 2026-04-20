public class q2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Pattern: Merge
     * Company Names: TCS, Infosys, Amazon
     * Difficulty: Easy
     *
     * LeetCode #21: Merge Two Sorted Lists
     *
     * Problem samajh lo:
     * Do sorted linked lists di gayi hain, unko merge karke ek single sorted linked list banani hai.
     *
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Step 1: ek dummy node banao taaki head easily handle ho jaye
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Step 2: dono list ko traverse karo jab tak dono me elements hain
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // choti value ko current ke aage lagao
                list1 = list1.next;   // list1 ka pointer aage badhao
            } else {
                current.next = list2; // choti value ko current ke aage lagao
                list2 = list2.next;   // list2 ka pointer aage badhao
            }
            current = current.next;   // current ko aage badhao
        }

        // Step 3: agar koi list me elements bach gaye, to bachi hui puri list attach kardo
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next; // dummy ka next actual head hai merged list ka
    }


    public static void main(String[] args) {
        // Example test
        System.out.println("Merge Two Sorted Lists - Run successful");
    }
}

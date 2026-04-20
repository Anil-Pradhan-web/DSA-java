public class q1 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Pattern: Reversal
     * Company Names: TCS, Wipro, Har jagah
     * Difficulty: Easy
     *
     * LeetCode #206: Reverse Linked List
     *
     * Problem samajh lo:
     * Linked list ko reverse karna hai. Current node ka next previous ko point karega.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public static ListNode reverseList(ListNode head) {
        // Step 1: prev pointer ko null se start karo, aur curr ko head pe rakho
        ListNode prev = null;
        ListNode curr = head;

        // Step 2: list me traverse karo jab tak curr null na ho jaye
        while (curr != null) {
            ListNode nextTemp = curr.next; // aage wala node save karke rakho
            curr.next = prev;              // current node ka pointer peeche (prev) ki taraf mod do
            prev = curr;                   // prev ko aage badhao (curr ki jagah)
            curr = nextTemp;               // curr ko aage badhao (saved nextTemp ki jagah)
        }
        
        // Step 3: loop khatam hone ke baad prev naye head ko point karega
        return prev;
    }


    public static void main(String[] args) {
        // Example test
        System.out.println("Reverse Linked List - Run successful");
    }
}

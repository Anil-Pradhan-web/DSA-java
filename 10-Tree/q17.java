/*
 * Pattern: Tree BFS / Pointer Linking
 * Company Names: Amazon, Bloomberg
 * Difficulty: Medium
 * Problem: Populating Next Right Pointers in Each Node
 * LeetCode: 116
 *
 * Hinglish Explanation:
 * Perfect binary tree mein har node ka next pointer same level ke next node ko
 * point karega. Since tree perfect hai, left.next = right and right.next =
 * parent.next.left set kar sakte hain.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) excluding recursion stack
 */
public class q17 {
    static class Node {
        int val;
        Node left, right, next;
        Node(int val) { this.val = val; }
    }

    public static Node connect(Node root) {
        if (root == null) return null;

        Node levelStart = root;
        while (levelStart.left != null) {
            Node curr = levelStart;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        connect(root);
        System.out.println(root.left.next.val);
    }
}

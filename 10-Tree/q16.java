/*
 * Pattern: Reverse Preorder DFS
 * Company Names: Adobe, Bloomberg
 * Difficulty: Medium
 * Problem: Flatten Binary Tree to Linked List
 * LeetCode: 114
 *
 * Hinglish Explanation:
 * Tree ko preorder linked list jaisa flatten karna hai using right pointers.
 * Reverse preorder use karo: Right -> Left -> Root. Previous node ko track karke
 * current.right = prev set karo.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q16 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode prev;

    public static void flatten(TreeNode root) {
        prev = null;
        reversePreorder(root);
    }

    private static void reversePreorder(TreeNode root) {
        if (root == null) return;
        reversePreorder(root.right);
        reversePreorder(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        flatten(root);
        System.out.println(root.right.val);
    }
}

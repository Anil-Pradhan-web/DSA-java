/*
 * Pattern: BST Inorder Anomaly
 * Company Names: Amazon, Microsoft
 * Difficulty: Medium
 * Problem: Recover Binary Search Tree
 * LeetCode: 99
 *
 * Hinglish Explanation:
 * BST ka inorder sorted hona chahiye. Agar do nodes swapped hain, inorder mein
 * jahan order break hoga wahan first aur second nodes detect ho jaayenge.
 * Last mein dono values swap kar do.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q32 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode first, second, prev;

    public static void recoverTree(TreeNode root) {
        first = second = prev = null;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        recoverTree(root);
        System.out.println(root.val);
    }
}

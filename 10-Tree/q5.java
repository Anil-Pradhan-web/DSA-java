/*
 * Pattern: DFS Mirror / Swap
 * Company Names: Wipro, Google
 * Difficulty: Easy
 * Problem: Invert Binary Tree
 * LeetCode: 226
 *
 * Hinglish Explanation:
 * Har node par left aur right child swap karna hai.
 * Pehle recursively left aur right subtree invert karo, phir root ke links swap karo.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q5 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        invertTree(root);
        System.out.println(root.left.val);
    }
}

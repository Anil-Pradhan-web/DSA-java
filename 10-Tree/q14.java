/*
 * Pattern: Bottom-up DFS
 * Company Names: Adobe, Bloomberg
 * Difficulty: Easy
 * Problem: Balanced Binary Tree
 * LeetCode: 110
 *
 * Hinglish Explanation:
 * Tree balanced tab hota hai jab har node ke left aur right subtree ki height
 * difference 1 se zyada na ho. Optimized approach height return karta hai aur
 * imbalance milte hi -1 return kar deta hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q14 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        if (left == -1) return -1;
        int right = height(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isBalanced(root));
    }
}

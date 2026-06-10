/*
 * Pattern: DFS Height
 * Company Names: TCS, Cognizant, Google
 * Difficulty: Easy
 * Problem: Maximum Depth of Binary Tree
 * LeetCode: 104
 *
 * Hinglish Explanation:
 * Maximum depth root se deepest leaf tak nodes count karta hai.
 * Har node par left depth aur right depth nikalo, phir max + 1 return karo.
 * Ye classic recursion problem hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q4 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(maxDepth(root));
    }
}

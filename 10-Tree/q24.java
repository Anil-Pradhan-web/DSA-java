/*
 * Pattern: DFS with Running Maximum
 * Company Names: Amazon, Google
 * Difficulty: Medium
 * Problem: Count Good Nodes in Binary Tree
 * LeetCode: 1448
 *
 * Hinglish Explanation:
 * Ek node good tab hota hai jab root se us node tak path mein usse bada value
 * pehle na aaya ho. DFS mein path ka max value carry karo.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q24 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(TreeNode root, int maxSoFar) {
        if (root == null) return 0;
        int good = root.val >= maxSoFar ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, root.val);
        return good + dfs(root.left, maxSoFar) + dfs(root.right, maxSoFar);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        System.out.println(goodNodes(root));
    }
}

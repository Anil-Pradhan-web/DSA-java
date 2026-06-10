/*
 * Pattern: Hard DFS / Tree DP
 * Company Names: Amazon, Google, Meta
 * Difficulty: Hard
 * Problem: Binary Tree Maximum Path Sum
 * LeetCode: 124
 *
 * Hinglish Explanation:
 * Path kisi bhi node se start/end ho sakta hai, but connected hona chahiye.
 * Har node par global max update karo: node.val + leftGain + rightGain.
 * Parent ko sirf ek side ka best gain return kar sakte ho.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q20 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gain(root);
        return maxSum;
    }

    private static int gain(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, gain(root.left));
        int right = Math.max(0, gain(root.right));
        maxSum = Math.max(maxSum, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
}

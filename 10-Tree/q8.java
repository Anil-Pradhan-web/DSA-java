/*
 * Pattern: Root to Leaf DFS
 * Company Names: HCL, Amazon
 * Difficulty: Easy
 * Problem: Path Sum
 * LeetCode: 112
 *
 * Hinglish Explanation:
 * Root se leaf tak koi path hai jiska sum target ke equal ho?
 * Har node par target se current value minus karo. Leaf par agar remaining value
 * current node ke equal hai, path mil gaya.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q8 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val)
            || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        System.out.println(hasPathSum(root, 20));
    }
}

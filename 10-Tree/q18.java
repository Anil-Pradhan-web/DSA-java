/*
 * Pattern: Root to Leaf DFS
 * Company Names: Microsoft, Apple, Google
 * Difficulty: Medium
 * Problem: Sum Root to Leaf Numbers
 * LeetCode: 129
 *
 * Hinglish Explanation:
 * Root se leaf tak digits number banate hain. Har node par current = current * 10
 * + node.val karo. Leaf par current number answer mein add ho jayega.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q18 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int current) {
        if (root == null) return 0;
        current = current * 10 + root.val;
        if (root.left == null && root.right == null) return current;
        return dfs(root.left, current) + dfs(root.right, current);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }
}

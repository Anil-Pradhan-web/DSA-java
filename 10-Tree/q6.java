/*
 * Pattern: Mirror DFS
 * Company Names: Capgemini, Amazon, Google
 * Difficulty: Easy
 * Problem: Symmetric Tree
 * LeetCode: 101
 *
 * Hinglish Explanation:
 * Tree symmetric tab hota hai jab left subtree aur right subtree mirror image hon.
 * Compare karte waqt left.left ko right.right se aur left.right ko right.left se
 * compare karo.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q6 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(isSymmetric(root));
    }
}

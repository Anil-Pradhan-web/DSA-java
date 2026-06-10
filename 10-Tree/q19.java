/*
 * Pattern: Lowest Common Ancestor DFS
 * Company Names: Amazon, Google, Meta
 * Difficulty: Medium
 * Problem: Lowest Common Ancestor of a Binary Tree
 * LeetCode: 236
 *
 * Hinglish Explanation:
 * Binary Tree mein BST property nahi hoti, isliye left aur right dono side search
 * karte hain. Agar p aur q alag-alag side milte hain, current root LCA hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q19 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
    }
}

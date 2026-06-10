/*
 * Pattern: BST Direction Search
 * Company Names: Amazon, Google, Microsoft
 * Difficulty: Easy
 * Problem: Lowest Common Ancestor of a BST
 * LeetCode: 235
 *
 * Hinglish Explanation:
 * BST mein agar p aur q dono current se chote hain to left jao. Dono bade hain
 * to right jao. Agar split ho rahe hain, current node LCA hai.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(1)
 */
public class q28 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
    }
}

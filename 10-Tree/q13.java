/*
 * Pattern: Bottom-up DFS
 * Company Names: Meta, Google, Amazon
 * Difficulty: Easy
 * Problem: Diameter of Binary Tree
 * LeetCode: 543
 *
 * Hinglish Explanation:
 * Diameter kisi bhi two nodes ke beech longest path hai.
 * Har node par possible diameter = left height + right height.
 * Height return karo, aur global diameter update karte jao.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q13 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int diameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(diameterOfBinaryTree(root));
    }
}

/*
 * Pattern: BST Range Recursion
 * Company Names: Amazon, Google
 * Difficulty: Medium
 * Problem: Trim a Binary Search Tree
 * LeetCode: 669
 *
 * Hinglish Explanation:
 * Agar root value low se choti hai, to left subtree bhi useless hai, right trim
 * karo. Agar root high se badi hai, to right subtree useless hai, left trim karo.
 * Range mein hai to dono children trim karo.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q35 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        System.out.println(trimBST(root, 1, 2).val);
    }
}

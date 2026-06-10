/*
 * Pattern: BST Range Validation
 * Company Names: Amazon, Google
 * Difficulty: Medium
 * Problem: Validate Binary Search Tree
 * LeetCode: 98
 *
 * Hinglish Explanation:
 * Sirf immediate child compare karna enough nahi hota. Har node ke liye ek valid
 * range hoti hai. Left subtree range high root banata hai, right subtree range
 * low root banata hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q26 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }
}

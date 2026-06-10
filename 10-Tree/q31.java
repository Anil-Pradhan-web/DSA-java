/*
 * Pattern: BST Delete
 * Company Names: Amazon, Google
 * Difficulty: Medium
 * Problem: Delete Node in a BST
 * LeetCode: 450
 *
 * Hinglish Explanation:
 * Delete mein 3 cases hote hain: leaf, one child, two children.
 * Two children case mein inorder successor use karo, yani right subtree ka
 * minimum node.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(h)
 */
public class q31 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        System.out.println(deleteNode(root, 3).val);
    }
}

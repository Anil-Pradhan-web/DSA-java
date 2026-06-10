/*
 * Pattern: BST Next Greater
 * Company Names: Facebook, Microsoft
 * Difficulty: Medium
 * Problem: Inorder Successor in BST
 * LeetCode: 285
 *
 * Hinglish Explanation:
 * Inorder successor ka matlab next greater node.
 * Agar p.val current se chota hai, current possible successor hai aur left jao.
 * Agar p.val current se bada/equal hai, right jao.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(1)
 */
public class q33 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(inorderSuccessor(root, root.left).val);
    }
}

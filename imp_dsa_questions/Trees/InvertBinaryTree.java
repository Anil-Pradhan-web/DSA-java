public class InvertBinaryTree {
    /*
     * LeetCode #226: Invert Binary Tree
     * Pattern: DFS / Recursion
     * Time: O(n), Space: O(h)
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode inverted = invertTree(root);
        System.out.println("Root: " + inverted.val);
        System.out.println("Left: " + inverted.left.val + ", Right: " + inverted.right.val);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
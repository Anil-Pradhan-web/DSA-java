/*
 * Pattern: Complete Binary Tree Optimization
 * Company Names: Wipro, HCL
 * Difficulty: Medium
 * Problem: Count Nodes in Complete Binary Tree
 * LeetCode: 222
 *
 * Hinglish Explanation:
 * Complete tree mein agar left height aur right height same hai, to tree perfect
 * hai aur nodes directly 2^height - 1 se mil jaate hain. Warna recursively count
 * karo.
 *
 * Time Complexity: O(log n * log n)
 * Space Complexity: O(log n)
 */
public class q9 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int leftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private static int rightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(countNodes(root));
    }
}

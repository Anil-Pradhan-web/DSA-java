/*
 * Pattern: BST Inorder
 * Company Names: Meta, Amazon, Google
 * Difficulty: Medium
 * Problem: Kth Smallest Element in a BST
 * LeetCode: 230
 *
 * Hinglish Explanation:
 * BST ka inorder traversal sorted order deta hai. Isliye kth smallest find karne
 * ke liye inorder traversal karo aur kth visited node answer hoga.
 *
 * Time Complexity: O(h + k)
 * Space Complexity: O(h)
 */
public class q27 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int count;
    static int answer;

    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        answer = -1;
        inorder(root, k);
        return answer;
    }

    private static void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        count++;
        if (count == k) {
            answer = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        System.out.println(kthSmallest(root, 2));
    }
}

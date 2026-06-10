/*
 * Pattern: Divide and Conquer
 * Company Names: Amazon, Microsoft
 * Difficulty: Easy
 * Problem: Convert Sorted Array to Binary Search Tree
 * LeetCode: 108
 *
 * Hinglish Explanation:
 * Sorted array se balanced BST banane ke liye middle element root banao.
 * Left half se left subtree aur right half se right subtree banta hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(log n)
 */
public class q30 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(nums).val);
    }
}

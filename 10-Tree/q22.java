import java.util.*;

/*
 * Pattern: Tree Construction
 * Company Names: Amazon
 * Difficulty: Medium
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * LeetCode: 105
 *
 * Hinglish Explanation:
 * Preorder ka first element root hota hai. Inorder mein root ke left side left
 * subtree aur right side right subtree hota hai. Inorder index map se root split
 * O(1) mein milta hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class q22 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int preIndex;
    static Map<Integer, Integer> map;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder).val);
    }
}

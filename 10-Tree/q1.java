import java.util.*;

/*
 * Pattern: Binary Tree Traversal
 * Company Names: TCS, Wipro, Sab
 * Difficulty: Easy
 * Problem: Binary Tree Inorder Traversal
 * LeetCode: 94
 *
 * Hinglish Explanation:
 * Inorder traversal ka order hota hai Left -> Root -> Right.
 * Agar tree BST hai, to inorder traversal sorted order deta hai.
 * Recursive approach simple hai: pehle left subtree visit karo, phir current node,
 * phir right subtree.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q1 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }
}

import java.util.*;

/*
 * Pattern: Binary Tree Traversal
 * Company Names: TCS, Infosys
 * Difficulty: Easy
 * Problem: Binary Tree Preorder Traversal
 * LeetCode: 144
 *
 * Hinglish Explanation:
 * Preorder traversal ka order hota hai Root -> Left -> Right.
 * Root pehle process hota hai, isliye ye tree copy/serialize type problems mein
 * useful hota hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q2 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(preorderTraversal(root));
    }
}

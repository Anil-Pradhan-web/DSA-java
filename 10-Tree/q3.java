import java.util.*;

/*
 * Pattern: Binary Tree Traversal
 * Company Names: TCS, Wipro
 * Difficulty: Easy
 * Problem: Binary Tree Postorder Traversal
 * LeetCode: 145
 *
 * Hinglish Explanation:
 * Postorder traversal ka order hota hai Left -> Right -> Root.
 * Jab root ka answer children ke answer ke baad calculate karna ho, postorder
 * best hota hai. Height, diameter, delete tree jaise problems isi thinking pe hain.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q3 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(postorderTraversal(root));
    }
}

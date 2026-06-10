import java.util.*;

/*
 * Pattern: BFS Tree View
 * Company Names: Meta, Amazon, Flipkart
 * Difficulty: Medium
 * Problem: Binary Tree Right Side View
 * LeetCode: 199
 *
 * Hinglish Explanation:
 * Right side se tree dekhne par har level ka last node visible hota hai.
 * BFS mein level ke last index wale node ko answer mein add karo.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(w)
 */
public class q12 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) result.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(rightSideView(root));
    }
}

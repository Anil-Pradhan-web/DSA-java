import java.util.*;

/*
 * Pattern: BFS Queue
 * Company Names: Amazon, Microsoft
 * Difficulty: Medium
 * Problem: Binary Tree Zigzag Level Order Traversal
 * LeetCode: 103
 *
 * Hinglish Explanation:
 * Normal level order jaisa hi hai, bas level direction alternate hota hai.
 * Ek level left-to-right, next right-to-left. LinkedList use karke front/back
 * insertion se easy ho jata hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(w)
 */
public class q11 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) level.addLast(node.val);
                else level.addFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(zigzagLevelOrder(root));
    }
}

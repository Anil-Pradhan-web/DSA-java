import java.util.*;

/*
 * Pattern: BFS Queue
 * Company Names: Amazon, Microsoft, Meta
 * Difficulty: Medium
 * Problem: Binary Tree Level Order Traversal
 * LeetCode: 102
 *
 * Hinglish Explanation:
 * Level order traversal mein tree ko level by level print karte hain.
 * Queue use karo. Har level ke start par queue size store karo, wahi current
 * level ke nodes count hain.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(w)
 */
public class q10 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(levelOrder(root));
    }
}

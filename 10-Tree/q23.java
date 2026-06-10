import java.util.*;

/*
 * Pattern: BFS + Column Index
 * Company Names: Meta
 * Difficulty: Medium
 * Problem: Binary Tree Vertical Order Traversal
 * LeetCode: 314
 *
 * Hinglish Explanation:
 * Har node ko ek column assign karo. Root column 0, left child column -1,
 * right child column +1. BFS use karne se top-to-bottom order naturally maintain
 * hota hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class q23 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static class Pair {
        TreeNode node;
        int col;
        Pair(TreeNode node, int col) { this.node = node; this.col = col; }
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            map.computeIfAbsent(pair.col, k -> new ArrayList<>()).add(pair.node.val);
            min = Math.min(min, pair.col);
            max = Math.max(max, pair.col);
            if (pair.node.left != null) queue.offer(new Pair(pair.node.left, pair.col - 1));
            if (pair.node.right != null) queue.offer(new Pair(pair.node.right, pair.col + 1));
        }

        for (int col = min; col <= max; col++) result.add(map.get(col));
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        System.out.println(verticalOrder(root));
    }
}

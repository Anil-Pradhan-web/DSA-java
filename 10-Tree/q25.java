import java.util.*;

/*
 * Pattern: BFS with Indexing
 * Company Names: Amazon, Google
 * Difficulty: Medium
 * Problem: Maximum Width of Binary Tree
 * LeetCode: 662
 *
 * Hinglish Explanation:
 * Width calculate karne ke liye har node ko heap-style index do.
 * Left child = 2*i, right child = 2*i+1. Har level par lastIndex-firstIndex+1
 * width hoti hai. Overflow avoid karne ke liye level start se normalize karo.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(w)
 */
public class q25 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static class Pair {
        TreeNode node;
        long index;
        Pair(TreeNode node, long index) { this.node = node; this.index = index; }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            long start = queue.peek().index;
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                long idx = pair.index - start;
                if (i == 0) first = idx;
                if (i == size - 1) last = idx;
                if (pair.node.left != null) queue.offer(new Pair(pair.node.left, 2 * idx));
                if (pair.node.right != null) queue.offer(new Pair(pair.node.right, 2 * idx + 1));
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        System.out.println(widthOfBinaryTree(root));
    }
}

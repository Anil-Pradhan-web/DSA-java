import java.util.ArrayDeque;
import java.util.Queue;

public class q18 {
    /*
     * Pattern: BFS / Indexed Tree Width
     * Company Names: Amazon, Google
     * Difficulty: Medium
     *
     * LeetCode #662: Maximum Width of Binary Tree
     *
     * Problem samajh lo:
     * Binary tree ka maximum level width nikalna hai,
     * null gaps ko bhi conceptual position me count karna hota hai.
     *
     * BFS with index:
     * Har node ko heap-style index do.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        Queue<NodeInfo> queue = new ArrayDeque<>();
        queue.offer(new NodeInfo(root, 0));
        int answer = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            long base = queue.peek().index;
            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {
                NodeInfo info = queue.poll();
                long index = info.index - base;

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (info.node.left != null) queue.offer(new NodeInfo(info.node.left, 2 * index + 1));
                if (info.node.right != null) queue.offer(new NodeInfo(info.node.right, 2 * index + 2));
            }

            answer = Math.max(answer, (int) (last - first + 1));
        }

        return answer;
    }

    static class NodeInfo {
        TreeNode node;
        long index;

        NodeInfo(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

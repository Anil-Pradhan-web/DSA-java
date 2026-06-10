import java.util.*;

/*
 * Pattern: Controlled Inorder Iterator
 * Company Names: Amazon, Microsoft
 * Difficulty: Medium
 * Problem: BST Iterator
 * LeetCode: 173
 *
 * Hinglish Explanation:
 * Iterator ko next smallest value deni hoti hai. Stack mein current path ke left
 * nodes push karo. next() par node pop karo aur uske right subtree ka left path
 * push karo.
 *
 * Time Complexity: next average O(1), hasNext O(1)
 * Space Complexity: O(h)
 */
public class q29 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static class BSTIterator {
        private Deque<TreeNode> stack = new ArrayDeque<>();

        BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            pushLeft(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        BSTIterator it = new BSTIterator(root);
        System.out.println(it.next());
    }
}

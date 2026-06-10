import java.util.*;

/*
 * Pattern: DFS + HashSet
 * Company Names: Amazon, Google
 * Difficulty: Easy
 * Problem: Two Sum IV - Input is a BST
 * LeetCode: 653
 *
 * Hinglish Explanation:
 * Tree traverse karo aur har node ke liye check karo ki k - node.val pehle dekha
 * hai ya nahi. Agar dekha hai to pair mil gaya.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class q34 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }

    private static boolean dfs(TreeNode root, int k, Set<Integer> seen) {
        if (root == null) return false;
        if (seen.contains(k - root.val)) return true;
        seen.add(root.val);
        return dfs(root.left, k, seen) || dfs(root.right, k, seen);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        System.out.println(findTarget(root, 9));
    }
}

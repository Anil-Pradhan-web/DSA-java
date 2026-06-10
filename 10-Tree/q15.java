import java.util.*;

/*
 * Pattern: Backtracking DFS on Tree
 * Company Names: Adobe, Amazon
 * Difficulty: Medium
 * Problem: Path Sum II
 * LeetCode: 113
 *
 * Hinglish Explanation:
 * Root se leaf tak saare paths chahiye jinka sum target ke equal ho.
 * Current path list maintain karo. Node add karo, recursive call karo, phir remove
 * karo. Ye choose-explore-undo pattern hai.
 *
 * Time Complexity: O(n * h)
 * Space Complexity: O(h)
 */
public class q15 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;

        path.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(root.left, target - root.val, path, result);
            dfs(root.right, target - root.val, path, result);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        System.out.println(pathSum(root, 9));
    }
}

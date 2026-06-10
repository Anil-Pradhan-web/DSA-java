/*
 * Pattern: DFS Comparison
 * Company Names: TCS, Infosys
 * Difficulty: Easy
 * Problem: Same Tree
 * LeetCode: 100
 *
 * Hinglish Explanation:
 * Do trees same tab hain jab structure bhi same ho aur har corresponding node ki
 * value bhi same ho. Agar ek null hai aur doosra null nahi, answer false.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class q7 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        System.out.println(isSameTree(a, b));
    }
}

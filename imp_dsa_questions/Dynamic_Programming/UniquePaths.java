public class UniquePaths {
    /*
     * LeetCode #62: Unique Paths
     * Pattern: DP (2D)
     * Time: O(m * n), Space: O(n)
     */
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println("Unique paths: " + uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
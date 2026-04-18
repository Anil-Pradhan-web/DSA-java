public class q5 {
    /*
     * Pattern: Pure Recursion with Memoization
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Easy
     *
     * LeetCode #70: Climbing Stairs
     *
     * Problem samajh lo:
     * 1 ya 2 steps le kar total n stairs tak kitne ways se pahunch sakte ho.
     *
     * Recurrence:
     * ways(n) = ways(n - 1) + ways(n - 2)
     *
     * Ye Fibonacci jaisa pattern hai.
     * Memoization use karne se repeated subproblems avoid ho jaate hain.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return countWays(n, memo);
    }

    private static int countWays(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo);
        return memo[n];
    }
}

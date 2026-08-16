public class ClimbingStairs {
    /*
     * LeetCode #70: Climbing Stairs
     * Pattern: DP (Fibonacci)
     * Time: O(n), Space: O(1)
     */
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Ways: " + climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev1 = 1, prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }
}
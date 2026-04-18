public class q1 {
    /*
     * Pattern: Pure Recursion
     * Company Names: TCS, Wipro, All
     * Difficulty: Easy
     *
     * LeetCode #509: Fibonacci Number
     *
     * Problem samajh lo:
     * Fibonacci sequence me:
     * F(0) = 0
     * F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)
     *
     * Ye classic recursion tree problem hai.
     * Base case 0 aur 1 hai.
     *
     * Time Complexity: O(2^n) for naive recursion
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}

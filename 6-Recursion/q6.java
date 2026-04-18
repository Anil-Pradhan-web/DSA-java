public class q6 {
    /*
     * Pattern: Pure Recursion / Fast Exponentiation
     * Company Names: Amazon, Adobe, Google
     * Difficulty: Medium
     *
     * LeetCode #50: Pow(x, n)
     *
     * Problem samajh lo:
     * x^n nikalna hai.
     *
     * Smart recursion:
     * Agar n even hai to:
     * x^n = (x^(n/2))^2
     *
     * Agar n odd hai to:
     * x^n = x * x^(n-1)
     *
     * Negative exponent bhi handle karna hota hai.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        long power = n;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        return fastPow(x, power);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }

        return half * half * x;
    }
}

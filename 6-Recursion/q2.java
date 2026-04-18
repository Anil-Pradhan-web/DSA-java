public class q2 {
    /*
     * Pattern: Pure Recursion
     * Company Names: TCS, Infosys
     * Difficulty: Easy
     *
     * LeetCode #231: Power of Two
     *
     * Problem samajh lo:
     * Check karna hai ki given number power of 2 hai ya nahi.
     *
     * Recursive idea:
     * Agar n power of 2 hai to repeatedly 2 se divide karne par akhir me 1 milega.
     *
     * Base cases:
     * n == 1 -> true
     * n <= 0 ya odd -> false
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }

        if (n <= 0 || n % 2 != 0) {
            return false;
        }

        return isPowerOfTwo(n / 2);
    }
}

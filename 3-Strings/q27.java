public class q27 {
    /*
     * Pattern: Strings
     * Company Names: Meta, Amazon
     * Difficulty: Medium
     *
     * LeetCode #91: Decode Ways
     *
     * Problem samajh lo:
     * Numeric string di hoti hai, jahan:
     * 1 -> A, 2 -> B, ... 26 -> Z
     * Humein count nikalna hai ki string ko total kitne valid ways me decode kar sakte hain.
     *
     * Example:
     * s = "226"
     * Answer = 3
     *
     * DP idea:
     * dp[i] = first i characters ko decode karne ke number of ways
     *
     * Current position par:
     * 1. Ek single digit valid ho to dp[i - 1] contribute karega
     * 2. Do-digit number 10 se 26 ke beech ho to dp[i - 2] contribute karega
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            char current = s.charAt(i - 1);
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (current != '0') {
                dp[i] += dp[i - 1];
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}

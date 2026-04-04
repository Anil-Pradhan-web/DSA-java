public class q30 {
    /*
     * Pattern: Strings
     * Company Names: Google, Meta
     * Difficulty: Hard
     *
     * LeetCode #44: Wildcard Matching
     *
     * Problem samajh lo:
     * Pattern me do special characters ho sakte hain:
     * '?' -> kisi bhi ek character ko match karta hai
     * '*' -> kisi bhi sequence ko match karta hai, including empty sequence
     *
     * Humein check karna hai ki poori string pattern se match hoti hai ya nahi.
     *
     * Example:
     * s = "adceb", p = "*a*b"
     * Answer = true
     *
     * DP idea:
     * dp[i][j] ka matlab:
     * first i characters of s aur first j characters of p match karte hain ya nahi
     *
     * Cases:
     * 1. Normal char ya '?' ho:
     *    previous diagonal state dekhte hain
     * 2. '*' ho:
     *    ya to empty sequence treat karo
     *    ya current character consume karne do
     *
     * Time Complexity: O(n * m)
     * Space Complexity: O(n * m)
     */
    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char patternChar = p.charAt(j - 1);

                if (patternChar == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (patternChar == '?' || patternChar == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}

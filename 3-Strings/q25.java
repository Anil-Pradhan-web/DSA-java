import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q25 {
    /*
     * Pattern: Strings
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #139: Word Break
     *
     * Problem samajh lo:
     * Humein check karna hai ki string ko dictionary ke words me break kiya ja sakta hai ya nahi.
     *
     * Example:
     * s = "leetcode"
     * wordDict = ["leet", "code"]
     * Answer = true
     *
     * DP idea:
     * dp[i] ka matlab hoga ki first i characters valid dictionary words me split ho sakte hain ya nahi.
     *
     * Agar koi position j par dp[j] true hai
     * aur substring(j, i) dictionary me present hai,
     * to dp[i] bhi true ho jayega.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q27 {
    /*
     * Pattern: Backtracking + Memoization
     * Company Names: Google, Amazon
     * Difficulty: Hard
     *
     * LeetCode #140: Word Break II
     *
     * Problem samajh lo:
     * String ko dictionary words me split karke saare possible sentences return karne hain.
     *
     * Ye plain backtracking se slow ho sakta hai,
     * isliye memoization useful hoti hai.
     *
     * Idea:
     * Har start index se possible valid sentences cache kar lo.
     *
     * Time Complexity: Output dependent
     * Space Complexity: O(n + output)
     */
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        List<String>[] memo = new ArrayList[s.length() + 1];
        return dfs(s, 0, words, memo);
    }

    private static List<String> dfs(String s, int start, Set<String> words, List<String>[] memo) {
        if (memo[start] != null) {
            return memo[start];
        }

        List<String> result = new ArrayList<>();

        if (start == s.length()) {
            result.add("");
            memo[start] = result;
            return result;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (words.contains(word)) {
                List<String> suffixes = dfs(s, end, words, memo);

                for (String suffix : suffixes) {
                    if (suffix.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + suffix);
                    }
                }
            }
        }

        memo[start] = result;
        return result;
    }
}

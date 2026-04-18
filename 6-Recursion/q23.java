import java.util.ArrayList;
import java.util.List;

public class q23 {
    /*
     * Pattern: Backtracking / Partitioning
     * Company Names: Amazon, Google
     * Difficulty: Medium
     *
     * LeetCode #131: Palindrome Partitioning
     *
     * Problem samajh lo:
     * String ko aise parts me todna hai jahan har part palindrome ho.
     *
     * Time Complexity: Exponential
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), answer);
        return answer;
    }

    private static void backtrack(String s, int start, List<String> current, List<List<String>> answer) {
        if (start == s.length()) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, answer);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

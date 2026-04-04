import java.util.ArrayList;
import java.util.List;

public class q18 {
    /*
     * Pattern: Strings
     * Company Names: Paytm, Zomato
     *
     * LeetCode #131: Palindrome Partitioning
     *
     * Problem samajh lo:
     * Humein string ko aise parts me todna hai jahan har part palindrome ho.
     * Saari possible valid partitions return karni hoti hain.
     *
     * Example:
     * s = "aab"
     * Answer = [["a", "a", "b"], ["aa", "b"]]
     *
     * Best idea:
     * Backtracking use karo.
     * Har position se possible substrings try karo.
     * Agar substring palindrome hai,
     * to usse current path me add karke aage recurse karo.
     *
     * Jab string ka end reach ho jaye,
     * current partition ek valid answer hai.
     *
     * Time Complexity: Exponential, because all partitions explore hoti hain
     * Space Complexity: Recursion + answer dependent
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

    private static void backtrack(
        String s,
        int start,
        List<String> current,
        List<List<String>> answer
    ) {
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

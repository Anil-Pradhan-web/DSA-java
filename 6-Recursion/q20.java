import java.util.ArrayList;
import java.util.List;

public class q20 {
    /*
     * Pattern: Backtracking / Phone Keypad
     * Company Names: Amazon, Google, MS
     * Difficulty: Medium
     *
     * LeetCode #17: Letter Combinations of a Phone Number
     *
     * Problem samajh lo:
     * Har digit ke multiple possible letters hote hain.
     * Humein saari possible letter combinations return karni hain.
     *
     * Ye backtracking tree hota hai jahan har digit ek level banata hai.
     *
     * Time Complexity: Exponential in digits count
     * Space Complexity: O(digits length)
     */
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        if (digits.isEmpty()) {
            return answer;
        }

        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), mapping, answer);
        return answer;
    }

    private static void backtrack(
        String digits,
        int index,
        StringBuilder current,
        String[] mapping,
        List<String> answer
    ) {
        if (index == digits.length()) {
            answer.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            backtrack(digits, index + 1, current, mapping, answer);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

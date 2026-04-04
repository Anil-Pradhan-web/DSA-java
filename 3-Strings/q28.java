import java.util.ArrayList;
import java.util.List;

public class q28 {
    /*
     * Pattern: Strings
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #17: Letter Combinations of a Phone Number
     *
     * Problem samajh lo:
     * Phone keypad ke digits diye hote hain.
     * Har digit ke corresponding letters hote hain.
     * Humein saari possible letter combinations return karni hoti hain.
     *
     * Example:
     * digits = "23"
     * Answer = [ad, ae, af, bd, be, bf, cd, ce, cf]
     *
     * Backtracking idea:
     * Har digit ke letters me se ek-ek choice lete jao
     * aur recursive tree build karo.
     * Jab current combination ki length digits ke equal ho jaye,
     * use answer me add kar do.
     *
     * Time Complexity: Exponential in number of digits
     * Space Complexity: Recursion + answer dependent
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

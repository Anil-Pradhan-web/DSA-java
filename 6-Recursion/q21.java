import java.util.ArrayList;
import java.util.List;

public class q21 {
    /*
     * Pattern: Backtracking / Constraint Satisfaction
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #22: Generate Parentheses
     *
     * Problem samajh lo:
     * n pairs ke valid parentheses combinations generate karne hain.
     *
     * Rules:
     * open count n se zyada nahi ho sakta
     * close count open count se zyada nahi ho sakta
     *
     * Time Complexity: Catalan number growth
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), answer);
        return answer;
    }

    private static void backtrack(int n, int open, int close, StringBuilder current, List<String> answer) {
        if (current.length() == 2 * n) {
            answer.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(n, open + 1, close, current, answer);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            backtrack(n, open, close + 1, current, answer);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

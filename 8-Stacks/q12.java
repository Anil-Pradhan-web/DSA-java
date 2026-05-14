import java.util.ArrayDeque;
import java.util.Deque;

public class q12 {
    /*
     * Pattern: Stack / Parentheses Scoring
     * Company Names: Paytm, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #856: Score of Parentheses
     *
     * Problem samajh lo:
     * () ka score 1 hai
     * AB ka score A + B
     * (A) ka score 2 * A
     *
     * Stack me previous partial scores maintain karte hain.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int score = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

public class q23 {
    /*
     * Pattern: Stack / Calculator with Parentheses
     * Company Names: Google, Meta
     * Difficulty: Hard
     *
     * LeetCode #224: Basic Calculator
     *
     * Problem samajh lo:
     * Expression me +, -, parentheses handle karne hain.
     *
     * Stack me previous result aur sign store karte hain
     * jab '(' milta hai.
     * ')' par current sub-expression fold kar dete hain.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        return result + sign * number;
    }
}

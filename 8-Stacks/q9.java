import java.util.ArrayDeque;
import java.util.Deque;

public class q9 {
    /*
     * Pattern: Stack / Calculator
     * Company Names: Amazon, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #227: Basic Calculator II
     *
     * Problem samajh lo:
     * Expression me +, -, *, / handle karna hai without parentheses.
     *
     * Stack idea:
     * + aur - par signed number push karo.
     * * aur / par previous top ke saath immediately combine karo.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else {
                    stack.push(stack.pop() / number);
                }

                sign = ch;
                number = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}

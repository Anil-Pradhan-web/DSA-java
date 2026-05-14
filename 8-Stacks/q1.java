import java.util.ArrayDeque;
import java.util.Deque;

public class q1 {
    /*
     * Pattern: Basic Stack / Parentheses
     * Company Names: TCS, Wipro, Har Jagah
     * Difficulty: Easy
     *
     * LeetCode #20: Valid Parentheses
     *
     * Problem samajh lo:
     * Brackets valid tab honge jab har opening bracket ka correct closing ho
     * aur order bhi sahi ho.
     *
     * Stack idea:
     * Opening bracket push karo.
     * Closing bracket aaye to top se match karo.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(')
                    || (ch == '}' && top != '{')
                    || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

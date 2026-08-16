import java.util.Stack;

public class ValidParentheses {
    /*
     * LeetCode #20: Valid Parentheses
     * Pattern: Stack
     * Time: O(n), Space: O(n)
     */
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println("Is valid: " + isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
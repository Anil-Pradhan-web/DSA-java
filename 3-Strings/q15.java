import java.util.Stack;

public class q15 {
    /*
     * Pattern: Strings
     * Company Names: Paytm, Swiggy
     *
     * LeetCode #20: Valid Parentheses
     *
     * Problem samajh lo:
     * Humein check karna hai ki brackets string valid hai ya nahi.
     * Valid tab hogi jab:
     * 1. har opening bracket ka correct closing ho
     * 2. correct order me ho
     *
     * Example:
     * s = "()[]{}"
     * Answer = true
     *
     * Stack intuition:
     * Opening bracket aaye to stack me push karo.
     * Closing bracket aaye to top par matching opening hona chahiye.
     * Agar mismatch ya empty stack mila to invalid.
     *
     * End me stack empty hona chahiye.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(')
                    || (ch == ']' && top != '[')
                    || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

public class q8 {
    /*
     * Pattern: Stack / Expression Evaluation
     * Company Names: Amazon, Adobe
     * Difficulty: Medium
     *
     * LeetCode #150: Evaluate Reverse Polish Notation
     *
     * Problem samajh lo:
     * Postfix expression evaluate karni hai.
     *
     * Operand aaye to push karo.
     * Operator aaye to last 2 operands pop karke result push karo.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-": {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first - second);
                    break;
                }
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first / second);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}

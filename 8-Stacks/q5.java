import java.util.ArrayDeque;
import java.util.Deque;

public class q5 {
    /*
     * Pattern: Stack Simulation
     * Company Names: Capgemini, HCL
     * Difficulty: Easy
     *
     * LeetCode #682: Baseball Game
     *
     * Problem samajh lo:
     * Operations ke basis par score maintain karna hai.
     * Current score previous records par depend karta hai.
     *
     * Stack perfect fit hai because latest valid scores ka history chahiye.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String[] operations = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(operations));
    }

    public static int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op : operations) {
            if (op.equals("+")) {
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }
}

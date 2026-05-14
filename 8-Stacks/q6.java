import java.util.ArrayDeque;
import java.util.Deque;

public class q6 {
    /*
     * Pattern: Stack / String Simulation
     * Company Names: Wipro, Infosys
     * Difficulty: Easy
     *
     * LeetCode #844: Backspace String Compare
     *
     * Problem samajh lo:
     * '#' backspace ki tarah behave karta hai.
     * Dono processed strings equal hain ya nahi, ye check karna hai.
     *
     * Stack me actual remaining characters build kar sakte hain.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     */
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private static String build(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.removeLast());
        }
        return answer.toString();
    }
}

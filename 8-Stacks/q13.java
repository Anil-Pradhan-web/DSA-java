import java.util.ArrayDeque;
import java.util.Deque;

public class q13 {
    /*
     * Pattern: Monotonic Stack / Greedy
     * Company Names: Flipkart, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #402: Remove K Digits
     *
     * Problem samajh lo:
     * Number string me se k digits remove karke smallest possible number banana hai.
     *
     * Greedy + stack:
     * Jahan current digit chhota ho aur previous digit bada ho,
     * previous bada digit remove karna beneficial hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.removeLast());
        }

        while (builder.length() > 1 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}

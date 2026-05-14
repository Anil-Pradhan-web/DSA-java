import java.util.ArrayDeque;
import java.util.Deque;

public class q10 {
    /*
     * Pattern: Stack / String Decoding
     * Company Names: Amazon, Google, Adobe
     * Difficulty: Medium
     *
     * LeetCode #394: Decode String
     *
     * Problem samajh lo:
     * Encoded string ko decode karna hai.
     * Format hota hai like 3[a2[c]].
     *
     * Do stacks:
     * ek repeat counts ke liye
     * ek previous strings ke liye
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> strings = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int number = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '[') {
                counts.push(number);
                strings.push(current);
                current = new StringBuilder();
                number = 0;
            } else if (ch == ']') {
                int repeat = counts.pop();
                StringBuilder previous = strings.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }
}

import java.util.Arrays;

public class q3 {
    /*
     * Pattern: Pure Recursion
     * Company Names: Wipro, Capgemini
     * Difficulty: Easy
     *
     * LeetCode #344: Reverse String
     *
     * Problem samajh lo:
     * Character array ko recursion se reverse karna hai.
     *
     * Recursive idea:
     * Left aur right pointers lo.
     * Current pair swap karo,
     * phir inner smaller problem par recurse karo.
     *
     * Base case:
     * jab left >= right ho jaye.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) recursion stack
     */
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    private static void reverse(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        reverse(s, left + 1, right - 1);
    }
}

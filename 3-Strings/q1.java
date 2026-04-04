import java.util.Arrays;

public class q1 {
    /*
     * Pattern: Strings
     * Company Names: TCS, Wipro, Capgemini
     *
     * LeetCode #344: Reverse String
     *
     * Problem samajh lo:
     * Humein character array ko in-place reverse karna hai.
     * Naya array banana prefer nahi kiya jaata.
     *
     * Example:
     * s = ['h', 'e', 'l', 'l', 'o']
     * Answer = ['o', 'l', 'l', 'e', 'h']
     *
     * Best idea:
     * Two pointers use karo.
     * Ek start par aur ek end par rakho.
     * Dono characters swap karte jao aur pointers andar ki taraf move kar do.
     *
     * Isme har character maximum ek baar swap hota hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

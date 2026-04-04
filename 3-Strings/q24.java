public class q24 {
    /*
     * Pattern: Strings
     * Company Names: Amazon, Google
     * Difficulty: Medium
     *
     * LeetCode #647: Palindromic Substrings
     *
     * Problem samajh lo:
     * Humein count nikalna hai ki string me total kitni palindromic substrings hain.
     *
     * Example:
     * s = "aaa"
     * Answer = 6
     * Palindromic substrings:
     * "a", "a", "a", "aa", "aa", "aaa"
     *
     * Center expansion idea:
     * Har index ko palindrome center maan lo.
     * Odd aur even dono centers se expand karo.
     * Har successful expansion ek palindrome count karega.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }

        return count;
    }

    private static int expand(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}

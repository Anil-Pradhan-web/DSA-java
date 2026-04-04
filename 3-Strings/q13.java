public class q13 {
    /*
     * Pattern: Strings
     * Company Names: Flipkart, Paytm
     *
     * LeetCode #5: Longest Palindromic Substring
     *
     * Problem samajh lo:
     * Humein string ke andar longest aisi substring chahiye jo palindrome ho.
     *
     * Example:
     * s = "babad"
     * Answer = "bab" ya "aba"
     *
     * Best common idea:
     * Har index ko palindrome ka center maan lo.
     * Do cases check karte hain:
     * 1. odd length palindrome
     * 2. even length palindrome
     *
     * Center se bahar ki taraf expand karte jao
     * jab tak characters equal hain.
     *
     * Har center se best palindrome nikal ke overall answer update karte hain.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLength = expandFromCenter(s, i, i);
            int evenLength = expandFromCenter(s, i, i + 1);
            int bestLength = Math.max(oddLength, evenLength);

            if (bestLength > end - start + 1) {
                start = i - (bestLength - 1) / 2;
                end = i + bestLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}

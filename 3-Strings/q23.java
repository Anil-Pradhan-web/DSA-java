public class q23 {
    /*
     * Pattern: Strings
     * Company Names: Meta, Amazon
     * Difficulty: Easy
     *
     * LeetCode #680: Valid Palindrome II
     *
     * Problem samajh lo:
     * Humein check karna hai ki string palindrome ban sakti hai ya nahi
     * after deleting at most one character.
     *
     * Example:
     * s = "abca"
     * Answer = true
     * Kyunki 'b' ya 'c' remove karke palindrome ban sakti hai.
     *
     * Two pointers idea:
     * Dono ends se compare karo.
     * Pehla mismatch milte hi do possibilities try karo:
     * 1. left character skip karo
     * 2. right character skip karo
     *
     * Agar inme se koi bhi remaining part palindrome hai,
     * answer true hoga.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

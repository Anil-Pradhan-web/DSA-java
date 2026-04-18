public class q4 {
    /*
     * Pattern: Pure Recursion
     * Company Names: TCS, Cognizant
     * Difficulty: Easy
     *
     * LeetCode #125: Valid Palindrome
     *
     * Problem samajh lo:
     * String palindrome hai ya nahi check karna hai,
     * sirf alphanumeric characters consider karne hain
     * aur case ignore karna hai.
     *
     * Recursive idea:
     * Left aur right pointers lo.
     * Invalid chars skip karo.
     * Valid chars compare karo.
     * Match ho to inner substring par recurse karo.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    private static boolean check(String s, int left, int right) {
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }

        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }

        if (left >= right) {
            return true;
        }

        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }

        return check(s, left + 1, right - 1);
    }
}

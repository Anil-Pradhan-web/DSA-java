public class q2 {
    /*
     * Pattern: Strings
     * Company Names: TCS, Infosys, Cognizant
     *
     * LeetCode #125: Valid Palindrome
     *
     * Problem samajh lo:
     * Humein check karna hai ki string palindrome hai ya nahi,
     * lekin sirf alphanumeric characters consider karne hain
     * aur uppercase/lowercase difference ignore karna hai.
     *
     * Example:
     * s = "A man, a plan, a canal: Panama"
     * Answer = true
     *
     * Two pointers intuition:
     * Ek pointer left se aur ek right se chalao.
     * Jo non-alphanumeric characters hain unhe skip kar do.
     * Valid characters ko lowercase me compare karo.
     *
     * Agar kahin mismatch mila to palindrome nahi hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

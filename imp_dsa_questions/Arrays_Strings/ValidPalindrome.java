public class ValidPalindrome {
    /*
     * LeetCode #125: Valid Palindrome
     * Pattern: Two Pointers
     * Time: O(n), Space: O(1)
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome: " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
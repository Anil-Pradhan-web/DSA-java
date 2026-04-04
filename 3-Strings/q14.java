public class q14 {
    /*
     * Pattern: Strings
     * Company Names: Adobe, Paytm
     *
     * LeetCode #8: String to Integer (atoi)
     *
     * Problem samajh lo:
     * String se integer parse karna hai, but rules ke saath:
     * leading spaces ignore karo,
     * optional sign handle karo,
     * digits padho,
     * aur overflow aaye to clamp kar do.
     *
     * Example:
     * s = "   -42"
     * Answer = -42
     *
     * Important cases:
     * - leading spaces
     * - plus/minus sign
     * - invalid character aate hi stop
     * - integer overflow
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "   -42";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            if (result > Integer.MAX_VALUE / 10
                || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}

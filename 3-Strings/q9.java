public class q9 {
    /*
     * Pattern: Strings
     * Company Names: Accenture, Cognizant
     *
     * LeetCode #1047: Remove All Adjacent Duplicates In String
     *
     * Problem samajh lo:
     * Humein string me adjacent same characters ke pairs remove karte rehna hai
     * jab tak aur removals possible na hon.
     *
     * Example:
     * s = "abbaca"
     * Answer = "ca"
     *
     * Stack intuition:
     * Agar current character previous kept character ke same hai,
     * to pair remove ho jayega.
     * Agar different hai, to current character ko rakh lo.
     *
     * `StringBuilder` ko stack ki tarah use kar sakte hain:
     * last character top ki tarah behave karega.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int size = stack.length();

            if (size > 0 && stack.charAt(size - 1) == current) {
                stack.deleteCharAt(size - 1);
            } else {
                stack.append(current);
            }
        }

        return stack.toString();
    }
}

public class q7 {
    /*
     * Pattern: Stack as StringBuilder
     * Company Names: Cognizant, TCS
     * Difficulty: Easy
     *
     * LeetCode #1047: Remove All Adjacent Duplicates In String
     *
     * Problem samajh lo:
     * Adjacent same characters ke pairs remove karte rehna hai.
     *
     * StringBuilder ko stack ki tarah use kar sakte hain.
     * Last char top ki tarah behave karega.
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

public class q3 {
    /*
     * Pattern: Strings
     * Company Names: Wipro, Accenture
     *
     * LeetCode #151: Reverse Words in a String
     *
     * Problem samajh lo:
     * Humein sentence ke words ka order reverse karna hai.
     * Extra spaces ko ignore karna hota hai aur final answer me single spaces chahiye hoti hain.
     *
     * Example:
     * s = "  the sky   is blue  "
     * Answer = "blue is sky the"
     *
     * Easy theory:
     * 1. Extra spaces trim karo
     * 2. Words ko split karo
     * 3. End se start tak join karo
     *
     * Important:
     * Consecutive spaces ko directly treat nahi karna,
     * warna empty words aa sakte hain.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "  the sky   is blue  ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder answer = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            answer.append(words[i]);

            if (i != 0) {
                answer.append(" ");
            }
        }

        return answer.toString();
    }
}

public class q24 {
    /*
     * Pattern: Custom Sorting / Character Ranking
     * Company Names: Google, Meta
     *
     * LeetCode #791: Custom Sort String
     *
     * Problem samajh lo:
     * order string diya hota hai jo custom character ordering define karta hai.
     * Humein s ko us order ke hisaab se rearrange karna hai.
     *
     * Idea:
     * order me har character ka rank store karo.
     * Fir s ke characters ko us rank ke hisaab se place karo.
     * Frequency based rebuild easy hota hai.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1) for fixed alphabet
     */
    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        System.out.println(customSortString(order, s));
    }

    public static String customSortString(String order, String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            while (freq[ch - 'a'] > 0) {
                answer.append(ch);
                freq[ch - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                answer.append((char) (i + 'a'));
                freq[i]--;
            }
        }

        return answer.toString();
    }
}

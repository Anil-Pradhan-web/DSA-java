public class q7 {
    /*
     * Pattern: Strings
     * Company Names: Infosys, Capgemini
     *
     * LeetCode #387: First Unique Character in a String
     *
     * Problem samajh lo:
     * Humein pehle aise character ka index chahiye jo sirf ek baar aata ho.
     *
     * Example:
     * s = "leetcode"
     * Answer = 0
     *
     * Two-pass frequency idea:
     * 1. Pehle har character ki frequency count karo
     * 2. Phir string ko dobara traverse karke pehla aisa index dhoondo
     *    jahan frequency 1 ho
     *
     * Is approach me order bhi preserve rehta hai
     * aur count bhi easily mil jaata hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}

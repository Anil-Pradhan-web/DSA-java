public class q20 {
    /*
     * Pattern: Strings
     * Company Names: Google, Amazon
     * Difficulty: Medium
     *
     * LeetCode #424: Longest Repeating Character Replacement
     *
     * Problem samajh lo:
     * Humein longest aisi substring ki length chahiye
     * jise at most k replacements karke same character wali substring banaya ja sake.
     *
     * Example:
     * s = "AABABBA", k = 1
     * Answer = 4
     *
     * Sliding window idea:
     * Window ke andar sabse frequent character ko track karo.
     * Agar:
     * window length - most frequent character count > k
     * to matlab window ko valid banane ke liye k se zyada replacements lagenge,
     * isliye left pointer aage badhao.
     *
     * Intuition:
     * Window me jo characters most frequent wale se different hain,
     * wahi replace karne padenge.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            freq[index]++;
            maxFreq = Math.max(maxFreq, freq[index]);

            while (right - left + 1 - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}

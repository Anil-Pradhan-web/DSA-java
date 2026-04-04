public class q11 {
    /*
     * Pattern: Strings
     * Company Names: Adobe, Flipkart
     *
     * LeetCode #3: Longest Substring Without Repeating Characters
     *
     * Problem samajh lo:
     * Humein longest aisi substring ki length chahiye jisme koi character repeat na ho.
     *
     * Example:
     * s = "abcabcbb"
     * Answer = 3
     * Kyunki "abc" longest valid substring hai.
     *
     * Best idea:
     * Sliding window use karo.
     * Left aur right pointers se ek current valid window maintain karo.
     * Agar koi character repeat ho gaya,
     * to left pointer ko aage badha ke window ko valid banao.
     *
     * Hum last seen position store karte hain
     * taaki left ko directly jump kara sakein.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) for fixed character set
     */
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];

        for (int i = 0; i < lastSeen.length; i++) {
            lastSeen[i] = -1;
        }

        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            if (lastSeen[current] >= left) {
                left = lastSeen[current] + 1;
            }

            lastSeen[current] = right;
            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}

import java.util.HashMap;
import java.util.Map;

public class q14 {
    /*
     * Pattern: Hashing / Sliding Window + HashMap
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Medium
     *
     * LeetCode #3: Longest Substring Without Repeating Characters
     *
     * Problem samajh lo:
     * Humein ek string di gayi hai. Sabse lambi substring ki length nikalni hai
     * jisme koi character repeat na ho.
     *
     * Example:
     * s = "abcabcbb"
     * Answer = 3 ("abc" sabse lambi bina repeat wali substring)
     *
     * s = "bbbbb"
     * Answer = 1 ("b" — ek hi unique character)
     *
     * Best idea (Sliding Window + HashMap):
     * Step 1: HashMap me har character ka last seen index store karo.
     * Step 2: left pointer window ka start hai.
     * Step 3: right pointer aage badhta hai. Agar character repeat hua hai,
     * to left ko uske last seen index + 1 par le jao.
     * Step 4: Har step me max length update karo.
     *
     * Kyun HashMap?
     * Character ka last position O(1) me mil jata hai.
     * Window slide karne me O(1) update hota hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest substring = " + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Character pehle aaya hai to window ko adjust karo
            if (lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch) + 1);
            }

            lastSeen.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
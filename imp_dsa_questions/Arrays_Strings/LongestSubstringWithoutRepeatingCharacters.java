import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
     * LeetCode #3: Longest Substring Without Repeating Characters
     * Pattern: Sliding Window + HashMap
     * Time: O(n), Space: O(min(n, alphabet))
     */
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest substring: " + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (lastSeen.containsKey(current) && lastSeen.get(current) >= left) {
                left = lastSeen.get(current) + 1;
            }
            lastSeen.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
import java.util.HashMap;
import java.util.Map;

public class q21 {
    /*
     * Pattern: Strings
     * Company Names: Amazon, Google, Meta
     * Difficulty: Hard
     *
     * LeetCode #76: Minimum Window Substring
     *
     * Problem samajh lo:
     * Humein string s ke andar sabse chhoti substring chahiye
     * jo string t ke saare characters ko cover kare.
     *
     * Example:
     * s = "ADOBECODEBANC", t = "ABC"
     * Answer = "BANC"
     *
     * Sliding window + frequency idea:
     * Target string t ki required frequency store karo.
     * Right pointer se window expand karo.
     * Jaise hi current window valid ho jaye,
     * left pointer se usse shrink karo taaki minimum window mile.
     *
     * Window valid kab hogi?
     * Jab required saare characters needed count tak cover ho jaayen.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(m)
     * yahan m = target me unique characters
     */
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> needed = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            needed.put(ch, needed.getOrDefault(ch, 0) + 1);
        }

        int required = needed.size();
        int formed = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            window.put(current, window.getOrDefault(current, 0) + 1);

            if (needed.containsKey(current)
                && window.get(current).intValue() == needed.get(current).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < bestLength) {
                    bestLength = right - left + 1;
                    bestStart = left;
                }

                char remove = s.charAt(left);
                window.put(remove, window.get(remove) - 1);

                if (needed.containsKey(remove)
                    && window.get(remove).intValue() < needed.get(remove).intValue()) {
                    formed--;
                }

                left++;
            }
        }

        return bestLength == Integer.MAX_VALUE
            ? ""
            : s.substring(bestStart, bestStart + bestLength);
    }
}

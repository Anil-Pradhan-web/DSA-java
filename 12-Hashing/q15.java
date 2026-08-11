import java.util.HashMap;
import java.util.Map;

public class q15 {
    /*
     * Pattern: Hashing / Sliding Window + HashMap
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Hard
     *
     * LeetCode #76: Minimum Window Substring
     *
     * Problem samajh lo:
     * Humein do strings s aur t di gayi hain.
     * s me sabse chhota substring dhoondhna hai jisme t ke saare characters
     * (with correct counts) ho.
     *
     * Example:
     * s = "ADOBECODEBANC", t = "ABC"
     * Answer = "BANC" (sabse chhota substring jisme A, B, C ho)
     *
     * Best idea (Sliding Window + Two HashMaps):
     * Step 1: t ke characters ki frequency "need" map me count karo.
     * Step 2: Sliding window me characters ka count "window" map me rakho.
     * Step 3: right pointer badhao, window me characters add karo.
     * Step 4: Jab window me t ke saare characters ho (have == needCount),
     * to left pointer se window chhota karo aur min length update karo.
     *
     * Kyun do maps?
     * Ek map batata hai ki kya chahiye, dusra batata hai ki window me kya hai.
     * have/needCount se O(1) me pata chalta hai ki window valid hai ya nahi.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window = " + minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Step 1: Need map
        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Window map
        Map<Character, Integer> window = new HashMap<>();
        int have = 0;
        int needCount = need.size();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Step 3: Right pointer badhao
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()) {
                have++;
            }

            // Step 4: Window valid hai to chhota karo
            while (have == needCount) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
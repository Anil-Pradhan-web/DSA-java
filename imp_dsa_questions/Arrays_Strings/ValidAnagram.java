import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    /*
     * LeetCode #242: Valid Anagram
     * Pattern: Frequency Count / HashMap
     * Time: O(n), Space: O(1)
     */
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Is anagram: " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!count.containsKey(c)) {
                return false;
            }
            count.put(c, count.get(c) - 1);
            if (count.get(c) == 0) {
                count.remove(c);
            }
        }
        return count.isEmpty();
    }
}
import java.util.HashMap;
import java.util.Map;

public class q3 {
    /*
     * Pattern: Hashing / Frequency Count
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Easy
     *
     * LeetCode #242: Valid Anagram
     *
     * Problem samajh lo:
     * Do strings di gayi hain. Check karna hai ki wo anagram hain ya nahi.
     * Anagram matlab dono strings me same characters same count me ho.
     *
     * Example:
     * s = "anagram", t = "nagaram"
     * Answer = true (dono me: a x3, n x1, g x1, r x1, m x1)
     *
     * s = "rat", t = "car"
     * Answer = false
     *
     * Best idea:
     * Frequency count pattern use karo.
     * Step 1: Pehli string ke saare characters ki frequency count karo.
     * Step 2: Dusri string ke har character se frequency decrement karo.
     * Step 3: Agar koi frequency negative ho jaye, to anagram nahi hai.
     *
     * Kyun HashMap?
     * Character frequency track karne ke liye map perfect hai.
     * O(1) lookup se fast check ho jata hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) — alphabet fixed size hai
     */
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Is anagram = " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Step 1: Frequency count
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2 & 3: Decrement karo aur check karo
        for (char ch : t.toCharArray()) {
            if (!freq.containsKey(ch)) {
                return false;
            }

            freq.put(ch, freq.get(ch) - 1);

            if (freq.get(ch) < 0) {
                return false;
            }
        }

        return true;
    }
}
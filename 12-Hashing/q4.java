import java.util.HashMap;
import java.util.Map;

public class q4 {
    /*
     * Pattern: Hashing / Frequency Count
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Easy
     *
     * LeetCode #383: Ransom Note
     *
     * Problem samajh lo:
     * Humein ek magazine string aur ek ransomNote string di gayi hai.
     * Check karna hai ki magazine ke characters se ransomNote bana sakte hain ya
     * nahi.
     * Har character magazine me kitni baar hai, usse zyada baar use nahi kar sakte.
     *
     * Example:
     * ransomNote = "aa", magazine = "aab"
     * Answer = true (magazine me a x2 hai, note me a x2 chahiye)
     *
     * ransomNote = "aa", magazine = "ab"
     * Answer = false (magazine me sirf ek 'a' hai)
     *
     * Best idea:
     * Frequency count pattern use karo.
     * Step 1: Magazine ke saare characters ki frequency count karo.
     * Step 2: RansomNote ke har character se frequency check karo:
     * - Agar character exist nahi karta ya frequency 0 hai, to false
     * - Warna frequency decrement karo
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println("Can construct = " + canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        // Step 1: Magazine frequency count
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Check ransomNote characters
        for (char ch : ransomNote.toCharArray()) {
            if (!freq.containsKey(ch) || freq.get(ch) == 0) {
                return false;
            }
            freq.put(ch, freq.get(ch) - 1);
        }

        return true;
    }
}
import java.util.HashSet;
import java.util.Set;

public class q5 {
    /*
     * Pattern: Hashing / HashSet
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Easy
     *
     * LeetCode #771: Jewels and Stones
     *
     * Problem samajh lo:
     * Humein jewels aur stones diye hain (dono strings).
     * Har char in stones jo jewels me hai, wo ek jewel hai.
     * Count karo ki stones me kitne jewels hain.
     *
     * Example:
     * jewels = "aA", stones = "aAAbbbb"
     * Answer = 3 (a, A, A — teen jewels hain)
     *
     * jewels = "z", stones = "ZZ"
     * Answer = 0 (koi jewel nahi)
     *
     * Best idea:
     * Step 1: Sabhi jewels ko HashSet me daalo.
     * Step 2: Stones ke har character ko set me check karo.
     * Step 3: Jo characters jewels me hain unhe count karo.
     *
     * Kyun HashSet?
     * Jewels me lookup O(1) me ho jata hai.
     * Brute force me har stone ko har jewel se compare karna padta (O(n*m)).
     * HashSet se O(n + m) ho jata hai.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(m) where m = jewels length
     */
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println("Jewels count = " + numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        // Step 1: Jewels ko set me daalo
        Set<Character> jewelSet = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            jewelSet.add(ch);
        }

        // Step 2 & 3: Stones ko check karo aur count karo
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (jewelSet.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}
import java.util.HashMap;
import java.util.Map;

public class q6 {
    /*
     * Pattern: Hashing / Frequency Count
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Easy
     *
     * LeetCode #136: Single Number
     *
     * Problem samajh lo:
     * Humein array diya hai jisme har element do baar aata hai,
     * sirf ek element ek baar aata hai.
     * Humein wo unique element dhoondhna hai.
     *
     * Example:
     * nums = [2, 2, 1]
     * Answer = 1 (sirf ek baar aaya)
     *
     * nums = [4, 1, 2, 1, 2]
     * Answer = 4
     *
     * Best idea (HashMap approach):
     * Frequency count karo.
     * Jo element ki frequency 1 hai, wo answer hai.
     *
     * Note: XOR approach O(1) space me solve karta hai, lekin
     * hashing approach O(n) space use karta hai. Ye hashing pattern practice hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println("Single number = " + singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        // Frequency count
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Frequency 1 wala element find karo
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1; // nahi mila (should not happen)
    }
}
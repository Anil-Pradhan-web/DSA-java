import java.util.HashMap;
import java.util.Map;

public class q9 {
    /*
     * Pattern: Hashing / Prefix Sum
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #560: Subarray Sum Equals K
     *
     * Problem samajh lo:
     * Humein count nikalna hai ki kitne contiguous subarrays ka sum
     * exactly k ke equal hai.
     *
     * Example:
     * nums = [1, 1, 1], k = 2
     * Answer = 2
     * Valid: [1,1] at (0,1) and (1,2)
     *
     * Best idea (Prefix Sum + HashMap):
     * Agar current prefixSum = sum, aur humein k chahiye,
     * to humein check karna hai ki kya pehle kabhi (sum - k) aaya tha.
     *
     * Kyun?
     * Agar currentPrefixSum - oldPrefixSum = k,
     * to old index ke next se current index tak ka subarray sum k hoga.
     *
     * HashMap me prefix sum ki frequency store karte hain.
     * map.put(0, 1) — empty prefix ko count karo (agar starting se hi sum k ho).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println("Count = " + subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix sum = 0

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // Kitne baar (prefixSum - k) pehle aaya, utne subarrays mile
            if (prefixCount.containsKey(prefixSum - k)) {
                count += prefixCount.get(prefixSum - k);
            }

            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
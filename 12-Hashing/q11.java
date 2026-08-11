import java.util.HashMap;
import java.util.Map;

public class q11 {
    /*
     * Pattern: Hashing / Prefix Sum
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #560: Subarray Sum Equals K
     *
     * Problem samjho:
     * Ek array diya hai aur ek target k diya hai.
     * Humein count karna hai ki kitne contiguous subarrays ka sum exactly k hai.
     *
     * Example:
     * nums = [1, 1, 1], k = 2
     * Answer = 2 ([1,1] at index 0-1, [1,1] at index 1-2)
     *
     * Approach:
     * Prefix sum + HashMap use karo.
     * Har step par prefix sum calculate karo.
     * Agar (prefixSum - k) pehle se map me hai, to utne subarrays mil gaye.
     * Map me prefix sum ki frequency store karo.
     *
     * Kyun kaam karta hai?
     * Agar prefixSum[j] - prefixSum[i] = k, to subarray (i+1 to j) ka sum = k.
     * Isliye hume sirf ye check karna hai ki (currentSum - k) pehle aaya hai ya
     * nahi.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println("Subarray sum equals k: " + subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // empty subarray

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            // Agar currentSum - k pehle dekha hai, to subarray mil gaya
            count += prefixSumCount.getOrDefault(currentSum - k, 0);

            // Current sum ko map me update karo
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    /*
     * LeetCode #560: Subarray Sum Equals K
     * Pattern: Prefix Sum + HashMap
     * Time: O(n), Space: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        System.out.println("Count: " + subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        int count = 0, currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            count += prefixSumCount.getOrDefault(currentSum - k, 0);
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
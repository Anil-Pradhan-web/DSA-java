import java.util.HashMap;
import java.util.Map;

public class q36 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Maximum Sum of Distinct Subarrays With Length K
     *
     * Problem samajh lo:
     * Humein size k ka aisa subarray chahiye jisme sab elements distinct hon
     * aur uska sum maximum ho.
     *
     * Example:
     * nums = [1, 5, 4, 2, 9, 9, 9], k = 3
     * Answer = 15
     * Distinct subarray [4, 2, 9]
     *
     * Sliding window + frequency map:
     * Window ka sum maintain karo
     * aur saath me frequency map bhi rakho.
     *
     * Jab window size k ho:
     * agar map size bhi k hai, matlab sab elements distinct hain
     * to answer update karo.
     *
     * Fir left side ka element window se remove karke aage badho.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println("Maximum distinct window sum = " + maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long windowSum = 0;
        long best = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            if (right - left + 1 > k) {
                int removed = nums[left];
                windowSum -= removed;
                freq.put(removed, freq.get(removed) - 1);
                if (freq.get(removed) == 0) {
                    freq.remove(removed);
                }
                left++;
            }

            if (right - left + 1 == k && freq.size() == k) {
                best = Math.max(best, windowSum);
            }
        }

        return best;
    }
}

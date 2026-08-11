import java.util.HashMap;
import java.util.Map;

public class q16 {
    /*
     * Pattern: Hashing / HashMap + Complement
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #454: 4Sum II
     *
     * Problem samajh lo:
     * Humein 4 arrays diye hain (nums1, nums2, nums3, nums4).
     * Aise tuples (i, j, k, l) count karne hain jisme:
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     *
     * Example:
     * nums1 = [1, 2], nums2 = [-2, -1], nums3 = [-1, 2], nums4 = [0, 2]
     * Answer = 2
     * (0,0,0,1): 1 + (-2) + (-1) + 2 = 0
     * (1,1,0,0): 2 + (-1) + (-1) + 0 = 0
     *
     * Best idea:
     * Step 1: nums1 + nums2 ke saare possible sums ki frequency count karo.
     * Step 2: nums3 + nums4 ke saare sums ke liye check karo ki
     * kya -(sum) pehle map me hai.
     *
     * Kyun 2+2 split?
     * Brute force 4 loops = O(n^4).
     * 2+2 split se O(n^2) me ho jata hai.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { -2, -1 };
        int[] nums3 = { -1, 2 };
        int[] nums4 = { 0, 2 };
        System.out.println("Count = " + fourSumCount(nums1, nums2, nums3, nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // Step 1: nums1 + nums2 sums ki frequency
        Map<Integer, Integer> sumCount = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }

        // Step 2: nums3 + nums4 se complement check karo
        int count = 0;

        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;
                count += sumCount.getOrDefault(-sum, 0);
            }
        }

        return count;
    }
}
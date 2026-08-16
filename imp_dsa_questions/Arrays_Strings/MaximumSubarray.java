public class MaximumSubarray {
    /*
     * LeetCode #53: Maximum Subarray (Kadane's Algorithm)
     * Pattern: Kadane's Algorithm
     * Time: O(n), Space: O(1)
     */
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Max subarray sum: " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
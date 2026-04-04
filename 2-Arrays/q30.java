public class q30 {
    /*
     * Pattern: Important Problems Jo List Mein Nahi The
     * Company Names: Amazon, Google
     *
     * LeetCode #918: Maximum Circular Subarray
     *
     * Problem samajh lo:
     * Humein circular array me maximum sum wala subarray dhoondhna hai.
     * Circular ka matlab end ke baad start wapas connected maana jaata hai.
     *
     * Example:
     * nums = [5, -3, 5]
     * Answer = 10
     * Kyunki circular subarray [5] + [5] mila kar 10 ban raha hai
     *
     * Is problem me 2 cases hote hain:
     *
     * Case 1:
     * Normal maximum subarray answer
     * Iske liye normal Kadane use hota hai
     *
     * Case 2:
     * Circular answer
     * Yahan idea hota hai:
     * totalSum - minimumSubarraySum
     *
     * Kyun?
     * Agar beech ka minimum sum wala part hata do,
     * to jo remaining circular part bachega wahi maximum circular sum ban sakta hai.
     *
     * Important edge case:
     * Agar saare elements negative hain,
     * to totalSum - minSubarray zero jaisa misleading ho sakta hai.
     * Us case me normal Kadane answer hi return karna chahiye.
     *
     * Final answer:
     * max(normalKadane, totalSum - minKadane)
     * but only when all elements negative na hon
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        System.out.println("Maximum circular sum = " + maxSubarraySumCircular(nums));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int currentMax = nums[0];
        int maxSum = nums[0];
        int currentMin = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);

            totalSum += nums[i];
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}

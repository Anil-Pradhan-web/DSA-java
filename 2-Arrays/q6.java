public class q6 {
    /*
     * Pattern: Sliding Window / Kadane's Algorithm
     * Company Names: Microsoft, Amazon
     *
     * LeetCode #53: Maximum Subarray
     *
     * Problem samajh lo:
     * Humein array me contiguous subarray ka maximum possible sum nikalna hai.
     * Contiguous ka matlab beech ke elements skip nahi kar sakte.
     *
     * Example:
     * nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
     * Answer = 6
     * Kyunki subarray [4, -1, 2, 1] ka sum 6 hai
     *
     * Kadane's intuition:
     * Har index par do options hote hain:
     * 1. Current element se naya subarray start karo
     * 2. Previous subarray me current element ko include karo
     *
     * Formula:
     * currentSum = max(nums[i], currentSum + nums[i])
     *
     * Agar previous running sum negative ho gaya,
     * to usse continue karne ka koi fayda nahi hai.
     * Better hai current element se fresh start kiya jaye.
     *
     * Isliye yeh ek smart sliding window jaisa kaam karta hai
     * jahan hum useless prefix ko drop kar dete hain.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum = " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int bestSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            bestSum = Math.max(bestSum, currentSum);
        }

        return bestSum;
    }
}

public class q7 {
    /*
     * Pattern: Sliding Window Style Tracking
     * Company Names: LinkedIn, Amazon
     *
     * LeetCode #152: Maximum Product Subarray
     *
     * Problem samajh lo:
     * Humein contiguous subarray ka maximum product nikalna hai.
     * Sum wale problem se yeh trickier hai kyunki negative number sign flip kar deta hai.
     *
     * Example:
     * nums = [2, 3, -2, 4]
     * Answer = 6
     * Kyunki subarray [2, 3] ka product 6 hai
     *
     * Important observation:
     * Negative number minimum product ko maximum bana sakta hai,
     * aur maximum product ko minimum bhi bana sakta hai.
     *
     * Isliye har step par humein do cheezein track karni padti hain:
     * 1. maxProductEndingHere
     * 2. minProductEndingHere
     *
     * Agar current number negative ho,
     * to max aur min ka role swap ho sakta hai.
     *
     * Formula:
     * currentMax = max(nums[i], currentMax * nums[i], currentMin * nums[i])
     * currentMin = min(nums[i], currentMax * nums[i], currentMin * nums[i])
     *
     * Is approach me hum window ke andar best aur worst dono effect carry karte hain.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product = " + maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int tempMax = currentMax;

            currentMax = Math.max(value, Math.max(currentMax * value, currentMin * value));
            currentMin = Math.min(value, Math.min(tempMax * value, currentMin * value));

            answer = Math.max(answer, currentMax);
        }

        return answer;
    }
}

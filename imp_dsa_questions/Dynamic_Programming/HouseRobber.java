public class HouseRobber {
    /*
     * LeetCode #198: House Robber
     * Pattern: DP (1D)
     * Time: O(n), Space: O(1)
     */
    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println("Max rob: " + rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int current = Math.max(prev2 + num, prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
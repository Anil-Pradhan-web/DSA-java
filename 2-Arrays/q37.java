public class q37 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Minimum Size Subarray Sum
     *
     * Problem samajh lo:
     * Humein smallest length ka contiguous subarray chahiye
     * jiska sum target ke equal ya usse greater ho.
     *
     * Example:
     * target = 7, nums = [2, 3, 1, 2, 4, 3]
     * Answer = 2
     * Kyunki [4, 3] ka sum 7 hai
     *
     * Sliding window intuition:
     * Right pointer se window expand karo jab tak sum target se chhota hai.
     * Jaise hi sum target ya usse bada ho,
     * left pointer se shrink karo taaki minimum length mile.
     *
     * Ye tab best kaam karta hai jab numbers positive hon.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("Minimum length = " + minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}

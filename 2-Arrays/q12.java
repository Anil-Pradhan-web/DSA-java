public class q12 {
    /*
     * Pattern: Prefix Sum / HashMap
     * Company Names: Amazon, Google
     *
     * LeetCode #41: First Missing Positive
     *
     * Problem samajh lo:
     * Humein array me sabse chhota missing positive integer return karna hai.
     *
     * Example:
     * nums = [3, 4, -1, 1]
     * Answer = 2
     *
     * Important observation:
     * Agar array size n hai,
     * to answer hamesha range 1 se n + 1 ke beech hoga.
     *
     * Kyun?
     * Agar 1 se n tak saare numbers present hain,
     * to missing answer n + 1 hoga.
     *
     * Best in-place idea:
     * Har positive number x ko uski correct position x - 1 par rakhne ki koshish karo.
     *
     * Example:
     * 1 ko index 0 par hona chahiye
     * 2 ko index 1 par
     * 3 ko index 2 par
     *
     * Jab tak current value valid range me hai
     * aur wo already apni correct position par nahi hai,
     * tab tak usko swap karte raho.
     *
     * Rearrangement ke baad:
     * Pehla index jahan nums[i] != i + 1 mile,
     * wahi missing positive answer hoga.
     *
     * Agar sab kuch sahi jagah par hai,
     * to answer = nums.length + 1
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("First missing positive = " + firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] > 0
                && nums[i] <= nums.length
                && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }

        return nums.length + 1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

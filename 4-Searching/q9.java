public class q9 {
    /*
     * Pattern: Binary Search
     * Company Names: Uber, Flipkart
     * Difficulty: Medium
     *
     * LeetCode #153: Find Minimum in Rotated Sorted Array
     *
     * Problem samajh lo:
     * Sorted array ko rotate kiya gaya hai.
     * Humein minimum element dhoondhna hai.
     *
     * Important observation:
     * Agar nums[mid] > nums[right], to minimum right side me hai.
     * Warna minimum left side including mid me hai.
     *
     * Ye campus aur product companies dono me common hai.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}

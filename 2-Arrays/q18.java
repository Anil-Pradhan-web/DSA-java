public class q18 {
    /*
     * Pattern: Binary Search on Array
     * Company Names: Amazon, Microsoft
     *
     * LeetCode #153: Find Min in Rotated Sorted Array
     *
     * Problem samajh lo:
     * Sorted array ko rotate kiya gaya hai.
     * Humein minimum element find karna hai.
     *
     * Example:
     * nums = [3,4,5,1,2]
     * Answer = 1
     *
     * Core observation:
     * Rotation point ke baad wala part hi minimum ke aas-paas hota hai.
     * Agar mid value right value se chhoti ya equal hai,
     * to minimum mid par ya uske left side me ho sakta hai.
     *
     * Agar mid value right value se badi hai,
     * to minimum definitely right side me hoga.
     *
     * Binary search rules:
     * 1. nums[mid] > nums[right] -> left = mid + 1
     * 2. nums[mid] <= nums[right] -> right = mid
     *
     * End me left hi minimum element ka index hota hai.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Minimum = " + findMin(nums));
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

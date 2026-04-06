import java.util.Arrays;

public class q6 {
    /*
     * Pattern: Binary Search
     * Company Names: TCS, Infosys
     * Difficulty: Medium
     *
     * LeetCode #34: Find First and Last Position of Element in Sorted Array
     *
     * Problem samajh lo:
     * Sorted array me target ka first aur last index return karna hai.
     * Agar target present nahi hai to [-1, -1].
     *
     * Ye do boundary searches ka combination hai:
     * 1. first occurrence
     * 2. last occurrence
     *
     * Campus placements me ye bahut common question hai.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{firstPosition(nums, target), lastPosition(nums, target)};
    }

    private static int firstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                answer = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static int lastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                answer = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}

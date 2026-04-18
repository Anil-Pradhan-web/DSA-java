import java.util.Arrays;

public class q14 {
    /*
     * Pattern: Permutation Logic
     * Company Names: Google, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #31: Next Permutation
     *
     * Note:
     * Ye strict backtracking problem nahi hai,
     * but permutations topic ke under commonly group ki jaati hai.
     *
     * Core idea:
     * Right se pivot dhoondo,
     * usse next greater element se swap karo,
     * aur suffix reverse kar do.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;

        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        if (pivot >= 0) {
            int successor = nums.length - 1;
            while (nums[successor] <= nums[pivot]) {
                successor--;
            }
            swap(nums, pivot, successor);
        }

        reverse(nums, pivot + 1, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

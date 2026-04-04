import java.util.Arrays;

public class q26 {
    /*
     * Pattern: Important Problems Jo List Mein Nahi The
     * Company Names: Google, Microsoft
     *
     * LeetCode #31: Next Permutation
     *
     * Problem samajh lo:
     * Humein given array ka next lexicographically greater permutation banana hai.
     * Agar next greater permutation exist nahi karta,
     * to smallest possible permutation return karni hoti hai.
     *
     * Example:
     * nums = [1, 2, 3]
     * Answer = [1, 3, 2]
     *
     * Aur agar:
     * nums = [3, 2, 1]
     * To answer = [1, 2, 3]
     *
     * Core idea:
     * Humein right se scan karna hota hai kyunki permutation change minimal rakhna hai.
     *
     * Steps:
     * 1. Right se pehla aisa index dhoondo jahan nums[i] < nums[i + 1]
     *    Isko pivot kehte hain
     *
     * 2. Phir right se pehla number dhoondo jo pivot se bada ho
     *    usse swap karo
     *
     * 3. Pivot ke baad wale part ko reverse kar do
     *    kyunki humein next smallest arrangement chahiye
     *
     * Why reverse?
     * Pivot ke baad ka part already descending hota hai,
     * reverse karne se wo ascending ban jaata hai aur minimal next permutation milta hai.
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
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

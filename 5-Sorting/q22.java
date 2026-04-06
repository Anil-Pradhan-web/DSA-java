import java.util.Arrays;

public class q22 {
    /*
     * Pattern: Custom Sorting / Partition
     * Company Names: Microsoft, Amazon
     *
     * LeetCode #905: Sort Array by Parity
     *
     * Problem samajh lo:
     * Even numbers ko pehle aur odd numbers ko baad me arrange karna hai.
     *
     * Two pointers idea:
     * Left ko even chahiye aur right ko odd.
     * Jahan mismatch mile, swap kar do.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if (nums[left] % 2 == 0) {
                left++;
            }

            if (nums[right] % 2 == 1) {
                right--;
            }
        }

        return nums;
    }
}

import java.util.Arrays;

public class q12 {
    /*
     * Pattern: Sorting / Rearrangement
     * Company Names: Google, Flipkart
     * Difficulty: Medium
     *
     * LeetCode #324: Wiggle Sort II
     *
     * Problem samajh lo:
     * Array ko aise rearrange karna hai:
     * nums[0] < nums[1] > nums[2] < nums[3] ...
     *
     * Practical sorting-based idea:
     * Array ka sorted copy banao.
     * Smaller half ko even indices me reverse order me bharo.
     * Larger half ko odd indices me reverse order me bharo.
     *
     * Reverse fill isliye helpful hai taaki equal values adjacent pattern ko break na karein.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = (nums.length - 1) / 2;
        int right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--];
            } else {
                nums[i] = sorted[right--];
            }
        }
    }
}

import java.util.Arrays;

public class q13 {
    /*
     * Pattern: Sorting / Kth Element
     * Company Names: Amazon, Uber, Google
     * Difficulty: Medium
     *
     * LeetCode #215: Kth Largest Element in an Array
     *
     * Problem samajh lo:
     * Sorted order me kth largest element return karna hai.
     *
     * Sorting-based approach:
     * Array sort karo aur end se kth position ka element return kar do.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: depends on sort internals
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

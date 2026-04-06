import java.util.Arrays;

public class q3 {
    /*
     * Pattern: Sorting / Duplicate Detection
     * Company Names: TCS, Wipro
     * Difficulty: Easy
     *
     * LeetCode #217: Contains Duplicate
     *
     * Problem samajh lo:
     * Check karna hai ki array me koi value ek se zyada baar aati hai ya nahi.
     *
     * Sorting idea:
     * Array sort kar do.
     * Agar kisi adjacent pair me same values mil gayi,
     * to duplicate present hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) extra ignoring sort internals
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }
}

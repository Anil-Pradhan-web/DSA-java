import java.util.Arrays;

public class q40 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Repeat and Missing Number
     *
     * Problem samajh lo:
     * Array me 1 se n tak numbers hone chahiye,
     * lekin ek number repeat ho gaya hai aur ek number missing hai.
     * Humein dono return karne hain.
     *
     * Example:
     * nums = [3, 1, 2, 5, 3]
     * Answer = [3, 4]
     *
     * Cyclic placement idea:
     * Har number ko uski correct position value - 1 par rakhne ki koshish karo.
     * Rearrangement ke baad jahan mismatch milega:
     * nums[i] repeated number hoga
     * i + 1 missing number hoga
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 3};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return new int[]{nums[index], index + 1};
            }
        }

        return new int[]{-1, -1};
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

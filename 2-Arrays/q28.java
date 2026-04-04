import java.util.Arrays;

public class q28 {
    /*
     * Pattern: Important Problems Jo List Mein Nahi The
     * Company Names: Facebook, Microsoft
     *
     * LeetCode #283: Move Zeroes
     *
     * Problem samajh lo:
     * Humein saare zeroes ko array ke end me move karna hai
     * bina non-zero elements ka relative order bigaade.
     *
     * Example:
     * nums = [0, 1, 0, 3, 12]
     * Answer = [1, 3, 12, 0, 0]
     *
     * Two pointers / compacting idea:
     * Ek pointer maintain karo jo next non-zero placement position bataye.
     *
     * Step 1:
     * Array traverse karo
     * Aur jo bhi non-zero element mile, usse front me place karte jao
     *
     * Step 2:
     * Baaki remaining positions me zero bhar do
     *
     * Is tarah:
     * - non-zero order preserve rehta hai
     * - extra array nahi lagta
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int insertIndex = 0;

        for (int value : nums) {
            if (value != 0) {
                nums[insertIndex] = value;
                insertIndex++;
            }
        }

        while (insertIndex < nums.length) {
            nums[insertIndex] = 0;
            insertIndex++;
        }
    }
}

import java.util.Arrays;

public class q15 {
    /*
     * Pattern: Sorting / Intervals
     * Company Names: Microsoft, Amazon
     *
     * LeetCode #75: Sort Colors (Dutch National Flag)
     *
     * Problem samajh lo:
     * Array me sirf 0, 1, 2 values hain.
     * Inhe in-place sort karna hai bina general sorting algorithm use kiye.
     *
     * Example:
     * nums = [2, 0, 2, 1, 1, 0]
     * Answer = [0, 0, 1, 1, 2, 2]
     *
     * Dutch National Flag idea:
     * 3 zones maintain karte hain:
     * 1. low ke pehle sab 0
     * 2. low se mid - 1 tak sab 1
     * 3. high ke baad sab 2
     *
     * mid pointer current element ko inspect karta hai.
     *
     * Cases:
     * Agar nums[mid] == 0:
     * low aur mid swap karo, dono aage badhao
     *
     * Agar nums[mid] == 1:
     * mid aage badhao
     *
     * Agar nums[mid] == 2:
     * mid aur high swap karo, high peeche lao
     * mid ko turant aage nahi badhate kyunki swapped value ko check karna hota hai
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

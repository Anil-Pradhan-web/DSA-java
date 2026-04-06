import java.util.Arrays;

public class q1 {
    /*
     * Pattern: Sorting / Dutch National Flag
     * Company Names: TCS, Wipro, Cognizant
     * Difficulty: Medium
     *
     * LeetCode #75: Sort Colors
     *
     * Problem samajh lo:
     * Array me sirf 0, 1, 2 values hain.
     * Humein inhe in-place sort karna hai bina general sort use kiye.
     *
     * Dutch National Flag idea:
     * low ke pehle sab 0
     * low se mid - 1 tak sab 1
     * high ke baad sab 2
     *
     * Mid current element inspect karta hai aur uske basis par swap hota hai.
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
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

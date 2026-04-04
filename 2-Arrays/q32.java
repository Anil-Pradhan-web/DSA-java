import java.util.Arrays;

public class q32 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Merge Sorted Array
     *
     * Problem samajh lo:
     * Do sorted arrays diye hote hain. Pehle array me enough extra space hoti hai
     * aur humein dono ko merge karke sorted result wahi first array me banana hota hai.
     *
     * Example:
     * nums1 = [1, 2, 3, 0, 0, 0], m = 3
     * nums2 = [2, 5, 6], n = 3
     * Answer = [1, 2, 2, 3, 5, 6]
     *
     * Best trick:
     * End se fill karo.
     * Kyunki nums1 ke last me free space hoti hai, to peeche se compare karke
     * bada element last position par rakhna easy hota hai.
     *
     * Agar front se bharne lage to existing useful values overwrite ho sakti hain.
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        int write = m + n - 1;

        while (second >= 0) {
            if (first >= 0 && nums1[first] > nums2[second]) {
                nums1[write] = nums1[first];
                first--;
            } else {
                nums1[write] = nums2[second];
                second--;
            }
            write--;
        }
    }
}

import java.util.Arrays;

public class q2 {
    /*
     * Pattern: Sorting / Two Pointers from End
     * Company Names: TCS, Infosys, All
     * Difficulty: Easy
     *
     * LeetCode #88: Merge Sorted Array
     *
     * Problem samajh lo:
     * Do sorted arrays diye hain. First array me enough extra space hai.
     * Humein final merged sorted answer first array ke andar hi banana hai.
     *
     * Best trick:
     * End se merge karo.
     * Bada element end position par place karte jao,
     * taaki first array ke useful elements overwrite na hon.
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
                nums1[write--] = nums1[first--];
            } else {
                nums1[write--] = nums2[second--];
            }
        }
    }
}

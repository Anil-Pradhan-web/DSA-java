public class q20 {
    /*
     * Pattern: Binary Search on Array
     * Company Names: Google, Amazon, Apple
     *
     * LeetCode #4: Median of Two Sorted Arrays
     *
     * Problem samajh lo:
     * Do sorted arrays diye hote hain.
     * Dono ko logically combine karke median nikalna hai,
     * lekin overall O(log(m+n)) time ke aas-paas sochna hota hai.
     *
     * Example:
     * nums1 = [1, 3]
     * nums2 = [2]
     * Answer = 2.0
     *
     * Sabse powerful idea:
     * Dono arrays ko aise partition karo ki left half me total elements
     * right half ke equal ya ek zyada hon.
     *
     * Correct partition par:
     * left side ka maximum <= right side ka minimum
     *
     * Hum chhoti array par binary search karte hain,
     * taaki partition fast adjust ho sake.
     *
     * Variables:
     * partition1 = nums1 me cut
     * partition2 = total left side complete karne ke liye nums2 me cut
     *
     * Agar:
     * maxLeft1 <= minRight2
     * aur
     * maxLeft2 <= minRight1
     * to perfect partition mil gaya
     *
     * Fir:
     * Agar total elements odd hain,
     * median = left side ka max
     *
     * Agar even hain,
     * median = (leftMax + rightMin) / 2
     *
     * Time Complexity: O(log(min(m, n)))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median = " + findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLength = nums1.length + nums2.length;
        int half = (totalLength + 1) / 2;

        int left = 0;
        int right = nums1.length;

        while (left <= right) {
            int partition1 = left + (right - left) / 2;
            int partition2 = half - partition1;

            int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = partition1 == nums1.length ? Integer.MAX_VALUE : nums1[partition1];
            int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = partition2 == nums2.length ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if (totalLength % 2 == 0) {
                    int leftMax = Math.max(maxLeft1, maxLeft2);
                    int rightMin = Math.min(minRight1, minRight2);
                    return (leftMax + rightMin) / 2.0;
                }

                return Math.max(maxLeft1, maxLeft2);
            }

            if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }

        return 0.0;
    }
}

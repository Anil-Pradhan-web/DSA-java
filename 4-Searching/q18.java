public class q18 {
    /*
     * Pattern: Binary Search Partition
     * Company Names: Google, Amazon, Apple
     * Difficulty: Hard
     *
     * LeetCode #4: Median of Two Sorted Arrays
     *
     * Problem samajh lo:
     * Do sorted arrays diye hote hain.
     * Dono ko logically merge karke median nikalna hai,
     * but optimal solution me actual merge nahi karna hota.
     *
     * Core idea:
     * Chhoti array par binary search lagao aur dono arrays ko aise partition karo
     * ki left side me total half elements ho jayein.
     *
     * Perfect partition tab milega jab:
     * left side ka maximum <= right side ka minimum
     *
     * Agar total elements odd hain,
     * to median left side ka max hoga.
     * Agar even hain,
     * to median = (leftMax + rightMin) / 2
     *
     * Time Complexity: O(log(min(m, n)))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;
        int left = 0;
        int right = nums1.length;

        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = half - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                return Math.max(left1, left2);
            }

            if (left1 > right2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }
        }

        return 0.0;
    }
}

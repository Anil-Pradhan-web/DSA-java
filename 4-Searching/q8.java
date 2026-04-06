public class q8 {
    /*
     * Pattern: Binary Search
     * Company Names: Adobe, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #162: Find Peak Element
     *
     * Problem samajh lo:
     * Peak element wo hota hai jo apne neighbors se greater ho.
     * Humein kisi bhi valid peak ka index return karna hai.
     *
     * Observation:
     * Agar mid ke right me value badi hai,
     * to peak right side me zaroor hogi.
     * Warna peak left side including mid par hogi.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

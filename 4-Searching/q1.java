public class q1 {
    /*
     * Pattern: Binary Search
     * Company Names: TCS, Wipro, All
     * Difficulty: Easy
     *
     * LeetCode #704: Binary Search
     *
     * Problem samajh lo:
     * Sorted array me target ka index dhoondhna hai.
     * Agar target present nahi hai to -1 return karna hai.
     *
     * Binary search intuition:
     * Mid element se compare karo.
     * Agar target chhota hai to left half me jao.
     * Agar target bada hai to right half me jao.
     *
     * Har step me aadha search space eliminate hota hai.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

public class q2 {
    /*
     * Pattern: Binary Search
     * Company Names: TCS, Infosys, Capgemini
     * Difficulty: Easy
     *
     * LeetCode #35: Search Insert Position
     *
     * Problem samajh lo:
     * Sorted array me target ka index return karna hai.
     * Agar target present nahi hai, to jahan insert hoga wo position return karo.
     *
     * Core idea:
     * Humein first aisa index chahiye jahan value target se greater ya equal ho.
     * Ye lower bound type binary search hai.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}

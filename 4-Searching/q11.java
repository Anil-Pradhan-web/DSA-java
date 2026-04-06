public class q11 {
    /*
     * Pattern: Binary Search
     * Company Names: Bloomberg, Adobe
     * Difficulty: Medium
     *
     * LeetCode #81: Search in Rotated Sorted Array II
     *
     * Problem samajh lo:
     * Ye rotated sorted array search ka duplicate version hai.
     * Duplicates hone ki wajah se kabhi-kabhi sorted half clearly identify nahi hota.
     *
     * Ambiguous case:
     * Agar nums[left] == nums[mid] == nums[right],
     * to dono sides uncertain ho sakti hain.
     * Tab boundaries shrink karni padti hain.
     *
     * Time Complexity: Average O(log n), worst case O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}

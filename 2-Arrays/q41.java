public class q41 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Count Inversions
     *
     * Problem samajh lo:
     * Inversion ka matlab hota hai aisa pair (i, j)
     * jahan i < j ho aur arr[i] > arr[j] ho.
     *
     * Example:
     * nums = [2, 4, 1, 3, 5]
     * Answer = 3
     * Inversions = (2,1), (4,1), (4,3)
     *
     * Brute force O(n^2) hota hai,
     * lekin merge sort ke during smart counting karke isse O(n log n) me solve kar sakte hain.
     *
     * Merge step ke during:
     * Agar left part ka element right part se bada hai,
     * to left part ke current aur uske baad ke saare elements inversion banayenge.
     *
     * Isliye count me mid - leftIndex + 1 add hota hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 5};
        System.out.println("Inversion count = " + countInversions(nums));
    }

    public static long countInversions(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private static long mergeSort(int[] nums, int[] temp, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(nums, temp, left, mid);
            count += mergeSort(nums, temp, mid + 1, right);
            count += merge(nums, temp, left, mid, right);
        }

        return count;
    }

    private static long merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long inversions = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                inversions += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int index = left; index <= right; index++) {
            nums[index] = temp[index];
        }

        return inversions;
    }
}

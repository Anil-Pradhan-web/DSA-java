public class q17 {
    /*
     * Pattern: Binary Search on Array
     * Company Names: Amazon, Microsoft, Google
     *
     * LeetCode #33: Search in Rotated Sorted Array
     *
     * Problem samajh lo:
     * Ek sorted array ko kisi pivot par rotate kar diya gaya hai.
     * Humein target ka index dhoondhna hai.
     *
     * Example:
     * nums = [4,5,6,7,0,1,2], target = 0
     * Answer = 4
     *
     * Important observation:
     * Array poora unsorted nahi hai.
     * Har step par kam se kam ek half sorted zaroor hota hai.
     *
     * Binary search idea:
     * mid nikalo.
     *
     * Agar nums[mid] target hai, answer mil gaya.
     *
     * Ab check karo kaunsa half sorted hai:
     * 1. Agar nums[left] <= nums[mid], to left half sorted hai
     * 2. Warna right half sorted hai
     *
     * Phir decide karo target sorted half ke andar aata hai ya nahi.
     * Agar aata hai to us half me search karo,
     * warna doosre half me jao.
     *
     * Yeh trick isi observation par based hai ki rotation ke baad bhi
     * ek side properly ordered hoti hi hoti hai.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index = " + search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
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

        return -1;
    }
}

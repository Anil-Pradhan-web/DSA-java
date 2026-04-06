import java.util.PriorityQueue;

public class q16 {
    /*
     * Pattern: Selection / Heap
     * Company Names: Amazon, Uber, Google
     * Difficulty: Medium
     *
     * LeetCode #215: Kth Largest Element in an Array
     *
     * Problem samajh lo:
     * Humein array ka kth largest element return karna hai.
     * Yahan kth distinct nahi, balki sorted order me kth position wala element chahiye.
     *
     * Example:
     * nums = [3, 2, 1, 5, 6, 4], k = 2
     * Answer = 5
     *
     * Clean approach:
     * Size k ka min-heap maintain karo.
     * Har element heap me daalo.
     * Agar heap size k se bada ho jaye, smallest hata do.
     *
     * End me heap me exactly k largest elements bachenge
     * aur unme sabse chhota hi kth largest hoga.
     *
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int value : nums) {
            minHeap.offer(value);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}

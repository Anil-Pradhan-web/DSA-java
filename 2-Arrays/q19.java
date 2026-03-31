import java.util.PriorityQueue;

public class q19 {
    /*
     * Pattern: Binary Search on Array
     * Company Names: Uber, Amazon, Google
     *
     * LeetCode #215: Kth Largest Element in an Array
     *
     * Problem samajh lo:
     * Humein array ka kth largest element return karna hai.
     * Dhyan rahe, distinct kth largest nahi,
     * sorted order me kth position wala element chahiye.
     *
     * Example:
     * nums = [3,2,1,5,6,4], k = 2
     * Answer = 5
     *
     * Is problem ko quickselect se O(n) average me solve kiya ja sakta hai,
     * lekin yahan min-heap approach bahut clean aur interview friendly hai.
     *
     * Idea:
     * K size ka min-heap maintain karo.
     * Har element heap me daalo.
     * Agar heap size k se bada ho jaye,
     * to smallest element nikal do.
     *
     * End me heap me exactly k largest elements bachenge
     * aur unme sabse chhota element hi kth largest hoga.
     *
     * Note:
     * Yeh strictly binary search solution nahi hai,
     * lekin is problem ko commonly arrays/sorting/selecting category me padha jata hai.
     *
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth largest = " + findKthLargest(nums, k));
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

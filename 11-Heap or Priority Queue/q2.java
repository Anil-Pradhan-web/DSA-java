import java.util.PriorityQueue;

public class q2 {
    /*
     * Pattern: Heap / Min Heap of size k
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Medium
     *
     * LeetCode #215: Kth Largest Element in an Array
     *
     * Problem samajh lo:
     * Humein unsorted array me kth largest element dhoondhna hai.
     * Sorting se O(n log n) me mil jata hai, lekin humein O(n log k) me chahiye.
     *
     * Example:
     * nums = [3, 2, 1, 5, 6, 4], k = 2
     * Sorted: [1, 2, 3, 4, 5, 6]
     * 2nd largest = 5
     *
     * Best idea:
     * Min heap of size k maintain karo.
     * Heap me hamesha top k largest elements honge.
     * Heap ka top (minimum of those k) hi kth largest hoga.
     *
     * Kyun min heap?
     * Agar max heap use karte to top par sabse bada hota, lekin humein kth largest
     * chahiye.
     * Min heap of size k me top par kth largest hota hai.
     *
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println("Kth largest = " + findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
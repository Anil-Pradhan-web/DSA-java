import java.util.PriorityQueue;

public class KthLargestElementInArray {
    /*
     * LeetCode #215: Kth Largest Element in an Array
     * Pattern: Heap / Priority Queue
     * Time: O(n log k), Space: O(k)
     */
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println("Kth largest: " + findKthLargest(nums, k));
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
import java.util.PriorityQueue;

public class q21 {
    /*
     * Pattern: Heap / Min Heap of size k
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Easy
     *
     * LeetCode #703: Kth Largest Element in a Stream
     *
     * Problem samajh lo:
     * Humein ek stream me numbers aate rehte hain.
     * Har add() ke baad current stream ka kth largest element nikalna hai.
     *
     * Example:
     * add numbers: 4 -> 5 -> 8 -> 2, k = 3
     * After add(3): sorted = [3, 4, 5, 8], 3rd largest = 4
     * After add(5): sorted = [3, 4, 5, 5, 8], 3rd largest = 5
     * After add(10): sorted = [3, 4, 5, 5, 8, 10], 3rd largest = 5
     *
     * Best idea:
     * Min heap of size k maintain karo.
     * Heap me hamesha top k largest elements honge.
     * Heap ka top (sabse chhota) hi kth largest hota hai.
     *
     * Kyun simple hai?
     * Koi sorting ya complex logic nahi — bas heap ka size k rakho
     * aur top return karo.
     *
     * Time Complexity: O(log k) per add
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println("Add 3 -> " + kthLargest.add(3)); // 4
        System.out.println("Add 5 -> " + kthLargest.add(5)); // 5
        System.out.println("Add 10 -> " + kthLargest.add(10)); // 5
        System.out.println("Add 9 -> " + kthLargest.add(9)); // 8
        System.out.println("Add 4 -> " + kthLargest.add(4)); // 8
    }

    static class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>();

            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.add(val);

            // Size k se zyada ho to chhota element remove karo
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }
}
import java.util.PriorityQueue;

public class q12 {
    /*
     * Pattern: Heap / Sliding Window + Max Heap
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Hard
     *
     * LeetCode #239: Sliding Window Maximum
     *
     * Problem samajh lo:
     * Humein ek array aur window size k diya hai.
     * Har window me maximum element nikalna hai.
     *
     * Example:
     * nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
     * Window 1: [1, 3, -1] -> max = 3
     * Window 2: [3, -1, -3] -> max = 3
     * Window 3: [-1, -3, 5] -> max = 5
     * Answer = [3, 3, 5, 5, 6, 7]
     *
     * Best idea:
     * Max heap use karo jisme (value, index) store karo.
     * Har step me:
     * 1. Current element heap me daalo
     * 2. Out of window elements remove karo (index check)
     * 3. Heap ka top hi current window ka maximum hai
     *
     * Kyun index store karte hain?
     * Kyunki heap me stale elements ho sakte hain jo ab window me nahi hain.
     * Index se pata chalta hai ki element window me hai ya nahi.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.print("Sliding window maximums = ");
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Max heap: [value, index]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[] { nums[i], i });

            // Out of window elements remove karo
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            // Window complete hone par maximum record karo
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }

        return result;
    }
}
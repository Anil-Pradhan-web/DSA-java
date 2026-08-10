import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class q23 {
    /*
     * Pattern: Heap / HashMap + Min Heap
     * Company Names: Amazon, Google, Meta
     * Difficulty: Easy
     *
     * LeetCode #1636: Sort Array by Increasing Frequency
     *
     * Problem samajh lo:
     * Humein array me elements ko sort karna hai:
     * - Sabse kam baar aane wala element pehle aayega
     * - Agar do elements ki frequency same hai,
     * to bada element pehle aayega
     *
     * Example:
     * nums = [1, 1, 2, 2, 2, 3]
     * Frequency: 3 -> 1, 1 -> 2, 2 -> 3
     * Answer = [3, 1, 1, 2, 2, 2]
     *
     * Best idea:
     * Step 1: HashMap se frequency count karo.
     * Step 2: Min heap (by frequency) use karo.
     * - Frequency kam wala pehle
     * - Frequency same ho to bada element pehle
     * Step 3: Heap se ek-ek element nikalo aur uski frequency ke barabar
     * baar result me add karo.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3 };
        int[] result = frequencySort(nums);

        System.out.print("Sorted by frequency = ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] frequencySort(int[] nums) {
        // Step 1: Frequency count
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    int freqCompare = Integer.compare(freq.get(a), freq.get(b));
                    if (freqCompare != 0) {
                        return freqCompare;
                    }
                    return Integer.compare(b, a); // frequency same -> bada pehle
                });
        minHeap.addAll(freq.keySet());

        // Step 3: Result build karo
        int[] result = new int[nums.length];
        int index = 0;

        while (!minHeap.isEmpty()) {
            int num = minHeap.poll();
            for (int i = 0; i < freq.get(num); i++) {
                result[index++] = num;
            }
        }

        return result;
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class q12 {
    /*
     * Pattern: Hashing / Frequency Count + Heap
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Medium
     *
     * LeetCode #347: Top K Frequent Elements
     *
     * Problem samajh lo:
     * Humein array me sabse zyada baar aane wale k elements dhoondhne hain.
     * Pehle frequency count karo, phir top k frequency wale elements return karo.
     *
     * Example:
     * nums = [1, 1, 1, 2, 2, 3], k = 2
     * Frequency: 1 -> 3, 2 -> 2, 3 -> 1
     * Answer = [1, 2]
     *
     * Best idea:
     * Step 1: HashMap se frequency count karo.
     * Step 2: Max heap me (frequency, element) daalo.
     * Step 3: k baar heap se poll karo.
     *
     * Kyun HashMap + Heap?
     * HashMap frequency O(1) me count karta hai.
     * Heap se top k elements O(log n) me milte hain.
     * Total: O(n log n) — sorting ke bina top k efficiently milta hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println("Top K frequent = " + topKFrequent(nums, k));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Frequency count
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Max heap by frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(freq.get(b), freq.get(a)));
        maxHeap.addAll(freq.keySet());

        // Step 3: Top k nikalo
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }

        return result;
    }
}
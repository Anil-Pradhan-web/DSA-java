import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class q4 {
    /*
     * Pattern: Heap / HashMap + Min Heap
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
     * Top 2 = [1, 2]
     *
     * Best idea:
     * Step 1: HashMap se har element ki frequency count karo.
     * Step 2: Min heap of size k use karo jisme elements frequency ke basis par
     * compare honge.
     * Step 3: Har element ko heap me daalo, agar size k se bada ho to top (sabse
     * kam frequency) remove karo.
     *
     * Kyun min heap?
     * Hum chahte hain ki heap me top k highest frequency elements rahein.
     * Min heap ka top sabse kam frequency wala hota hai, isliye wo remove hota hai.
     *
     * Time Complexity: O(n log k)
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

        // Step 2: Min heap by frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(freq.get(a), freq.get(b)));

        // Step 3: Top k maintain karo
        for (int key : freq.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }
}
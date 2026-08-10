import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class q7 {
    /*
     * Pattern: Heap / HashMap + Min Heap
     * Company Names: Amazon, Google, Meta, Uber
     * Difficulty: Medium
     *
     * LeetCode #692: Top K Frequent Words
     *
     * Problem samajh lo:
     * Humein ek array of words diya hai. Humein sabse zyada baar aane wale k words
     * return karne hain. Agar do words ki frequency same hai, to lexicographically
     * chhota word pehle aayega.
     *
     * Example:
     * words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * Frequency: i -> 2, love -> 2, coding -> 1, leetcode -> 1
     * Answer = ["i", "love"] (i aur love dono ki frequency 2 hai, i chhota hai)
     *
     * Best idea:
     * Step 1: HashMap se frequency count karo.
     * Step 2: Min heap use karo jisme custom comparator ho:
     * - Pehle frequency compare karo
     * - Frequency same ho to lexicographically bada word heap ke top par (kyunki
     * hum chhota chahiye)
     * Step 3: Top k maintain karo, phir reverse order me result banao.
     *
     * Time Complexity: O(n log k)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        System.out.println("Top K frequent words = " + topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // Step 1: Frequency count
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // Step 2: Min heap by frequency, then lexicographically
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    int freqCompare = Integer.compare(freq.get(a), freq.get(b));
                    if (freqCompare != 0) {
                        return freqCompare;
                    }
                    return b.compareTo(a); // lexicographically bada pehle (heap ke top par)
                });

        // Step 3: Top k maintain karo
        for (String word : freq.keySet()) {
            minHeap.add(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Result ko reverse order me banao
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll());
        }

        return result;
    }
}
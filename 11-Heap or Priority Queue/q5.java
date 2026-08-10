import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class q5 {
    /*
     * Pattern: Heap / HashMap + Max Heap
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #451: Sort Characters By Frequency
     *
     * Problem samajh lo:
     * Humein ek string di gayi hai. Isse aise sort karna hai ki
     * sabse zyada baar aane wala character pehle aaye.
     *
     * Example:
     * s = "tree"
     * Frequency: t -> 1, r -> 1, e -> 2
     * Answer = "eert" ya "eetr" (e do baar aata hai isliye pehle)
     *
     * Best idea:
     * Step 1: HashMap se har character ki frequency count karo.
     * Step 2: Max heap use karo jisme characters frequency ke basis par compare
     * honge.
     * Step 3: Heap se ek-ek karke character nikaalo aur uski frequency ke barabar
     * baar output me add karo.
     *
     * Kyun max heap?
     * Hum chahte hain ki sabse zyada frequency wala character pehle aaye.
     * Max heap ka top sabse zyada frequency wala hota hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "tree";
        System.out.println("Sorted by frequency = " + frequencySort(s));
    }

    public static String frequencySort(String s) {
        // Step 1: Frequency count
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max heap by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(freq.get(b), freq.get(a)));
        maxHeap.addAll(freq.keySet());

        // Step 3: Build result
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int count = freq.get(ch);
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
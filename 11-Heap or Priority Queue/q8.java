import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class q8 {
    /*
     * Pattern: Heap / HashMap + Max Heap
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #767: Reorganize String
     *
     * Problem samajh lo:
     * Humein ek string di gayi hai. Humein isse aise rearrange karna hai ki
     * koi bhi do same character adjacent na ho.
     * Agar possible hai to rearranged string return karo, warna "" return karo.
     *
     * Example:
     * s = "aab"
     * Answer = "aba" (a aur a adjacent nahi hain)
     *
     * s = "aaab"
     * Answer = "" (possible nahi hai)
     *
     * Best idea:
     * Step 1: Frequency count karo.
     * Step 2: Max heap me (frequency, character) daalo.
     * Step 3: Har step me top 2 characters lo (current aur previous ke avoid karne
     * ke liye).
     * - Sabse zyada frequency wala add karo
     * - Usse frequency kam karke wapas heap me daalo agar > 0
     *
     * Possible check:
     * Agar kisi character ki frequency > (n + 1) / 2 hai, to possible nahi hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Reorganized string = " + reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        // Step 1: Frequency count
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max heap by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(freq.get(b), freq.get(a)));
        maxHeap.addAll(freq.keySet());

        StringBuilder result = new StringBuilder();

        // Step 3: Top 2 characters se build karo
        while (maxHeap.size() > 1) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            result.append(first);
            result.append(second);

            freq.put(first, freq.get(first) - 1);
            freq.put(second, freq.get(second) - 1);

            if (freq.get(first) > 0) {
                maxHeap.add(first);
            }
            if (freq.get(second) > 0) {
                maxHeap.add(second);
            }
        }

        // Last character handle karo
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (freq.get(last) > 1) {
                return ""; // impossible
            }
            result.append(last);
        }

        return result.toString();
    }
}
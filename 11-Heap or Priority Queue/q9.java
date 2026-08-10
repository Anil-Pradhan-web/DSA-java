import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class q9 {
    /*
     * Pattern: Heap / Greedy
     * Company Names: Amazon, Meta, Microsoft, Google
     * Difficulty: Medium
     *
     * LeetCode #621: Task Scheduler
     *
     * Problem samajh lo:
     * Humein tasks ka array diya hai jisme har character ek task represent karta
     * hai.
     * Har task ko complete karne me 1 unit time lagta hai.
     * Do same tasks ke beech me minimum n units ka cooldown hona chahiye.
     * Humein total minimum time nikalna hai saare tasks complete karne ka.
     *
     * Example:
     * tasks = ['A','A','A','B','B','B'], n = 2
     * Answer = 8
     * A -> B -> idle -> A -> B -> idle -> A -> B
     *
     * Best idea:
     * Step 1: Frequency count karo.
     * Step 2: Max heap me frequencies daalo.
     * Step 3: Har "cycle" me n+1 tasks process karo:
     * - Max heap se ek-ek karke n+1 tasks nikalo
     * - Task process hua -> time++
     * - Frequency kam karke 0 se zyada hai to next round ke liye store karo
     * - Agar heap khali ho jaye, to idle time add karo
     *
     * Time Complexity: O(n * tasks)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println("Minimum time = " + leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        // Step 1: Frequency count
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        // Step 2: Max heap by frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freq.values());

        int time = 0;

        // Step 3: Process n+1 tasks per cycle
        while (!maxHeap.isEmpty()) {
            int cycle = n + 1;
            int processed = 0;
            Map<Integer, Integer> temp = new HashMap<>();

            for (int i = 0; i < cycle; i++) {
                if (!maxHeap.isEmpty()) {
                    int count = maxHeap.poll() - 1;
                    if (count > 0) {
                        temp.put(count, temp.getOrDefault(count, 0) + 1);
                    }
                    processed++;
                }
            }

            // Remaining tasks wapas heap me daalo
            for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    maxHeap.add(entry.getKey());
                }
            }

            // Time update: cycle bharaye ya sirf processed tasks
            time += maxHeap.isEmpty() ? processed : cycle;
        }

        return time;
    }
}
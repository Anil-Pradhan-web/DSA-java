import java.util.PriorityQueue;

public class q12 {
    /*
     * Pattern: Queue / Scheduling
     * Company Names: Amazon, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #621: Task Scheduler
     *
     * Problem samajh lo:
     * Same task ke beech at least n intervals ka gap chahiye.
     * Minimum total intervals return karne hain.
     *
     * Greedy formula/heap dono possible hain.
     * Yahan frequency formula use kiya hai.
     *
     * Time Complexity: O(tasks length)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxCount = 0;

        for (char task : tasks) {
            int count = ++freq[task - 'A'];

            if (count > maxFreq) {
                maxFreq = count;
                maxCount = 1;
            } else if (count == maxFreq) {
                maxCount++;
            }
        }

        int slots = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(slots, tasks.length);
    }
}

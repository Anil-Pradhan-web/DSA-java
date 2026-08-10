import java.util.Arrays;
import java.util.PriorityQueue;

public class q15 {
    /*
     * Pattern: Heap / Greedy + Sorting
     * Company Names: Amazon, Google, Meta
     * Difficulty: Medium
     *
     * LeetCode #1834: Single-Threaded CPU
     *
     * Problem samajh lo:
     * Humein tasks diye hain jisme har task ka (enqueueTime, processingTime) hai.
     * CPU single-threaded hai — ek time par ek hi task process hota hai.
     * CPU hamesha sabse chhote processingTime wala available task choose karta hai.
     * Humein tasks ka order return karna hai jis order me process honge.
     *
     * Example:
     * tasks = [[1, 2], [2, 4], [3, 2], [4, 1]]
     * Answer = [0, 2, 3, 1]
     *
     * Best idea:
     * Step 1: Tasks ko enqueueTime ke basis par sort karo.
     * Step 2: Min heap use karo jisme (processingTime, index) store karo.
     * Step 3: Current time par available tasks heap me daalo.
     * Step 4: Heap se sabse chhota processingTime wala nikalo aur process karo.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[][] tasks = { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } };
        int[] result = getOrder(tasks);

        System.out.print("Task order = ");
        for (int index : result) {
            System.out.print(index + " ");
        }
        System.out.println();
    }

    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // Step 1: Tasks ko enqueueTime ke basis par sort karo
        int[][] indexedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            indexedTasks[i] = new int[] { tasks[i][0], tasks[i][1], i };
        }
        Arrays.sort(indexedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Min heap by processingTime, then index
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[1], b[1]);
                });

        int[] result = new int[n];
        int resultIndex = 0;
        int taskIndex = 0;
        long currentTime = 0;

        // Step 3 & 4: Process tasks
        while (resultIndex < n) {
            // Available tasks heap me daalo
            while (taskIndex < n && indexedTasks[taskIndex][0] <= currentTime) {
                minHeap.add(new int[] { indexedTasks[taskIndex][1], indexedTasks[taskIndex][2] });
                taskIndex++;
            }

            if (minHeap.isEmpty()) {
                // Koi task available nahi — time aage badhao
                currentTime = indexedTasks[taskIndex][0];
            } else {
                // Sabse chhota processingTime wala process karo
                int[] current = minHeap.poll();
                result[resultIndex++] = current[1];
                currentTime += current[0];
            }
        }

        return result;
    }
}
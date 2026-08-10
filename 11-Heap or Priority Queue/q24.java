import java.util.PriorityQueue;

public class q24 {
    /*
     * Pattern: Heap / Max Heap
     * Company Names: Amazon, Google
     * Difficulty: Easy
     *
     * LeetCode #2335: Minimum Amount of Time to Fill Cups
     *
     * Problem samajh lo:
     * Humein 3 types ke cups diye hain (cold, warm, hot).
     * Ek second me hum 2 cups fill kar sakte hain (alag types ke).
     * Ya 1 cup bhi fill kar sakte hain.
     * Humein minimum time nikalna hai saare cups fill karne ka.
     *
     * Example:
     * amount = [1, 4, 2]
     * Step 1: warm + hot = 1 second (warm 3, hot 1)
     * Step 2: warm + cold = 1 second (warm 2, cold 0)
     * Step 3: warm + hot = 1 second (warm 1, hot 0)
     * Step 4: warm = 1 second (warm 0)
     * Total = 4 seconds
     *
     * Best idea:
     * Max heap use karo.
     * Har second me top 2 cups fill karo (agar 2 available hain).
     * Agar sirf 1 cup bacha hai, to usse fill karo.
     *
     * Kyun max heap?
     * Humein hamesha sabse zyada cups wale type ko pehle fill karna hai
     * taaki time minimum ho.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] amount = { 1, 4, 2 };
        System.out.println("Minimum time = " + fillCups(amount));
    }

    public static int fillCups(int[] amount) {
        // Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int count : amount) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            int first = maxHeap.poll();

            if (!maxHeap.isEmpty()) {
                int second = maxHeap.poll();

                // Do cups fill karo
                if (first - 1 > 0) {
                    maxHeap.add(first - 1);
                }
                if (second - 1 > 0) {
                    maxHeap.add(second - 1);
                }
            } else {
                // Sirf ek cup bacha hai
                time += first;
                break;
            }

            time++;
        }

        return time;
    }
}
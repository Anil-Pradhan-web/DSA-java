import java.util.PriorityQueue;

public class q22 {
    /*
     * Pattern: Heap / Max Heap
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Easy
     *
     * LeetCode #506: Relative Ranks
     *
     * Problem samajh lo:
     * Humein athletes ke scores diye hain.
     * Sabse bada score -> "Gold Medal"
     * Dusra sabse bada -> "Silver Medal"
     * Teesra sabse bada -> "Bronze Medal"
     * Baaki -> unki rank number me (4th, 5th, ...)
     *
     * Example:
     * score = [5, 4, 3, 2, 1]
     * Answer = ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     *
     * Best idea:
     * Max heap use karo jisme (score, index) store karo.
     * Heap ka top hamesha sabse bada score hoga.
     * Ek-ek karke poll karo aur rank assign karo.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] score = { 5, 4, 3, 2, 1 };
        String[] result = findRelativeRanks(score);

        System.out.print("Ranks = ");
        for (String rank : result) {
            System.out.print(rank + " ");
        }
        System.out.println();
    }

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Max heap: [score, index]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[] { score[i], i });
        }

        int rank = 1;
        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int index = current[1];

            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }

            rank++;
        }

        return result;
    }
}
import java.util.PriorityQueue;

public class q6 {
    /*
     * Pattern: Heap / Min Heap
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #378: Kth Smallest Element in a Sorted Matrix
     *
     * Problem samajh lo:
     * Humein ek n x n matrix diya hai jisme har row aur har column sorted hai.
     * Humein kth smallest element dhoondhna hai.
     *
     * Example:
     * matrix = [
     * [1, 5, 9],
     * [10, 11, 13],
     * [12, 13, 15]
     * ], k = 8
     * Answer = 13
     *
     * Best idea:
     * Min heap use karo jisme (value, row, col) store karo.
     * Pehle first column ke saare elements daalo.
     * Phir k baar poll karo — har baar us element ke right wala element add karo.
     * kth poll hi answer hai.
     *
     * Kyun right wala?
     * Kyunki matrix me row sorted hai, isliye kisi element ka right wala
     * usse bada hoga. Isse hum sorted order me elements explore karte hain.
     *
     * Time Complexity: O(k log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };
        int k = 8;
        System.out.println("Kth smallest = " + kthSmallest(matrix, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        // Min heap: [value, row, col]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        // First column add karo
        for (int row = 0; row < n; row++) {
            minHeap.add(new int[] { matrix[row][0], row, 0 });
        }

        // k baar poll karo
        int result = 0;
        for (int i = 0; i < k; i++) {
            int[] current = minHeap.poll();
            result = current[0];
            int row = current[1];
            int col = current[2];

            // Right wala element add karo
            if (col + 1 < n) {
                minHeap.add(new int[] { matrix[row][col + 1], row, col + 1 });
            }
        }

        return result;
    }
}
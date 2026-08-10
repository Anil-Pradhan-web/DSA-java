import java.util.PriorityQueue;

public class q3 {
    /*
     * Pattern: Heap / Max Heap of size k
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #973: K Closest Points to Origin
     *
     * Problem samajh lo:
     * Humein points diye hain (x, y coordinates) aur ek origin (0, 0).
     * Humein origin ke sabse paas ke k points dhoondhne hain.
     *
     * Distance formula:
     * distance = x^2 + y^2
     * (sqrt ki zarurat nahi kyunki comparison ke liye squared distance hi kaafi
     * hai)
     *
     * Example:
     * points = [[1, 3], [-2, 2]], k = 1
     * Distance of [1, 3] = 1 + 9 = 10
     * Distance of [-2, 2] = 4 + 4 = 8
     * Answer = [[-2, 2]] (sabse paas)
     *
     * Best idea:
     * Max heap of size k use karo.
     * Heap me hamesha sabse paas ke k points honge.
     * Naya point aaye to usse compare karo — agar wo heap ke top (sabse door) se
     * paas hai,
     * to top remove karke naya point add karo.
     *
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        int[][] result = kClosest(points, k);

        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        // Max heap by distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll();
        }

        return result;
    }
}
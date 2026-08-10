import java.util.PriorityQueue;

public class q16 {
    /*
     * Pattern: Heap / Greedy + Min Heap
     * Company Names: Amazon, Google, Meta
     * Difficulty: Medium
     *
     * LeetCode #1642: Furthest Building You Can Reach
     *
     * Problem samajh lo:
     * Humein buildings ki heights di gayi hain.
     * Building i se i+1 tak jaane ke liye:
     * - Agar next building chhoti hai, to free me jump kar sakte hain
     * - Agar next building badi hai, to difference bricks ya ladder se cover karna
     * hai
     * Humein maximum building index nikalna hai jahan tak pahunch sakte hain.
     *
     * Example:
     * heights = [4, 2, 7, 6, 9, 14, 12], bricks = 5, ladders = 1
     * Answer = 4
     *
     * Best idea:
     * Min heap use karo jisme ladder se cover kiye gaye differences store karo.
     * Har step me:
     * 1. Difference nikaalo (agar next bada hai)
     * 2. Pehle ladder use karo (difference heap me daalo)
     * 3. Agar heap size > ladders, to sabse chhota difference bricks se cover karo
     * 4. Agar bricks kam pad jayein, to return current index
     *
     * Kyun min heap?
     * Ladder sabse bade differences ke liye save karna chahiye.
     * Min heap se sabse chhota difference bricks se cover hota hai.
     *
     * Time Complexity: O(n log l)
     * Space Complexity: O(l)
     */
    public static void main(String[] args) {
        int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
        int bricks = 5;
        int ladders = 1;
        System.out.println("Furthest building = " + furthestBuilding(heights, bricks, ladders));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Min heap for ladder-used differences
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            // Agar next building chhoti ya equal hai, free jump
            if (diff <= 0) {
                continue;
            }

            // Pehle ladder use karo
            minHeap.add(diff);

            // Agar ladder se zyada differences hain, sabse chhota bricks se cover karo
            if (minHeap.size() > ladders) {
                bricks -= minHeap.poll();
            }

            // Agar bricks kam pad gayi, return current index
            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }
}
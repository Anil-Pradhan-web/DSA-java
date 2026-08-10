import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class q13 {
    /*
     * Pattern: Heap / K-way Merge
     * Company Names: Amazon, Google, Uber
     * Difficulty: Medium
     *
     * LeetCode #373: Find K Pairs with Smallest Sums
     *
     * Problem samajh lo:
     * Humein do sorted arrays nums1 aur nums2 diye hain.
     * Humein k pairs (nums1[i], nums2[j]) dhoondhne hain
     * jinke sum sabse chhote hain.
     *
     * Example:
     * nums1 = [1, 7, 11], nums2 = [2, 4, 6], k = 3
     * Pairs sorted by sum:
     * [1, 2] = 3, [1, 4] = 5, [1, 6] = 7
     * Answer = [[1, 2], [1, 4], [1, 6]]
     *
     * Best idea:
     * Min heap use karo jisme (sum, i, j) store karo.
     * Pehle nums1 ke har element ke saath nums2[0] ka pair daalo.
     * Phir k baar poll karo — har baar us pair ke next (i, j+1) wala pair add karo.
     *
     * Kyun j+1 wala?
     * Kyunki nums2 sorted hai, isliye (i, j+1) ka sum (i, j) se bada hoga.
     * Isse hum sorted order me pairs explore karte hain.
     *
     * Time Complexity: O(k log k)
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
        System.out.println("K smallest pairs = " + kSmallestPairs(nums1, nums2, k));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // Min heap: [sum, i, j]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        // Pehle nums1 ke har element ke saath nums2[0] ka pair
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.add(new int[] { nums1[i] + nums2[0], i, 0 });
        }

        // k pairs nikalo
        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[1];
            int j = current[2];

            result.add(List.of(nums1[i], nums2[j]));

            // Next pair (i, j+1) add karo
            if (j + 1 < nums2.length) {
                minHeap.add(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            }

            k--;
        }

        return result;
    }
}
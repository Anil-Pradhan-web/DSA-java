import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q13 {
    /*
     * Pattern: Sorting / Intervals
     * Company Names: Amazon, Meta, Stripe, Google
     *
     * LeetCode #56: Merge Intervals
     *
     * Problem samajh lo:
     * Humein intervals diye hote hain aur overlapping intervals ko merge karke
     * final non-overlapping list return karni hoti hai.
     *
     * Example:
     * intervals = [[1,3], [2,6], [8,10], [15,18]]
     * Answer = [[1,6], [8,10], [15,18]]
     *
     * Core idea:
     * Sabse pehle intervals ko starting time ke basis par sort karo.
     * Ab agar current interval ka start previous merged interval ke end se chhota ya equal hai,
     * to overlap ho raha hai.
     *
     * Overlap hone par:
     * end ko max(previousEnd, currentEnd) bana do
     *
     * Overlap na ho:
     * current interval ko alag se answer me add kar do
     *
     * Sorting ke baad comparison easy ho jata hai
     * kyunki possible overlap sirf recently merged interval ke saath hi check karna hota hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] answer = merge(intervals);
        for (int[] interval : answer) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] current : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < current[0]) {
                merged.add(new int[]{current[0], current[1]});
            } else {
                merged.get(merged.size() - 1)[1] =
                    Math.max(merged.get(merged.size() - 1)[1], current[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}

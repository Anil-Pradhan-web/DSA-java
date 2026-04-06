import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q7 {
    /*
     * Pattern: Sorting / Intervals
     * Company Names: Amazon, Meta, Stripe
     * Difficulty: Medium
     *
     * LeetCode #56: Merge Intervals
     *
     * Problem samajh lo:
     * Overlapping intervals ko merge karke final non-overlapping list return karni hai.
     *
     * First step almost always:
     * start time ke basis par sort karo.
     *
     * Fir current interval ko last merged interval se compare karo.
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

import java.util.Arrays;

public class q19 {
    /*
     * Pattern: Sorting / Greedy Intervals
     * Company Names: Google, Amazon
     * Difficulty: Medium
     *
     * LeetCode #435: Non-overlapping Intervals
     *
     * Problem samajh lo:
     * Minimum intervals remove karne hain taaki remaining intervals overlap na karein.
     *
     * Greedy idea:
     * End time ke basis par sort karo.
     * Jo interval sabse jaldi finish hota hai use prefer karna safe hota hai.
     *
     * Agar current interval previous chosen ke end se pehle start ho raha hai,
     * to overlap hai aur removal count badhega.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) extra
     */
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[1], second[1]));

        int removals = 0;
        int previousEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < previousEnd) {
                removals++;
            } else {
                previousEnd = intervals[i][1];
            }
        }

        return removals;
    }
}

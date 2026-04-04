import java.util.Arrays;

public class q44 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Merge Overlapping Intervals Variation - Non-overlapping Intervals
     *
     * Problem samajh lo:
     * Humein minimum number of intervals remove karne hain
     * taaki remaining intervals overlap na karein.
     *
     * Example:
     * intervals = [[1,2], [2,3], [3,4], [1,3]]
     * Answer = 1
     *
     * Greedy idea:
     * Intervals ko end time ke basis par sort karo.
     * Jo interval sabse jaldi khatam hota hai usko prefer karna safe hota hai,
     * kyunki usse future intervals ke liye zyada jagah bachti hai.
     *
     * Agar current interval previous chosen interval ke end se pehle start ho raha hai,
     * to overlap hai aur humein ek removal count karna padega.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) extra
     */
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 3}
        };
        System.out.println("Minimum removals = " + eraseOverlapIntervals(intervals));
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

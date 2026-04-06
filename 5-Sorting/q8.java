import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q8 {
    /*
     * Pattern: Sorting / Intervals
     * Company Names: Google, LinkedIn
     * Difficulty: Medium
     *
     * LeetCode #57: Insert Interval
     *
     * Problem samajh lo:
     * Sorted non-overlapping intervals diye gaye hain.
     * Ek new interval insert karna hai aur zarurat par merge bhi karna hai.
     *
     * Idea:
     * 1. non-overlapping left part add karo
     * 2. overlap wale intervals ke saath merge karo
     * 3. remaining right part add karo
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] answer = insert(intervals, newInterval);
        for (int[] interval : answer) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        int index = 0;

        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            answer.add(intervals[index++]);
        }

        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        answer.add(newInterval);

        while (index < intervals.length) {
            answer.add(intervals[index++]);
        }

        return answer.toArray(new int[answer.size()][]);
    }
}

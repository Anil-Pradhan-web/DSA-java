import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q14 {
    /*
     * Pattern: Sorting / Intervals
     * Company Names: Google, LinkedIn
     *
     * LeetCode #57: Insert Interval
     *
     * Problem samajh lo:
     * Humein already sorted non-overlapping intervals diye hote hain.
     * Ek new interval insert karna hai aur final answer me overlapping intervals merge bhi karne hain.
     *
     * Example:
     * intervals = [[1,3], [6,9]]
     * newInterval = [2,5]
     * Answer = [[1,5], [6,9]]
     *
     * Approach ko 3 parts me samajho:
     *
     * 1. Jo intervals newInterval se pehle completely finish ho rahe hain,
     * unhe directly answer me daal do.
     *
     * 2. Jo intervals newInterval ke saath overlap kar rahe hain,
     * unke saath merge karte jao.
     * newInterval ka start minimum lo
     * aur end maximum lo
     *
     * 3. Jo intervals merge ke baad bach gaye,
     * unhe seedha answer me daal do.
     *
     * Is problem me sorting dubara karne ki zarurat nahi padti
     * kyunki input already sorted hota hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {6, 9}
        };
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
            answer.add(intervals[index]);
            index++;
        }

        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        answer.add(newInterval);

        while (index < intervals.length) {
            answer.add(intervals[index]);
            index++;
        }

        return answer.toArray(new int[answer.size()][]);
    }
}

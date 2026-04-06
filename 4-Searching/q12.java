import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q12 {
    /*
     * Pattern: Binary Search
     * Company Names: Bloomberg, Paytm
     * Difficulty: Medium
     *
     * LeetCode #436: Find Right Interval
     *
     * Problem samajh lo:
     * Har interval ke liye aisa interval dhoondhna hai jiska start
     * current interval ke end se greater ya equal ho, aur aisa start minimum ho.
     *
     * Idea:
     * Saare starts ko sort karo.
     * Har interval ke end ke liye lower bound binary search chalao.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }

    public static int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] starts = new int[n][2];

        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        Arrays.sort(starts, (first, second) -> Integer.compare(first[0], second[0]));

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            int index = lowerBound(starts, target);
            answer[i] = index == -1 ? -1 : starts[index][1];
        }

        return answer;
    }

    private static int lowerBound(int[][] starts, int target) {
        int left = 0;
        int right = starts.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (starts[mid][0] >= target) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}

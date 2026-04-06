import java.util.Arrays;

public class q9 {
    /*
     * Pattern: Sorting / Intervals
     * Company Names: Amazon, Google, FB
     * Difficulty: Medium
     *
     * LeetCode #253: Meeting Rooms II
     *
     * Problem samajh lo:
     * Minimum kitne rooms chahiye taaki saari meetings ho sakein.
     *
     * Start times aur end times ko alag sort karte hain.
     * Agar next meeting current earliest ending se pehle start ho rahi hai,
     * to naya room chahiye.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int startPointer = 0;
        int endPointer = 0;
        int rooms = 0;
        int maxRooms = 0;

        while (startPointer < n) {
            if (starts[startPointer] < ends[endPointer]) {
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
                startPointer++;
            } else {
                rooms--;
                endPointer++;
            }
        }

        return maxRooms;
    }
}

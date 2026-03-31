import java.util.Arrays;

public class q16 {
    /*
     * Pattern: Sorting / Intervals
     * Company Names: Amazon, Google, Facebook
     *
     * LeetCode #253: Meeting Rooms II
     *
     * Problem samajh lo:
     * Humein meeting intervals diye hote hain.
     * Minimum kitne rooms chahiye taaki saari meetings attend ho sakein, wo nikalna hai.
     *
     * Example:
     * intervals = [[0,30], [5,10], [15,20]]
     * Answer = 2
     *
     * Smart idea:
     * Start times aur end times ko alag-alag sort kar lo.
     *
     * Ab:
     * Agar next meeting ka start current smallest end se pehle aa raha hai,
     * to naya room chahiye.
     *
     * Agar next meeting ka start current end ke baad ya equal hai,
     * to ek room free ho gaya, usko reuse kar sakte hain.
     *
     * Two pointers:
     * startPointer sorted starts par chalega
     * endPointer sorted ends par chalega
     *
     * Jab start < end:
     * rooms++
     *
     * Jab start >= end:
     * ek room free ho gaya, endPointer++
     *
     * Maximum simultaneous meetings hi answer hota hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[][] intervals = {
            {0, 30},
            {5, 10},
            {15, 20}
        };
        System.out.println("Minimum rooms = " + minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPointer = 0;
        int endPointer = 0;
        int roomsInUse = 0;
        int maxRooms = 0;

        while (startPointer < n) {
            if (startTimes[startPointer] < endTimes[endPointer]) {
                roomsInUse++;
                maxRooms = Math.max(maxRooms, roomsInUse);
                startPointer++;
            } else {
                roomsInUse--;
                endPointer++;
            }
        }

        return maxRooms;
    }
}

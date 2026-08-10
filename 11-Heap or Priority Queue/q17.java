import java.util.Arrays;
import java.util.PriorityQueue;

public class q17 {
    /*
     * Pattern: Heap / Greedy + Min Heap
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #253: Meeting Rooms II
     *
     * Problem samajh lo:
     * Humein meetings ke intervals diye hain (start, end time).
     * Humein minimum number of rooms chahiye taaki saari meetings bina conflict ke
     * ho sakein.
     *
     * Example:
     * intervals = [[0, 30], [5, 10], [15, 20]]
     * Meeting 1 (0-30) poore time room occupy karega.
     * Meeting 2 (5-10) ke liye alag room chahiye.
     * Meeting 3 (15-20) 2nd room me ho sakti hai.
     * Answer = 2 rooms
     *
     * Best idea:
     * Step 1: Intervals ko start time ke basis par sort karo.
     * Step 2: Min heap me end times store karo.
     * Step 3: Har meeting ke liye:
     * - Agar current meeting ka start >= heap ka top (sabse pehle khali hone wala
     * room),
     * to room reuse karo (poll karo).
     * - Current meeting ka end time heap me add karo.
     * Step 4: Heap ka size = total rooms needed.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println("Minimum rooms needed = " + minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Min heap for end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Step 3: Koi room free hai?
            // Agar current start >= sabse pehle khulne wala room ka end time
            if (!minHeap.isEmpty() && start >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.add(end);
        }

        return minHeap.size();
    }
}
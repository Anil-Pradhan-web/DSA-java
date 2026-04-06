public class q28 {
    /*
     * Pattern: Binary Search on Answer
     * Company Names: Google
     *
     * LeetCode #774: Minimize Max Distance to Gas Station
     *
     * Problem samajh lo:
     * Existing gas stations positions diye hote hain.
     * Humein k new gas stations add karne hain
     * taaki adjacent gas stations ke beech ka maximum distance minimum ho jaye.
     *
     * Candidate answer = allowed maximum distance
     * Feasibility:
     * Check karo ki given max distance maintain karne ke liye kitne extra stations chahiye.
     *
     * Ye continuous answer-space binary search ka example hai.
     *
     * Time Complexity: O(n log(range/precision))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 9;
        System.out.println(minmaxGasDist(stations, k));
    }

    public static double minmaxGasDist(int[] stations, int k) {
        double low = 0.0;
        double high = 0.0;

        for (int i = 1; i < stations.length; i++) {
            high = Math.max(high, stations[i] - stations[i - 1]);
        }

        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;

            if (neededStations(stations, mid) > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }

    private static int neededStations(int[] stations, double distance) {
        int needed = 0;

        for (int i = 1; i < stations.length; i++) {
            needed += (int) ((stations[i] - stations[i - 1]) / distance);

            if ((stations[i] - stations[i - 1]) % distance == 0) {
                needed--;
            }
        }

        return needed;
    }
}

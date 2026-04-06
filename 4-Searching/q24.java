public class q24 {
    /*
     * Pattern: Binary Search on Answer
     * Company Names: Amazon, Google
     *
     * LeetCode #1482: Minimum Number of Days to Make m Bouquets
     *
     * Problem samajh lo:
     * Bloom days array diya hai.
     * Humein minimum day dhoondhna hai jahan m bouquets ban sakein,
     * aur har bouquet me k adjacent flowers chahiye.
     *
     * Candidate answer = day
     * Feasibility:
     * Check karo ki given day tak kitne bouquets ban sakte hain.
     *
     * Time Complexity: O(n log(maxDay))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}

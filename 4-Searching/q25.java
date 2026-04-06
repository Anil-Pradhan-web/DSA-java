public class q25 {
    /*
     * Pattern: Binary Search on Answer
     * Company Names: Google
     *
     * LeetCode #1283: Find the Smallest Divisor Given a Threshold
     *
     * Problem samajh lo:
     * Humein smallest divisor chahiye jisse array elements ko divide karke
     * rounded-up sum threshold ke andar aa jaye.
     *
     * Candidate answer = divisor
     * Feasibility:
     * Check karo ki total rounded-up division sum <= threshold hai ya nahi.
     *
     * Time Complexity: O(n log(maxValue))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for (int value : nums) {
            high = Math.max(high, value);
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, threshold, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private static boolean isPossible(int[] nums, int threshold, int divisor) {
        int sum = 0;

        for (int value : nums) {
            sum += (value + divisor - 1) / divisor;
        }

        return sum <= threshold;
    }
}

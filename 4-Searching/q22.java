public class q22 {
    /*
     * Pattern: Binary Search on Answer
     * Company Names: Amazon, Microsoft
     *
     * LeetCode #1011: Capacity to Ship Packages Within D Days
     *
     * Problem samajh lo:
     * Packages order same rakhte hue ship karne hain.
     * Humein minimum ship capacity chahiye jo given days ke andar kaam complete kar de.
     *
     * Ye bhi "minimum feasible answer" problem hai.
     *
     * Time Complexity: O(n log(sum))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1;
        int current = 0;

        for (int weight : weights) {
            if (current + weight > capacity) {
                usedDays++;
                current = weight;
            } else {
                current += weight;
            }
        }

        return usedDays <= days;
    }
}

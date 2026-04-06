public class q5 {
    /*
     * Pattern: Binary Search
     * Company Names: Capgemini, HCL
     * Difficulty: Easy
     *
     * LeetCode #374: Guess Number Higher or Lower
     *
     * Problem samajh lo:
     * 1 se n ke beech ek hidden number hota hai.
     * Ek guess API batati hai:
     * - target chhota hai
     * - target bada hai
     * - ya exact match hai
     *
     * Ye classic binary search hai on answer range.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private static final int PICK = 6;

    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNumber(n));
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private static int guess(int num) {
        if (num == PICK) {
            return 0;
        }
        return num > PICK ? -1 : 1;
    }
}

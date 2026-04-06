public class q4 {
    /*
     * Pattern: Binary Search
     * Company Names: TCS, Wipro, HCL
     * Difficulty: Easy
     *
     * LeetCode #69: Sqrt(x)
     *
     * Problem samajh lo:
     * Non-negative integer x ka floor square root nikalna hai.
     * Matlab largest integer y chahiye jiska y * y <= x ho.
     *
     * Ye answer-space binary search hai.
     * Search space 1 se x tak hota hai.
     *
     * Time Complexity: O(log x)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = 1L * mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}

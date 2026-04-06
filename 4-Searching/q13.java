public class q13 {
    /*
     * Pattern: Binary Search on Answer
     * Company Names: Uber, Adobe
     * Difficulty: Medium
     *
     * LeetCode #378: Kth Smallest Element in a Sorted Matrix
     *
     * Problem samajh lo:
     * Matrix ki rows aur columns sorted hain.
     * Humein kth smallest element dhoondhna hai.
     *
     * Strong searching approach:
     * Answer range matrix[0][0] se matrix[n-1][n-1] tak hota hai.
     * Mid value maan kar count karo ki kitne elements <= mid hain.
     *
     * Agar count >= k hai,
     * to answer mid ya usse chhota ho sakta hai.
     * Warna answer bada hoga.
     *
     * Ye pure binary search on answer ka classic matrix problem hai.
     *
     * Time Complexity: O(n log range)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (countLessThanOrEqual(matrix, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int countLessThanOrEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}

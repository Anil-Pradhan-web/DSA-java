public class q47 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Search a 2D Matrix
     *
     * Problem samajh lo:
     * Matrix ki har row sorted hoti hai
     * aur har next row ka first element previous row ke last element se bada hota hai.
     * Yani poori matrix ko logically ek sorted 1D array ki tarah treat kar sakte hain.
     *
     * Example:
     * matrix =
     * [
     *   [1, 3, 5, 7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 60]
     * ]
     * target = 3
     * Answer = true
     *
     * Best idea:
     * Pure matrix par binary search chalao.
     * Mid index ko row aur column me map karo:
     * row = mid / cols
     * col = mid % cols
     *
     * Isse matrix flatten kiye bina binary search apply ho jaati hai.
     *
     * Time Complexity: O(log(m * n))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}

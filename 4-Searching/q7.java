public class q7 {
    /*
     * Pattern: Binary Search
     * Company Names: Wipro, Cognizant
     * Difficulty: Medium
     *
     * LeetCode #74: Search a 2D Matrix
     *
     * Problem samajh lo:
     * Matrix ki har row sorted hoti hai,
     * aur next row ka first element previous row ke last element se bada hota hai.
     * Yani poori matrix logically ek sorted 1D array jaisi behave karti hai.
     *
     * Isliye matrix flatten kiye bina binary search laga sakte hain.
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
            int value = matrix[mid / cols][mid % cols];

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

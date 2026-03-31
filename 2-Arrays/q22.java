import java.util.Arrays;

public class q22 {
    /*
     * Pattern: Matrix / 2D Array
     * Company Names: Amazon, Microsoft
     *
     * LeetCode #48: Rotate Image
     *
     * Problem samajh lo:
     * Ek n x n matrix ko 90 degree clockwise rotate karna hai,
     * wo bhi in-place.
     *
     * Example:
     * [
     *   [1, 2, 3],
     *   [4, 5, 6],
     *   [7, 8, 9]
     * ]
     *
     * Rotation ke baad:
     * [
     *   [7, 4, 1],
     *   [8, 5, 2],
     *   [9, 6, 3]
     * ]
     *
     * Best trick:
     * 1. Matrix ka transpose karo
     * 2. Har row ko reverse karo
     *
     * Transpose ka matlab:
     * matrix[row][col] ko matrix[col][row] se swap karna
     *
     * Why it works:
     * Transpose se rows aur columns exchange ho jaate hain
     * aur row reverse karne se final clockwise rotation mil jata hai.
     *
     * Yeh approach bahut important matrix trick hai.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotate(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        for (int[] row : matrix) {
            int left = 0;
            int right = row.length - 1;

            while (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }
}

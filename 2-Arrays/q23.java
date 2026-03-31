import java.util.Arrays;

public class q23 {
    /*
     * Pattern: Matrix / 2D Array
     * Company Names: Flipkart, Adobe, Microsoft
     *
     * LeetCode #73: Set Matrix Zeroes
     *
     * Problem samajh lo:
     * Agar matrix me kisi bhi cell par 0 milta hai,
     * to uski poori row aur poora column 0 karna hota hai.
     *
     * Example:
     * [
     *   [1, 1, 1],
     *   [1, 0, 1],
     *   [1, 1, 1]
     * ]
     *
     * Answer:
     * [
     *   [1, 0, 1],
     *   [0, 0, 0],
     *   [1, 0, 1]
     * ]
     *
     * Simple approach:
     * Alag row marker aur column marker arrays use karo.
     *
     * Step 1:
     * Poora matrix scan karo.
     * Jahan 0 mile, us row aur us column ko mark kar do.
     *
     * Step 2:
     * Dubara matrix traverse karo.
     * Agar row marked hai ya column marked hai,
     * to cell ko 0 bana do.
     *
     * Isse original zeroes ka effect safely baad me apply hota hai.
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n)
     */
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        setZeroes(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void setZeroes(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    zeroRows[row] = true;
                    zeroCols[col] = true;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (zeroRows[row] || zeroCols[col]) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}

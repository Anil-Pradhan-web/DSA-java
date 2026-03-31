import java.util.ArrayList;
import java.util.List;

public class q21 {
    /*
     * Pattern: Matrix / 2D Array
     * Company Names: Amazon, Microsoft, Apple
     *
     * LeetCode #54: Spiral Matrix
     *
     * Problem samajh lo:
     * Humein 2D matrix ke saare elements spiral order me print ya return karne hote hain.
     * Spiral order ka matlab hai:
     * pehle top row,
     * phir right column,
     * phir bottom row reverse,
     * phir left column reverse,
     * aur aise hi andar ki layer tak jaate hain.
     *
     * Example:
     * matrix =
     * [
     *   [1, 2, 3],
     *   [4, 5, 6],
     *   [7, 8, 9]
     * ]
     * Answer = [1, 2, 3, 6, 9, 8, 7, 4, 5]
     *
     * Boundary idea:
     * 4 boundaries maintain karte hain:
     * top, bottom, left, right
     *
     * Har round me:
     * 1. top row left se right
     * 2. right column top se bottom
     * 3. bottom row right se left
     * 4. left column bottom se top
     *
     * Har traversal ke baad related boundary ko shrink kar dete hain.
     *
     * Important:
     * Single row ya single column bache to duplicate printing avoid karne ke liye
     * conditions check karni padti hain.
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n) for answer list
     */
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                answer.add(matrix[top][col]);
            }
            top++;

            for (int row = top; row <= bottom; row++) {
                answer.add(matrix[row][right]);
            }
            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    answer.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    answer.add(matrix[row][left]);
                }
                left++;
            }
        }

        return answer;
    }
}

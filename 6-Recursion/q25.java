import java.util.ArrayList;
import java.util.List;

public class q25 {
    /*
     * Pattern: Backtracking / Placement Problem
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Hard
     *
     * LeetCode #51: N-Queens
     *
     * Problem samajh lo:
     * N x N board par queens place karni hain
     * aise ki koi queen kisi doosri queen ko attack na kare.
     *
     * Row by row placement karte hain.
     * Column, main diagonal, aur anti-diagonal occupied tracking use hoti hai.
     *
     * Time Complexity: Roughly O(n!)
     * Space Complexity: O(n^2) output dependent + O(n) recursion
     */
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = '.';
            }
        }

        backtrack(0, board, new boolean[n], new boolean[2 * n], new boolean[2 * n], answer);
        return answer;
    }

    private static void backtrack(
        int row,
        char[][] board,
        boolean[] cols,
        boolean[] diagonal,
        boolean[] antiDiagonal,
        List<List<String>> answer
    ) {
        int n = board.length;

        if (row == n) {
            List<String> configuration = new ArrayList<>();
            for (char[] currentRow : board) {
                configuration.add(new String(currentRow));
            }
            answer.add(configuration);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d = row - col + n;
            int ad = row + col;

            if (cols[col] || diagonal[d] || antiDiagonal[ad]) {
                continue;
            }

            cols[col] = true;
            diagonal[d] = true;
            antiDiagonal[ad] = true;
            board[row][col] = 'Q';

            backtrack(row + 1, board, cols, diagonal, antiDiagonal, answer);

            board[row][col] = '.';
            cols[col] = false;
            diagonal[d] = false;
            antiDiagonal[ad] = false;
        }
    }
}

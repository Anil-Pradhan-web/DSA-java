public class q26 {
    /*
     * Pattern: Backtracking / Constraint Satisfaction
     * Company Names: Google, Uber
     * Difficulty: Hard
     *
     * LeetCode #37: Sudoku Solver
     *
     * Problem samajh lo:
     * 9x9 sudoku board solve karna hai by filling empty cells.
     * Har row, column, aur 3x3 box me 1 se 9 unique hone chahiye.
     *
     * Backtracking:
     * Empty cell dhoondo
     * 1 se 9 try karo
     * valid ho to recurse karo
     * fail ho to undo karo
     *
     * Time Complexity: Exponential worst case
     * Space Complexity: O(81) recursion depth bounded
     */
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char value = '1'; value <= '9'; value++) {
                        if (isValid(board, row, col, value)) {
                            board[row][col] = value;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value || board[i][col] == value) {
                return false;
            }

            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == value) {
                return false;
            }
        }

        return true;
    }
}

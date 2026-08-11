import java.util.HashSet;
import java.util.Set;

public class q13 {
    /*
     * Pattern: Hashing / HashSet
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Medium
     *
     * LeetCode #36: Valid Sudoku
     *
     * Problem samajh lo:
     * Humein ek 9x9 Sudoku board diya hai. Check karna hai ki board valid hai ya
     * nahi.
     * Valid matlab:
     * - Har row me 1-9 digits unique hain
     * - Har column me 1-9 digits unique hain
     * - Har 3x3 sub-box me 1-9 digits unique hain
     * - '.' ka matlab khali cell hai, ignore karo
     *
     * (Note: Sirf validity check karna hai, solvability nahi)
     *
     * Best idea:
     * HashSet use karo jisme strings store karo.
     * Har digit ke liye 3 entries add karo:
     * 1. "row" + row + digit
     * 2. "col" + col + digit
     * 3. "box" + (row/3) + (col/3) + digit
     * Agar koi add() false return kare, to invalid hai.
     *
     * Kyun strings?
     * Rows, columns, boxes alag-alag hain. String format se
     * ek hi set me teeno checks ho jate hain.
     *
     * Time Complexity: O(1) — fixed 9x9 board
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println("Is valid sudoku = " + isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char digit = board[row][col];
                if (digit == '.') {
                    continue;
                }

                // 3 positions me add karo
                String rowKey = "row" + row + digit;
                String colKey = "col" + col + digit;
                String boxKey = "box" + (row / 3) + (col / 3) + digit;

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}
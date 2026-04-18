public class q22 {
    /*
     * Pattern: Backtracking / Grid Search
     * Company Names: Amazon, Microsoft, Meta
     * Difficulty: Medium
     *
     * LeetCode #79: Word Search
     *
     * Problem samajh lo:
     * Grid me adjacent cells se word banana hai.
     * Ek path me same cell dobara use nahi kar sakte.
     *
     * DFS + backtracking:
     * Current cell choose karo
     * 4 directions me explore karo
     * Phir undo mark karo
     *
     * Time Complexity: O(m * n * 4^L) worst case
     * Space Complexity: O(L)
     */
    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0
            || row >= board.length
            || col < 0
            || col >= board[0].length
            || board[row][col] != word.charAt(index)) {
            return false;
        }

        char original = board[row][col];
        board[row][col] = '#';

        boolean found =
            dfs(board, word, row + 1, col, index + 1)
                || dfs(board, word, row - 1, col, index + 1)
                || dfs(board, word, row, col + 1, index + 1)
                || dfs(board, word, row, col - 1, index + 1);

        board[row][col] = original;
        return found;
    }
}

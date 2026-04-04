public class q26 {
    /*
     * Pattern: Strings
     * Company Names: Microsoft, Amazon, Meta
     * Difficulty: Medium
     *
     * LeetCode #79: Word Search
     *
     * Problem samajh lo:
     * Humein 2D board me check karna hai ki given word exist karta hai ya nahi.
     * Word adjacent cells se banega, aur ek cell ko same path me dobara use nahi kar sakte.
     *
     * Example:
     * board = [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     * word = "ABCCED"
     * Answer = true
     *
     * Backtracking idea:
     * Har cell ko possible start maan lo.
     * Agar current character match karta hai,
     * to 4 directions me recursively explore karo.
     *
     * Visited mark karna important hai
     * taaki same path me same cell repeat na ho.
     *
     * Time Complexity: O(m * n * 4^L) worst case
     * Space Complexity: O(L) recursion stack
     * yahan L = word length
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

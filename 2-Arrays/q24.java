import java.util.Arrays;

public class q24 {
    /*
     * Pattern: Matrix / 2D Array
     * Company Names: Amazon, Microsoft
     *
     * LeetCode #289: Game of Life
     *
     * Problem samajh lo:
     * 2D board me har cell ya to alive hota hai ya dead.
     * Humein next state calculate karni hoti hai based on neighbors.
     *
     * Rules:
     * 1. Live cell with fewer than 2 live neighbors -> dies
     * 2. Live cell with 2 or 3 live neighbors -> survives
     * 3. Live cell with more than 3 live neighbors -> dies
     * 4. Dead cell with exactly 3 live neighbors -> becomes alive
     *
     * Challenge:
     * In-place update karte waqt old state bhi preserve karni hoti hai,
     * kyunki next cells ka decision original board par depend karta hai.
     *
     * Encoding trick:
     * -1 means originally alive tha, ab dead hoga
     *  2 means originally dead tha, ab alive hoga
     *
     * Neighbor count karte waqt:
     * 1 aur -1 dono ko originally alive treat karte hain.
     *
     * End me:
     * positive values ko 1
     * baaki ko 0 bana do
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        gameOfLife(board);

        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[] directions = {-1, 0, 1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;

                for (int rowDiff : directions) {
                    for (int colDiff : directions) {
                        if (rowDiff == 0 && colDiff == 0) {
                            continue;
                        }

                        int newRow = row + rowDiff;
                        int newCol = col + colDiff;

                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                            if (board[newRow][newCol] == 1 || board[newRow][newCol] == -1) {
                                liveNeighbors++;
                            }
                        }
                    }
                }

                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = -1;
                }

                if (board[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 2;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}

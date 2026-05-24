import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Pattern: BFS Queue on Grid
 * Company Names: Amazon
 * Difficulty: Medium
 *
 * Problem: Rotting Oranges
 * LeetCode: 994
 *
 * Hinglish Explanation:
 * Grid mein 0 empty cell, 1 fresh orange, aur 2 rotten orange hota hai.
 * Har minute rotten orange apne 4-direction neighbours ko rot kar sakta hai.
 *
 * Is problem mein ek rotten orange se BFS nahi, balki saare rotten oranges se
 * ek saath BFS start hota hai. Isko multi-source BFS bolte hain.
 *
 * Level by level BFS ka matlab:
 * - Queue mein current minute ke rotten oranges rahenge.
 * - Unke neighbours next minute mein rotten banenge.
 * - Har completed level ke baad minutes increment karo.
 *
 * Agar BFS ke baad bhi fresh orange bacha, answer -1 hoga.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class q20 {
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for (int[] dir : dirs) {
                    int nr = cell[0] + dir[0];
                    int nc = cell[1] + dir[1];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int[] {nr, nc});
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(orangesRotting(grid)); // 4
    }
}

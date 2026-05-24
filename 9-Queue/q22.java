import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Pattern: BFS Queue on Grid
 * Company Names: Meta, Google, Amazon
 * Difficulty: Medium
 *
 * Problem: Number of Islands
 * LeetCode: 200
 *
 * Hinglish Explanation:
 * Grid mein '1' land hai aur '0' water hai.
 * Connected land cells milkar ek island banate hain.
 *
 * Jab bhi unvisited '1' mile:
 * - Island count badhao.
 * - BFS se us poore connected island ko visit/mark kar do.
 *
 * Yahan visited array alag banane ki jagah hum grid mein hi '1' ko '0'
 * mark kar rahe hain. Isse same land dobara count nahi hoga.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class q22 {
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[] {r, c});
                    grid[r][c] = '0';

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();

                        for (int[] dir : dirs) {
                            int nr = cell[0] + dir[0];
                            int nc = cell[1] + dir[1];

                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                                grid[nr][nc] = '0';
                                queue.offer(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0'},
            {'1', '0', '0', '1'},
            {'0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid)); // 2
    }
}

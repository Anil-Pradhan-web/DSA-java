import java.util.ArrayDeque;
import java.util.Queue;

public class q8 {
    /*
     * Pattern: BFS / Grid Multi-source
     * Company Names: Amazon, Flipkart, Adobe
     * Difficulty: Medium
     *
     * LeetCode #994: Rotting Oranges
     *
     * Problem samajh lo:
     * Rotten oranges adjacent fresh oranges ko every minute rot karte hain.
     * Minimum minutes return karne hain.
     *
     * Multi-source BFS:
     * Saare rotten oranges initially queue me daalo.
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int[] dir : dirs) {
                    int nr = current[0] + dir[0];
                    int nc = current[1] + dir[1];

                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}

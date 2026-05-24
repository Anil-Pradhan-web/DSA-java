import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Pattern: BFS Queue on Grid
 * Company Names: Amazon, Microsoft
 * Difficulty: Medium
 *
 * Problem: Shortest Path in Binary Matrix
 * LeetCode: 1091
 *
 * Hinglish Explanation:
 * Matrix mein 0 open cell hai aur 1 blocked cell hai.
 * Hume top-left se bottom-right tak shortest path chahiye.
 * Movement 8 directions mein allowed hai.
 *
 * Shortest path + equal cost movement = BFS.
 *
 * BFS level path length represent karta hai:
 * - Start cell path length 1 hai.
 * - Har next level path length +1 hota hai.
 *
 * Visited ke liye grid cell ko 1 mark kar sakte hain, kyunki 1 blocked/visited
 * dono ka kaam karega.
 *
 * Time Complexity: O(n * n)
 * Space Complexity: O(n * n)
 */
public class q23 {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        grid[0][0] = 1;
        int pathLength = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                if (cell[0] == n - 1 && cell[1] == n - 1) {
                    return pathLength;
                }

                for (int[] dir : dirs) {
                    int nr = cell[0] + dir[0];
                    int nc = cell[1] + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }

            pathLength++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1},
            {1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid)); // 2
    }
}

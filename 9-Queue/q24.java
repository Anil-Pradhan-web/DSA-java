import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/*
 * Pattern: BFS Queue on Grid
 * Company Names: Amazon, Google
 * Difficulty: Medium
 *
 * Problem: Pacific Atlantic Water Flow
 * LeetCode: 417
 *
 * Hinglish Explanation:
 * Water high height se low/equal height ki taraf flow kar sakta hai.
 * Direct har cell se ocean check karoge to expensive hoga.
 *
 * Smart reverse thinking:
 * Ocean border se BFS start karo aur ulta move karo:
 * - Agar next cell current se higher/equal hai, to ocean us cell tak reach kar
 *   sakta hai.
 *
 * Pacific ke borders se BFS karo, Atlantic ke borders se BFS karo.
 * Jo cells dono oceans se reachable hain, wahi answer hain.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class q24 {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        Queue<int[]> pacQueue = new ArrayDeque<>();
        Queue<int[]> atlQueue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            pacific[r][0] = true;
            pacQueue.offer(new int[] {r, 0});
            atlantic[r][cols - 1] = true;
            atlQueue.offer(new int[] {r, cols - 1});
        }

        for (int c = 0; c < cols; c++) {
            pacific[0][c] = true;
            pacQueue.offer(new int[] {0, c});
            atlantic[rows - 1][c] = true;
            atlQueue.offer(new int[] {rows - 1, c});
        }

        bfs(heights, pacific, pacQueue);
        bfs(heights, atlantic, atlQueue);

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private static void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] dir : dirs) {
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) {
                    continue;
                }

                if (heights[nr][nc] >= heights[cell[0]][cell[1]]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        System.out.println(pacificAtlantic(heights));
    }
}

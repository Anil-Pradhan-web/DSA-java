import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 * Pattern: Multi-Source BFS Queue on Grid
 * Company Names: Amazon, Facebook
 * Difficulty: Medium
 *
 * Problem: 01 Matrix
 * LeetCode: 542
 *
 * Hinglish Explanation:
 * Har cell ke liye nearest 0 ka distance find karna hai.
 *
 * Agar har 1 se nearest 0 search karoge, to repeated BFS hoga.
 * Smart approach:
 * - Saare 0 cells ko queue mein daalo.
 * - Unhi se multi-source BFS start karo.
 * - Jo cell pehli baar visit hota hai, wahi uska nearest 0 distance hota hai.
 *
 * Distance array initially -1 rakho. 0 cells ka distance 0 set karo.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class q25 {
    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            Arrays.fill(dist[r], -1);
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    dist[r][c] = 0;
                    queue.offer(new int[] {r, c});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] dir : dirs) {
                int nr = cell[0] + dir[0];
                int nc = cell[1] + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cell[0]][cell[1]] + 1;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }
}

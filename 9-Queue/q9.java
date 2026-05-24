import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class q9 {
    /*
     * Pattern: BFS / Multi-source Grid
     * Company Names: Facebook, Adobe
     * Difficulty: Medium
     *
     * LeetCode #286: Walls and Gates
     *
     * Problem samajh lo:
     * Empty rooms ko nearest gate distance se fill karna hai.
     *
     * Multi-source BFS:
     * Saare gates ko queue me daalo.
     * BFS level distance naturally shortest distance deta hai.
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public static void main(String[] args) {
        int inf = 2147483647;
        int[][] rooms = {
            {inf, -1, 0, inf},
            {inf, inf, inf, -1},
            {inf, -1, inf, -1},
            {0, -1, inf, inf}
        };
        wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

    public static void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                if (rooms[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] dir : dirs) {
                int nr = current[0] + dir[0];
                int nc = current[1] + dir[1];

                if (nr >= 0
                    && nr < rooms.length
                    && nc >= 0
                    && nc < rooms[0].length
                    && rooms[nr][nc] == 2147483647) {
                    rooms[nr][nc] = rooms[current[0]][current[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}

import java.util.ArrayDeque;
import java.util.Queue;

public class q11 {
    /*
     * Pattern: BFS / Array States
     * Company Names: Flipkart, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #1306: Jump Game III
     *
     * Problem samajh lo:
     * Start index se jump karke value 0 tak pahunch sakte ho ya nahi.
     * Har index se i + arr[i] ya i - arr[i] par ja sakte hain.
     *
     * BFS:
     * Index ko node treat karo.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(canReach(arr, start));
    }

    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[arr.length];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();

            if (arr[index] == 0) {
                return true;
            }

            int forward = index + arr[index];
            int backward = index - arr[index];

            if (forward < arr.length && !visited[forward]) {
                visited[forward] = true;
                queue.offer(forward);
            }

            if (backward >= 0 && !visited[backward]) {
                visited[backward] = true;
                queue.offer(backward);
            }
        }

        return false;
    }
}

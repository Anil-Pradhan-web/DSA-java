import java.util.ArrayDeque;
import java.util.Queue;

public class q4 {
    /*
     * Pattern: Queue / Sliding Time Window
     * Company Names: Capgemini, HCL
     * Difficulty: Easy
     *
     * LeetCode #933: Number of Recent Calls
     *
     * Problem samajh lo:
     * Har ping(t) par last 3000 milliseconds ke calls count karne hain.
     *
     * Queue me timestamps store karo.
     * Jo t - 3000 se purane hain unhe remove kar do.
     *
     * Time Complexity: Amortized O(1)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }

    static class RecentCounter {
        private final Queue<Integer> queue = new ArrayDeque<>();

        public int ping(int t) {
            queue.offer(t);

            while (queue.peek() < t - 3000) {
                queue.poll();
            }

            return queue.size();
        }
    }
}

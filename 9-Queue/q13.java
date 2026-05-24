import java.util.ArrayDeque;
import java.util.Queue;

public class q13 {
    /*
     * Pattern: Queue / Sliding Time Window
     * Company Names: Bloomberg, Paytm
     * Difficulty: Medium
     *
     * LeetCode #362: Design Hit Counter
     *
     * Problem samajh lo:
     * Last 5 minutes yani 300 seconds ke hits count karne hain.
     *
     * Queue timestamps store karti hai.
     * Purane timestamps remove kar do.
     *
     * Time Complexity: Amortized O(1)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);
        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));
    }

    static class HitCounter {
        private final Queue<Integer> hits = new ArrayDeque<>();

        public void hit(int timestamp) {
            hits.offer(timestamp);
        }

        public int getHits(int timestamp) {
            while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
                hits.poll();
            }

            return hits.size();
        }
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

public class q21 {
    /*
     * Pattern: Monotonic Stack / Previous Greater
     * Company Names: Amazon, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #901: Online Stock Span
     *
     * Problem samajh lo:
     * Har naye stock price par span return karna hai.
     * Span = consecutive previous days count jahan price current se <= ho.
     *
     * Pair stack maintain karte hain:
     * [price, span]
     *
     * Time Complexity: amortized O(1) per next()
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100));
        System.out.println(spanner.next(80));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(70));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(75));
        System.out.println(spanner.next(85));
    }

    static class StockSpanner {
        private final Deque<int[]> stack = new ArrayDeque<>();

        public int next(int price) {
            int span = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }

            stack.push(new int[]{price, span});
            return span;
        }
    }
}

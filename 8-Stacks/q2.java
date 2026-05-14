import java.util.ArrayDeque;
import java.util.Queue;

public class q2 {
    /*
     * Pattern: Design / Stack using Queue
     * Company Names: TCS, Infosys
     * Difficulty: Easy
     *
     * LeetCode #225: Implement Stack using Queues
     *
     * Problem samajh lo:
     * Queue FIFO hoti hai, but humein stack LIFO behavior banana hai.
     *
     * Trick:
     * Push ke baad existing elements ko rotate kar do,
     * taaki naya element front par aa jaye.
     *
     * Time Complexity:
     * push = O(n)
     * pop/top = O(1)
     */
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    static class MyStack {
        private final Queue<Integer> queue = new ArrayDeque<>();

        public void push(int x) {
            queue.offer(x);

            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

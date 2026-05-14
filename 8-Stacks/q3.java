import java.util.ArrayDeque;
import java.util.Deque;

public class q3 {
    /*
     * Pattern: Design / Queue using Stacks
     * Company Names: TCS, Wipro
     * Difficulty: Easy
     *
     * LeetCode #232: Implement Queue using Stacks
     *
     * Problem samajh lo:
     * Queue FIFO hoti hai, but humein stack operations se queue banana hai.
     *
     * Two stack idea:
     * input stack me push hota hai.
     * Jab pop/peek chahiye aur output empty ho,
     * to input se sab elements output me transfer kar do.
     *
     * Time Complexity:
     * amortized O(1) per operation
     */
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

    static class MyQueue {
        private final Deque<Integer> input = new ArrayDeque<>();
        private final Deque<Integer> output = new ArrayDeque<>();

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            moveIfNeeded();
            return output.pop();
        }

        public int peek() {
            moveIfNeeded();
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }

        private void moveIfNeeded() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }
    }
}

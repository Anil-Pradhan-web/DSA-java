import java.util.ArrayDeque;
import java.util.Deque;

public class q1 {
    /*
     * Pattern: Queue using Stacks
     * Company Names: TCS, Wipro, Har Jagah
     * Difficulty: Easy
     *
     * LeetCode #232: Implement Queue using Stacks
     *
     * Problem samajh lo:
     * Stack LIFO hota hai, but humein FIFO queue behavior banana hai.
     *
     * Idea:
     * Do stacks use karo:
     * input stack me push karo.
     * output stack empty ho tab input se output me transfer karo.
     *
     * Time Complexity: Amortized O(1)
     * Space Complexity: O(n)
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

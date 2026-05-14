import java.util.ArrayDeque;
import java.util.Deque;

public class q4 {
    /*
     * Pattern: Design / Min Stack
     * Company Names: TCS, Cognizant, Amazon
     * Difficulty: Medium
     *
     * LeetCode #155: Min Stack
     *
     * Problem samajh lo:
     * Normal stack operations ke saath minimum value bhi O(1) me chahiye.
     *
     * Idea:
     * Ek normal stack aur ek min stack maintain karo.
     * Jab new min aaye to min stack me bhi push karo.
     *
     * Time Complexity: O(1) per operation
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    static class MinStack {
        private final Deque<Integer> stack = new ArrayDeque<>();
        private final Deque<Integer> minStack = new ArrayDeque<>();

        public void push(int val) {
            stack.push(val);

            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

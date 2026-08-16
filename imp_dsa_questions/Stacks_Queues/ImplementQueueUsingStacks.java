import java.util.Stack;

public class ImplementQueueUsingStacks {
    /*
     * LeetCode #232: Implement Queue using Stacks
     * Pattern: Two Stacks
     * Time: O(1) amortized, Space: O(n)
     */
    private Stack<Integer> input;
    private Stack<Integer> output;

    public ImplementQueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek()); // 1
        System.out.println("Pop: " + queue.pop()); // 1
        System.out.println("Empty: " + queue.empty()); // false
    }
}
import java.util.ArrayDeque;
import java.util.Deque;

public class q14 {
    /*
     * Pattern: Monotonic Stack
     * Company Names: Adobe, Bloomberg
     * Difficulty: Medium
     *
     * LeetCode #456: 132 Pattern
     *
     * Problem samajh lo:
     * Aisa pattern dhoondhna hai jahan i < j < k
     * aur nums[i] < nums[k] < nums[j].
     *
     * Reverse traversal + stack:
     * Stack possible '3' values maintain karti hai
     * aur second variable middle '2' candidate ko store karta hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int middle = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < middle) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                middle = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}

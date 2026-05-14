import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q17 {
    /*
     * Pattern: Monotonic Stack / Circular Array
     * Company Names: Amazon, Google
     * Difficulty: Medium
     *
     * LeetCode #503: Next Greater Element II
     *
     * Problem samajh lo:
     * Array circular hai, to next greater dhoondhte waqt wrap-around allowed hai.
     *
     * Trick:
     * 2*n traversal karo aur indices use karo.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;

            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                answer[stack.pop()] = nums[index];
            }

            if (i < n) {
                stack.push(index);
            }
        }

        return answer;
    }
}

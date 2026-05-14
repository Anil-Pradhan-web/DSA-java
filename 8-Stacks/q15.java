import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q15 {
    /*
     * Pattern: Monotonic Decreasing Stack
     * Company Names: Amazon, Google, Meta
     * Difficulty: Medium
     *
     * LeetCode #739: Daily Temperatures
     *
     * Problem samajh lo:
     * Har din ke liye next warmer day tak kitne din wait karna hai.
     *
     * Index stack use hoti hai.
     * Jab current temperature greater milta hai,
     * previous colder days resolve ho jaate hain.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }
}

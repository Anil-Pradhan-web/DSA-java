import java.util.ArrayDeque;
import java.util.Deque;

public class q18 {
    /*
     * Pattern: Monotonic Increasing Stack
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Hard
     *
     * LeetCode #84: Largest Rectangle in Histogram
     *
     * Problem samajh lo:
     * Histogram bars me largest possible rectangle area nikalna hai.
     *
     * Stack indices store karti hai.
     * Jab current height smaller milti hai,
     * to popped bar ka rectangle ab finalize ho jaata hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}

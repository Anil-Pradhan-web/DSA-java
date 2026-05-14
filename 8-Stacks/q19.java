public class q19 {
    /*
     * Pattern: Histogram + Stack
     * Company Names: Amazon, Microsoft
     * Difficulty: Hard
     *
     * LeetCode #85: Maximal Rectangle
     *
     * Problem samajh lo:
     * Binary matrix me 1s se bana largest rectangle area nikalna hai.
     *
     * Idea:
     * Har row ko histogram heights me convert karo.
     * Har row par Largest Rectangle in Histogram apply karo.
     *
     * Time Complexity: O(rows * cols)
     * Space Complexity: O(cols)
     */
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int answer = 0;

        for (char[] row : matrix) {
            for (int col = 0; col < cols; col++) {
                heights[col] = row[col] == '1' ? heights[col] + 1 : 0;
            }

            answer = Math.max(answer, largestRectangleArea(heights));
        }

        return answer;
    }

    private static int largestRectangleArea(int[] heights) {
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();
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

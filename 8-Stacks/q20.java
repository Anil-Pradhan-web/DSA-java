import java.util.ArrayDeque;
import java.util.Deque;

public class q20 {
    /*
     * Pattern: Monotonic Stack / Boundary
     * Company Names: Amazon, Google, Meta
     * Difficulty: Hard
     *
     * LeetCode #42: Trapping Rain Water
     *
     * Problem samajh lo:
     * Heights ke beech kitna paani trap hoga, wo calculate karna hai.
     *
     * Stack approach:
     * Valley bars ko resolve karte hain jab right boundary milti hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int width = i - left - 1;
                int boundedHeight = Math.min(height[i], height[left]) - height[bottom];
                water += width * boundedHeight;
            }

            stack.push(i);
        }

        return water;
    }
}

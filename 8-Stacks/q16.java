import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class q16 {
    /*
     * Pattern: Monotonic Stack / Next Greater
     * Company Names: Amazon, Microsoft
     * Difficulty: Easy
     *
     * LeetCode #496: Next Greater Element I
     *
     * Problem samajh lo:
     * nums2 me har element ka next greater nikalna hai,
     * phir nums1 ke according answer return karna hai.
     *
     * Monotonic decreasing stack se next greater map build kar sakte hain.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int value : nums2) {
            while (!stack.isEmpty() && value > stack.peek()) {
                nextGreater.put(stack.pop(), value);
            }
            stack.push(value);
        }

        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            answer[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return answer;
    }
}

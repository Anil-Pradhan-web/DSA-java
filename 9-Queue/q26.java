import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * Pattern: Monotonic Deque
 * Company Names: Amazon, Microsoft, Google
 * Difficulty: Hard
 *
 * Problem: Sliding Window Maximum
 * LeetCode: 239
 *
 * Hinglish Explanation:
 * Har window size k ka maximum element chahiye.
 * Brute force har window scan karega, O(n * k).
 *
 * Monotonic deque se O(n):
 * - Deque mein indices store karte hain.
 * - Values decreasing order mein maintain karte hain.
 * - Front par current window ka maximum index hota hai.
 *
 * Steps:
 * 1. Window se bahar index ko front se remove karo.
 * 2. Current value se choti values ko back se remove karo.
 * 3. Current index add karo.
 * 4. Window full hone ke baad front value answer hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */
public class q26 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Pattern: Sliding Window + Monotonic Deque
 * Company Names: Google
 * Difficulty: Medium
 *
 * Problem: Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * LeetCode: 1438
 *
 * Hinglish Explanation:
 * Hume longest subarray chahiye jisme max - min <= limit ho.
 *
 * Window ke max aur min ko fast track karne ke liye 2 deques use hote hain:
 * - maxDeque decreasing order maintain karta hai.
 * - minDeque increasing order maintain karta hai.
 *
 * Jab max - min limit se bada ho jaye, left pointer move karo.
 * Agar left pointer kisi deque ke front index ke barabar hai, usko remove karo.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class q28 {
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 7};
        System.out.println(longestSubarray(nums, 4)); // 2
    }
}

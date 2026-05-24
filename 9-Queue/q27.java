import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Pattern: Monotonic Deque + Dynamic Programming
 * Company Names: Google, Amazon
 * Difficulty: Medium
 *
 * Problem: Jump Game VI
 * LeetCode: 1696
 *
 * Hinglish Explanation:
 * Har index i par score nums[i] add hota hai.
 * Tum previous k indices mein se kisi ek se i par jump kar sakte ho.
 *
 * DP relation:
 * dp[i] = nums[i] + max(dp[j]) where j is in [i-k, i-1]
 *
 * Problem max dp[j] efficiently nikalne ka hai.
 * Monotonic deque dp values ke indices decreasing order mein maintain karta hai.
 * Deque ka front hamesha best previous index hota hai.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class q27 {
    public static int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();

        dp[0] = nums[0];
        deque.offerLast(0);

        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            dp[i] = nums[i] + dp[deque.peekFirst()];

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -2, 4, -7, 3};
        System.out.println(maxResult(nums, 2)); // 7
    }
}

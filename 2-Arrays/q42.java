import java.util.HashMap;
import java.util.Map;

public class q42 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Longest Zero Sum Subarray
     *
     * Problem samajh lo:
     * Humein longest contiguous subarray ki length nikalni hai
     * jiska sum 0 ho.
     *
     * Example:
     * nums = [15, -2, 2, -8, 1, 7, 10, 23]
     * Answer = 5
     *
     * Prefix sum idea:
     * Agar same prefix sum do jagah par repeat hota hai,
     * to unke beech ka subarray zero sum ka hota hai.
     *
     * Kyun?
     * Kyunki:
     * prefixSum(j) - prefixSum(i) = 0
     * matlab i + 1 se j tak ka sum zero hai
     *
     * HashMap me prefix sum ka first occurrence store karte hain
     * taaki maximum length mil sake.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Longest zero sum length = " + maxLen(nums));
    }

    public static int maxLen(int[] nums) {
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int prefixSum = 0;
        int best = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == 0) {
                best = i + 1;
            }

            if (firstIndex.containsKey(prefixSum)) {
                best = Math.max(best, i - firstIndex.get(prefixSum));
            } else {
                firstIndex.put(prefixSum, i);
            }
        }

        return best;
    }
}

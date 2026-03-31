import java.util.HashMap;
import java.util.Map;

public class q8 {
    /*
     * Pattern: Prefix Sum + HashMap
     * Company Names: Google, Amazon
     *
     * LeetCode #325: Longest Subarray with K Sum
     *
     * Problem samajh lo:
     * Humein longest contiguous subarray ki length nikalni hai jiska sum exactly k ho.
     *
     * Example:
     * nums = [1, -1, 5, -2, 3], k = 3
     * Answer = 4
     * Kyunki subarray [1, -1, 5, -2] ka sum 3 hai
     *
     * Sliding Window direct kyun nahi?
     * Sliding window tab best kaam karta hai jab saare numbers positive hon.
     * Yahan negative numbers bhi aa sakte hain,
     * isliye window expand-shrink logic reliable nahi rehta.
     *
     * Best approach:
     * Prefix sum use karo.
     * Agar current prefixSum = sum
     * aur humein k chahiye,
     * to humein dekhna hai ki kya prefixSum - k pehle kabhi aaya tha.
     *
     * Agar aaya tha,
     * to us previous index ke next se current index tak ka sum exactly k hoga.
     *
     * HashMap me prefix sum ka first occurrence store karte hain,
     * kyunki longest length ke liye earliest index chahiye hota hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println("Longest length = " + maxSubArrayLen(nums, k));
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int prefixSum = 0;
        int bestLength = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == k) {
                bestLength = i + 1;
            }

            if (firstIndex.containsKey(prefixSum - k)) {
                int length = i - firstIndex.get(prefixSum - k);
                bestLength = Math.max(bestLength, length);
            }

            firstIndex.putIfAbsent(prefixSum, i);
        }

        return bestLength;
    }
}

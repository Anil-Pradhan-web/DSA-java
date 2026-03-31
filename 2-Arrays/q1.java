import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1 {
    /*
     * Pattern: Two Pointers
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     *
     * LeetCode #1: Two Sum
     *
     * Problem samajh lo:
     * Humein array ke andar aise do numbers dhoondhne hain jinka sum target ke equal ho.
     * Return actual values nahi, unke indices karne hote hain.
     *
     * Example:
     * nums = [2, 7, 11, 15], target = 9
     * Answer = [0, 1] because nums[0] + nums[1] = 2 + 7 = 9
     *
     * Two Pointers direct kyun nahi lagate?
     * Simple two pointers sorted array me kaam karta hai, lekin is problem me original indices
     * preserve karne hote hain. Agar array sort kar diya to original positions lose ho sakti hain.
     * Isliye yahan HashMap best approach hoti hai.
     *
     * Optimized idea:
     * Har element ke liye check karo ki target - currentValue pehle kabhi aaya tha ya nahi.
     * Agar aaya hai to answer mil gaya.
     * Agar nahi aaya to current value ko map me store kar do.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] answer = twoSum(nums, target);
        System.out.println("Indices = " + Arrays.toString(answer));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (seen.containsKey(needed)) {
                return new int[]{seen.get(needed), i};
            }

            seen.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}

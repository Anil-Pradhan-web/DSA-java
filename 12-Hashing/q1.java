import java.util.HashMap;
import java.util.Map;

public class q1 {
    /*
     * Pattern: Hashing / HashMap
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Easy
     *
     * LeetCode #1: Two Sum
     *
     * Problem samajh lo:
     * Humein array me aise do numbers dhoondhne hain jinka sum target ke equal ho.
     * Return unke indices karne hote hain.
     *
     * Example:
     * nums = [2, 7, 11, 15], target = 9
     * Answer = [0, 1] because nums[0] + nums[1] = 2 + 7 = 9
     *
     * Best idea:
     * HashMap use karo jisme (value, index) store karo.
     * Har element ke liye check karo ki target - currentValue pehle aaya tha ya
     * nahi.
     * Agar aaya hai to answer mil gaya.
     * Agar nahi aaya to current value ko map me store kar do.
     *
     * Kyun HashMap?
     * Brute force O(n^2) me do loops lagte hain.
     * HashMap se O(1) lookup milta hai, isliye total O(n) ho jata hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices = [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (seen.containsKey(needed)) {
                return new int[] { seen.get(needed), i };
            }

            seen.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}
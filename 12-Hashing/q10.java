import java.util.HashSet;
import java.util.Set;

public class q10 {
    /*
     * Pattern: Hashing / HashSet
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Medium
     *
     * LeetCode #128: Longest Consecutive Sequence
     *
     * Problem samajh lo:
     * Humein array me sabse lambi consecutive sequence ki length nikalni hai.
     * Consecutive matlab numbers ek ke baad ek (1, 2, 3, 4...).
     * Order of array matter nahi karta.
     *
     * Example:
     * nums = [100, 4, 200, 1, 3, 2]
     * Answer = 4 (sequence: 1, 2, 3, 4)
     *
     * Best idea:
     * Step 1: Saare elements HashSet me daalo.
     * Step 2: Har element ke liye check karo ki kya wo sequence ka start hai.
     * Start hai agar (num - 1) set me nahi hai.
     * Step 3: Agar start hai, to aage badhte jao (num+1, num+2...) aur length count
     * karo.
     *
     * Kyun sirf start se check karte hain?
     * Agar (num - 1) set me hai, to num sequence ka start nahi hai.
     * Sirf starts se hi count karte hain taaki O(n) me ho jaye.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Longest consecutive = " + longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        // Step 1: Set me daalo
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2 & 3: Har element check karo
        for (int num : set) {
            // Sirf sequence ke start se hi count karo
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                // Aage badhte jao
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
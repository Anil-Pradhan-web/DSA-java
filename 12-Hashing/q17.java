import java.util.HashSet;
import java.util.Set;

public class q17 {
    /*
     * Pattern: Hashing / HashSet
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Hard
     *
     * LeetCode #41: First Missing Positive
     *
     * Problem samajh lo:
     * Humein unsorted array diya hai. Sabse chhota positive integer dhoondhna hai
     * jo array me missing hai.
     *
     * Example:
     * nums = [1, 2, 0]
     * Answer = 3 (1 aur 2 hain, 3 missing hai)
     *
     * nums = [3, 4, -1, 1]
     * Answer = 2 (1 hai, 2 missing hai)
     *
     * Best idea (HashSet approach):
     * Step 1: Saare positive numbers HashSet me daalo.
     * Step 2: 1 se start karke check karo ki kya wo set me hai.
     * Step 3: Jo pehla number set me nahi hai, wo answer hai.
     *
     * Kyun 1 se start?
     * Sabse chhota positive integer 1 hai. Isliye 1 se check karna shuru karo.
     * Answer hamesha 1 se n+1 ke beech me hoga.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 3, 4, -1, 1 };
        System.out.println("First missing positive = " + firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        // Step 1: Positive numbers set me daalo
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Step 2 & 3: 1 se check karo
        int missing = 1;
        while (set.contains(missing)) {
            missing++;
        }

        return missing;
    }
}
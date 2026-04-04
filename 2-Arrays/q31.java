import java.util.HashSet;
import java.util.Set;

public class q31 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Longest Consecutive Sequence
     *
     * Problem samajh lo:
     * Humein array me sabse lambi consecutive sequence ki length nikalni hai.
     * Consecutive ka matlab values continuous honi chahiye, order important nahi hai.
     *
     * Example:
     * nums = [100, 4, 200, 1, 3, 2]
     * Answer = 4
     * Sequence = [1, 2, 3, 4]
     *
     * Best idea:
     * HashSet me saare elements daal do taaki lookup fast ho.
     * Har number ke liye sirf tab sequence start karo jab uska previous number present na ho.
     *
     * Example:
     * 3 par sequence start nahi karenge agar 2 already present hai
     * 1 par sequence start karenge kyunki 0 present nahi hai
     *
     * Isse har sequence sirf ek baar count hoti hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive length = " + longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();

        for (int value : nums) {
            values.add(value);
        }

        int best = 0;

        for (int value : values) {
            if (!values.contains(value - 1)) {
                int current = value;
                int length = 1;

                while (values.contains(current + 1)) {
                    current++;
                    length++;
                }

                best = Math.max(best, length);
            }
        }

        return best;
    }
}

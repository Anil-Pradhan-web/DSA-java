import java.util.Arrays;

public class q4 {
    /*
     * Pattern: Sorting / Custom Comparator
     * Company Names: Infosys, Cognizant
     * Difficulty: Medium
     *
     * LeetCode #179: Largest Number
     *
     * Problem samajh lo:
     * Numbers ko aise arrange karna hai ki concatenate karne par sabse bada possible number bane.
     *
     * Example:
     * nums = [3, 30, 34, 5, 9]
     * Answer = "9534330"
     *
     * Comparator intuition:
     * Do numbers a aur b ke liye compare karo:
     * ab bada hai ya ba?
     * Jo combination lexicographically bada ho, us order ko prefer karo.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] values = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            values[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(values, (first, second) -> (second + first).compareTo(first + second));

        if (values[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String value : values) {
            answer.append(value);
        }

        return answer.toString();
    }
}

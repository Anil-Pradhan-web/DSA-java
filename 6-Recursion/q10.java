import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q10 {
    /*
     * Pattern: Backtracking / Subsets with Duplicates
     * Company Names: Amazon, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #90: Subsets II
     *
     * Problem samajh lo:
     * Input me duplicates ho sakte hain,
     * lekin output me duplicate subsets nahi aane chahiye.
     *
     * Trick:
     * Pehle array sort karo.
     * Same recursive level par duplicate elements skip karo.
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            backtrack(nums, i + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }
}

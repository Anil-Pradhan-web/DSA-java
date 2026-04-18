import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q13 {
    /*
     * Pattern: Backtracking / Permutations with Duplicates
     * Company Names: Amazon, Meta
     * Difficulty: Medium
     *
     * LeetCode #47: Permutations II
     *
     * Problem samajh lo:
     * Input me duplicates ho sakte hain,
     * lekin output me unique permutations hi chahiye.
     *
     * Trick:
     * Array sort karo.
     * Agar same number ka previous duplicate use nahi hua,
     * to current duplicate ko skip karo.
     *
     * Time Complexity: O(n * n!)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), answer);
        return answer;
    }

    private static void backtrack(
        int[] nums,
        boolean[] used,
        List<Integer> current,
        List<List<Integer>> answer
    ) {
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, answer);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

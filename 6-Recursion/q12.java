import java.util.ArrayList;
import java.util.List;

public class q12 {
    /*
     * Pattern: Backtracking / Permutations
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #46: Permutations
     *
     * Problem samajh lo:
     * Array ke saare possible orderings generate karne hain.
     *
     * Permutation me order matter karta hai,
     * isliye visited array maintain karte hain.
     *
     * Time Complexity: O(n * n!)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
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

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, answer);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q17 {
    /*
     * Pattern: Backtracking / Combination Sum
     * Company Names: Amazon, Google, Adobe
     * Difficulty: Medium
     *
     * LeetCode #39: Combination Sum
     *
     * Problem samajh lo:
     * Target sum banana hai aur same candidate ko multiple baar use kar sakte hain.
     *
     * Important:
     * Reuse allowed hai, isliye recursive call me same index dobara ja sakta hai.
     *
     * Time Complexity: Exponential
     * Space Complexity: O(target) recursion depth
     */
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private static void backtrack(
        int[] candidates,
        int target,
        int start,
        List<Integer> current,
        List<List<Integer>> answer
    ) {
        if (target == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, answer);
            current.remove(current.size() - 1);
        }
    }
}

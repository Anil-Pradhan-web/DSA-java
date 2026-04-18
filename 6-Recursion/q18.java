import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q18 {
    /*
     * Pattern: Backtracking / Combination Sum with Duplicates
     * Company Names: Amazon, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #40: Combination Sum II
     *
     * Problem samajh lo:
     * Target sum banana hai,
     * lekin har candidate ko sirf ek baar use kar sakte hain
     * aur duplicate answers nahi chahiye.
     *
     * Trick:
     * Array sort karo.
     * Same recursive level par duplicate values skip karo.
     *
     * Time Complexity: Exponential
     * Space Complexity: O(target) approx recursion depth
     */
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }
}

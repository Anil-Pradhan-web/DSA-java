import java.util.ArrayList;
import java.util.List;

public class q19 {
    /*
     * Pattern: Backtracking / Combination Sum III
     * Company Names: Google, Amazon
     * Difficulty: Medium
     *
     * LeetCode #216: Combination Sum III
     *
     * Problem samajh lo:
     * 1 se 9 tak ke numbers me se exactly k numbers choose karne hain
     * jinka sum n ho.
     *
     * Time Complexity: Exponential
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), answer);
        return answer;
    }

    private static void backtrack(int start, int k, int target, List<Integer> current, List<List<Integer>> answer) {
        if (current.size() == k && target == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        if (current.size() >= k || target < 0) {
            return;
        }

        for (int value = start; value <= 9; value++) {
            current.add(value);
            backtrack(value + 1, k, target - value, current, answer);
            current.remove(current.size() - 1);
        }
    }
}

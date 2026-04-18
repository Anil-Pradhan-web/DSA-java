import java.util.ArrayList;
import java.util.List;

public class q11 {
    /*
     * Pattern: Backtracking / Subsequences
     * Company Names: Google
     * Difficulty: Medium
     *
     * LeetCode #491: Non-decreasing Subsequences
     *
     * Problem samajh lo:
     * Saari subsequences nikalni hain jinki length at least 2 ho
     * aur values non-decreasing hon.
     *
     * Backtracking idea:
     * Current path maintain karo.
     * Same level par duplicate values avoid karne ke liye local used array use karo.
     *
     * Time Complexity: Exponential
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> answer) {
        if (current.size() >= 2) {
            answer.add(new ArrayList<>(current));
        }

        boolean[] used = new boolean[201];

        for (int i = start; i < nums.length; i++) {
            if (!current.isEmpty() && nums[i] < current.get(current.size() - 1)) {
                continue;
            }

            if (used[nums[i] + 100]) {
                continue;
            }

            used[nums[i] + 100] = true;
            current.add(nums[i]);
            backtrack(nums, i + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }
}

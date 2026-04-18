import java.util.ArrayList;
import java.util.List;

public class q9 {
    /*
     * Pattern: Backtracking / Subsets
     * Company Names: Amazon, Google, Meta
     * Difficulty: Medium
     *
     * LeetCode #78: Subsets
     *
     * Problem samajh lo:
     * Array ke saare possible subsets generate karne hain.
     *
     * Har element ke liye 2 choices hoti hain:
     * include karo ya skip karo.
     *
     * Backtracking me current subset ko build karte hain
     * aur har recursive level par next elements choose karte hain.
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) recursion
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }
}

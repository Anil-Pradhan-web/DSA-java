import java.util.ArrayList;
import java.util.List;

public class q16 {
    /*
     * Pattern: Backtracking / Combinations
     * Company Names: Google, Amazon
     * Difficulty: Medium
     *
     * LeetCode #77: Combinations
     *
     * Problem samajh lo:
     * 1 se n tak me se k numbers choose karke saari combinations return karni hain.
     *
     * Order matter nahi karta,
     * isliye start index maintain karte hain.
     *
     * Time Complexity: O(n choose k)
     * Space Complexity: O(k)
     */
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), answer);
        return answer;
    }

    private static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> answer) {
        if (current.size() == k) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int value = start; value <= n; value++) {
            current.add(value);
            backtrack(value + 1, n, k, current, answer);
            current.remove(current.size() - 1);
        }
    }
}

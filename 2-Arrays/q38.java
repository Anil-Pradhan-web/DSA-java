import java.util.ArrayList;
import java.util.List;

public class q38 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Find All Duplicates in an Array
     *
     * Problem samajh lo:
     * Array me numbers 1 se n range ke hote hain.
     * Kuch numbers ek ya do baar aa sakte hain.
     * Humein saare duplicate numbers return karne hain.
     *
     * Example:
     * nums = [4, 3, 2, 7, 8, 2, 3, 1]
     * Answer = [2, 3]
     *
     * Sign marking trick:
     * Har value x ke liye uske corresponding index x - 1 par jao.
     * Agar wahan already negative value hai,
     * matlab x pehle bhi aa chuka hai, so x duplicate hai.
     *
     * Agar positive hai, to usko negative bana do to mark visited.
     *
     * Yeh range-based array trick bahut common hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) extra, answer list ko chhodkar
     */
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for (int value : nums) {
            int index = Math.abs(value) - 1;

            if (nums[index] < 0) {
                answer.add(Math.abs(value));
            } else {
                nums[index] = -nums[index];
            }
        }

        return answer;
    }
}

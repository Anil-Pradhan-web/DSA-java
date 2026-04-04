import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q43 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: 4Sum
     *
     * Problem samajh lo:
     * Humein unique quadruplets dhoondhne hain jinka sum target ke equal ho.
     *
     * Example:
     * nums = [1, 0, -1, 0, -2, 2], target = 0
     * Answer = [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
     *
     * Best idea:
     * Array sort karo.
     * Pehle do numbers loops se fix karo.
     * Baaki do numbers ke liye two pointers use karo.
     *
     * Duplicate handling yahan bahut important hai:
     * warna same quadruplet multiple baar answer me aa jayega.
     *
     * Time Complexity: O(n^3)
     * Space Complexity: O(1) extra, answer list ko chhodkar
     */
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return answer;
    }
}

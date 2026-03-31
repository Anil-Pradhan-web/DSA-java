import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q3 {
    /*
     * Pattern: Two Pointers
     * Company Names: Meta, Amazon, Microsoft, Adobe
     *
     * LeetCode #15: 3Sum
     *
     * Problem samajh lo:
     * Humein array me aise unique triplets dhoondhne hain jinka total sum 0 ho.
     * Har triplet me 3 alag positions ke elements honge.
     *
     * Example:
     * nums = [-1, 0, 1, 2, -1, -4]
     * Answer = [[-1, -1, 2], [-1, 0, 1]]
     *
     * Two Pointers yahan kaise kaam karta hai?
     * Step 1: Array ko sort kar lo.
     * Step 2: Har index i ko first element maan lo.
     * Step 3: Baaki array par left aur right pointer chalao.
     *
     * Logic:
     * sum = nums[i] + nums[left] + nums[right]
     * Agar sum == 0, to ek valid triplet mil gaya.
     * Agar sum < 0, matlab sum chhota hai, left ko aage badhao.
     * Agar sum > 0, matlab sum bada hai, right ko peeche lao.
     *
     * Duplicate handling bahut important hai:
     * Same triplet baar-baar na aaye isliye
     * 1. i ke duplicates skip karte hain
     * 2. valid triplet milne ke baad left aur right ke duplicates bhi skip karte hain
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) extra space, sorting ke alawa
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> answer = threeSum(nums);
        System.out.println(answer);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}

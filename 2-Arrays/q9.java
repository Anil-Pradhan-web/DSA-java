import java.util.Arrays;

public class q9 {
    /*
     * Pattern: Prefix Sum / HashMap
     * Company Names: Amazon, Meta
     *
     * LeetCode #238: Product of Array Except Self
     *
     * Problem samajh lo:
     * Har index ke liye aisa answer banana hai jahan us index ka khud ka element
     * include na ho, sirf baaki saare elements ka product ho.
     *
     * Example:
     * nums = [1, 2, 3, 4]
     * Answer = [24, 12, 8, 6]
     *
     * Direct division kyun avoid karte hain?
     * Agar array me zero ho to division wala idea toot sakta hai.
     * Isliye interview aur LeetCode dono me preferred approach division ke bina hoti hai.
     *
     * Core idea:
     * Har index ke left side ka product alag socho
     * aur right side ka product alag socho.
     *
     * answer[i] = leftProductOfAllElementsBeforeI * rightProductOfAllElementsAfterI
     *
     * Step 1:
     * Ek pass me prefix product build karo.
     * answer[i] me store karo ki i ke left tak ka product kya hai.
     *
     * Step 2:
     * Reverse pass me suffix product maintain karo.
     * answer[i] ko suffix product se multiply kar do.
     *
     * Is tarah bina extra suffix array banaye kaam ho jata hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) extra, answer array ko chhodkar
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}

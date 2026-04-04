public class q39 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Missing Number
     *
     * Problem samajh lo:
     * Array me numbers 0 se n tak ke range me hote hain,
     * lekin ek number missing hota hai.
     * Humein wahi missing number dhoondhna hai.
     *
     * Example:
     * nums = [3, 0, 1]
     * Answer = 2
     *
     * XOR idea:
     * Index aur value dono ko XOR kar do.
     * Same numbers cancel ho jayenge
     * aur end me missing number bachega.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println("Missing number = " + missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int answer = nums.length;

        for (int i = 0; i < nums.length; i++) {
            answer ^= i;
            answer ^= nums[i];
        }

        return answer;
    }
}

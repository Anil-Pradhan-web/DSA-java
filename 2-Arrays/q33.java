public class q33 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Single Number
     *
     * Problem samajh lo:
     * Array me har number do baar aata hai except ek number jo sirf ek baar aata hai.
     * Humein wahi single number return karna hai.
     *
     * Example:
     * nums = [4, 1, 2, 1, 2]
     * Answer = 4
     *
     * Best idea:
     * XOR use karo.
     *
     * XOR properties:
     * x ^ x = 0
     * x ^ 0 = x
     *
     * Isliye jo numbers pair me aate hain wo cancel ho jaate hain,
     * aur jo single number hai wahi end me bachta hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Single number = " + singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int answer = 0;

        for (int value : nums) {
            answer ^= value;
        }

        return answer;
    }
}

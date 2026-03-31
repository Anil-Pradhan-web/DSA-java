public class q25 {
    /*
     * Pattern: Matrix / 2D Array
     * Company Names: Amazon, Meta, Google
     *
     * LeetCode #55: Jump Game
     *
     * Problem samajh lo:
     * Array me har index par maximum jump length di hui hai.
     * Humein check karna hai ki kya hum last index tak pahunch sakte hain ya nahi.
     *
     * Example:
     * nums = [2, 3, 1, 1, 4]
     * Answer = true
     *
     * Greedy intuition:
     * Har index par yeh socho ki ab tak hum sabse door kitni position tak pahunch sakte hain.
     *
     * Variable:
     * farthest = ab tak reachable maximum index
     *
     * Agar kabhi aisa ho jaye ki current index > farthest,
     * iska matlab hum us index tak pahunch hi nahi sakte,
     * to answer false hoga.
     *
     * Har valid index par:
     * farthest = max(farthest, i + nums[i])
     *
     * Agar farthest last index tak ya usse aage pahunch gaya,
     * to answer true hai.
     *
     * Is problem me best move actual jumps count karna nahi,
     * balki reachable range ko continuously expand karna hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);

            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}

public class q2 {
    /*
     * Pattern: Two Pointers
     * Company Names: Amazon, Meta, Bloomberg, Google
     *
     * LeetCode #11: Container With Most Water
     *
     * Problem samajh lo:
     * Har index par ek vertical line di gayi hai. Do lines choose karke beech me jo container banega,
     * usme maximum kitna paani store ho sakta hai wo nikalna hai.
     *
     * Area formula:
     * area = min(leftHeight, rightHeight) * (right - left)
     *
     * Two Pointers intuition:
     * Hum left pointer start se aur right pointer end se rakhte hain.
     * Ab jo line chhoti hai, wahi area ko limit kar rahi hoti hai.
     * Isliye bada answer paane ke liye humein chhoti wall ko move karna chahiye,
     * kyunki badi wall ko move karne se width bhi kam hogi aur limiting height bhi improve nahi hogi.
     *
     * Example:
     * height = [1,8,6,2,5,4,8,3,7]
     * Maximum area = 49
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum water = " + maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int best = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;

            best = Math.max(best, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return best;
    }
}

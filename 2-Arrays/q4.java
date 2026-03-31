public class q4 {
    /*
     * Pattern: Two Pointers
     * Company Names: Amazon, Google, Microsoft
     *
     * LeetCode #42: Trapping Rain Water
     *
     * Problem samajh lo:
     * Har index par building ki height di hui hai. Baarish ke baad in buildings ke beech
     * kitna paani trap hoga, wo calculate karna hai.
     *
     * Core observation:
     * Kisi bhi index par trapped water depend karta hai:
     * min(leftMax, rightMax) - currentHeight
     *
     * Yani us index ke left side ki highest wall aur right side ki highest wall me se
     * jo chhoti hai, wahi water level decide karegi.
     *
     * Two Pointers intuition:
     * left aur right dono ends se start karo.
     * leftMax = ab tak left side ki sabse badi height
     * rightMax = ab tak right side ki sabse badi height
     *
     * Agar height[left] <= height[right]:
     * to left side sure hai ki right me usse badi ya equal wall maujood hai,
     * isliye left index ka answer safely leftMax ke basis par decide kar sakte hain.
     *
     * Warna right side ko process karo.
     *
     * Example:
     * height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Answer = 6
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water = " + trap(height));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}

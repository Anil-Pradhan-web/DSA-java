public class q46 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Rain Water Variation - Prefix Max and Suffix Max Approach
     *
     * Problem samajh lo:
     * Ye Trapping Rain Water ka ek alternate approach hai.
     * Har index par trapped water depend karta hai:
     * min(leftMax, rightMax) - height[i]
     *
     * Is variation me two pointers ke bajay
     * prefix max aur suffix max arrays build kiye jaate hain.
     *
     * Example:
     * height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
     * Answer = 6
     *
     * Steps:
     * 1. leftMax array banao jahan har index tak left side ki highest wall store ho
     * 2. rightMax array banao jahan har index tak right side ki highest wall store ho
     * 3. Har index ke liye water nikalo using min(leftMax, rightMax) - current height
     *
     * Ye approach conceptually easy hoti hai
     * aur interview me theory explain karne ke liye achhi hoti hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water = " + trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }
}

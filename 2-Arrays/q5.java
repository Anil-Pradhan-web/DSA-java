public class q5 {
    /*
     * Pattern: Sliding Window
     * Company Names: Amazon, Meta, Microsoft
     *
     * LeetCode #121: Best Time to Buy and Sell Stock
     *
     * Problem samajh lo:
     * Humein prices array diya hota hai jahan prices[i] ka matlab hai kisi din ka stock price.
     * Ek baar buy aur ek baar sell karna hai, aur maximum profit nikalna hai.
     * Sell hamesha buy ke baad hi hona chahiye.
     *
     * Example:
     * prices = [7, 1, 5, 3, 6, 4]
     * Best profit = 5
     * Buy at 1 and sell at 6
     *
     * Sliding Window intuition:
     * Yahan left pointer buy day ko represent karta hai
     * aur right pointer sell day ko represent karta hai.
     *
     * Agar current sell price buy price se bada hai,
     * to profit calculate karo aur maximum update karo.
     *
     * Agar current sell price buy price se chhota ya equal hai,
     * to better buy day mil gaya, isliye left ko right par le aao.
     *
     * Is problem me actual subarray nahi ban raha,
     * lekin ek moving window ke through hum best buy-sell pair track kar rahe hain.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit = " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int left = 0;
        int bestProfit = 0;

        for (int right = 1; right < prices.length; right++) {
            if (prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                bestProfit = Math.max(bestProfit, profit);
            } else {
                left = right;
            }
        }

        return bestProfit;
    }
}

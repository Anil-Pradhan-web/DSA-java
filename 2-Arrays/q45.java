public class q45 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Maximum Points You Can Obtain from Cards
     *
     * Problem samajh lo:
     * Array ke left ya right end se total k cards pick kar sakte ho.
     * Humein maximum score nikalna hai.
     *
     * Example:
     * cardPoints = [1, 2, 3, 4, 5, 6, 1], k = 3
     * Answer = 12
     *
     * Smart observation:
     * Directly k cards choose karne ke bajay,
     * socho ki total array me se ek continuous middle subarray chhodna hai
     * jiska size n - k hoga.
     *
     * Fir:
     * answer = totalSum - minimumSubarraySumOfSize(n - k)
     *
     * Kyunki hum left aur right se hi cards le rahe hain,
     * matlab beech ka kuch continuous part hi untouched rahega.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println("Maximum score = " + maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        if (k == n) {
            int total = 0;
            for (int point : cardPoints) {
                total += point;
            }
            return total;
        }

        int totalSum = 0;
        for (int point : cardPoints) {
            totalSum += point;
        }

        int windowSize = n - k;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        return totalSum - minWindowSum;
    }
}

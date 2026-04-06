public class q21 {
    /*
     * Pattern: Binary Search on Answer
     * Company Names: Amazon, Google
     *
     * LeetCode #875: Koko Eating Bananas
     *
     * Problem samajh lo:
     * Koko ko saare banana piles h hours ke andar finish karne hain.
     * Humein minimum eating speed dhoondhni hai.
     *
     * Ye "minimum feasible answer" problem hai.
     * Candidate answer = per hour eating speed
     *
     * Agar given speed par total required hours <= h hain,
     * to speed feasible hai.
     *
     * Time Complexity: O(n log(maxPile))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private static boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }

        return hours <= h;
    }
}

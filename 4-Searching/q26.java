public class q26 {
    /*
     * Pattern: Binary Search on Answer
     * Company Names: Flipkart, Amazon
     *
     * Problem: Aggressive Cows
     *
     * Problem samajh lo:
     * Humein cows ko stalls me aise place karna hai
     * ki minimum distance between any two cows maximum ho.
     *
     * Ye "maximum minimize" type problem hai.
     * Candidate answer = minimum required distance
     *
     * Agar given distance par saari cows place ho sakti hain,
     * to shayad aur badi distance bhi possible ho.
     *
     * Time Complexity: O(n log(range))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;
        System.out.println(aggressiveCows(stalls, cows));
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        java.util.Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, cows, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private static boolean canPlace(int[] stalls, int cows, int distance) {
        int count = 1;
        int lastPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= distance) {
                count++;
                lastPlaced = stalls[i];
            }
        }

        return count >= cows;
    }
}

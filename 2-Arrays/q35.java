import java.util.Arrays;

public class q35 {
    /*
     * Pattern: Additional Important Array Problems
     * Company Names: Not specified in your list
     *
     * Problem: Candy
     *
     * Problem samajh lo:
     * Har child ko kam se kam 1 candy deni hai.
     * Aur agar kisi child ki rating uske neighbor se zyada hai,
     * to usko us neighbor se zyada candies milni chahiye.
     *
     * Humein minimum total candies nikalni hain.
     *
     * Example:
     * ratings = [1, 0, 2]
     * Answer = 5
     *
     * Two-pass idea:
     * Left se right pass me ensure karo ki increasing ratings left neighbor rule satisfy karein.
     * Right se left pass me ensure karo ki right neighbor rule bhi satisfy ho.
     *
     * Dono directions important hain,
     * kyunki sirf ek pass se dono side ka comparison cover nahi hota.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println("Minimum candies = " + candy(ratings));
    }

    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int candy : candies) {
            total += candy;
        }

        return total;
    }
}

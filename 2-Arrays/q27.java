public class q27 {
    /*
     * Pattern: Important Problems Jo List Mein Nahi The
     * Company Names: Amazon, Adobe, Google
     *
     * LeetCode #169: Majority Element
     *
     * Problem samajh lo:
     * Humein aisa element dhoondhna hai jo array me n / 2 se zyada baar aata ho.
     * Question guarantee karta hai ki majority element exist karta hai.
     *
     * Example:
     * nums = [2, 2, 1, 1, 1, 2, 2]
     * Answer = 2
     *
     * Best approach:
     * Boyer-Moore Voting Algorithm
     *
     * Intuition:
     * Majority element itna zyada repeat hota hai ki
     * baaki elements ke against cancel hone ke baad bhi akhir me wahi bachega.
     *
     * Hum 2 cheezein maintain karte hain:
     * 1. candidate
     * 2. count
     *
     * Rules:
     * Agar count 0 ho jaye, current element ko candidate bana do
     * Agar current element candidate ke equal ho, count badhao
     * Warna count ghatao
     *
     * Cancellation logic:
     * Different elements ek doosre ko cancel karte rehte hain
     * aur majority element akhir tak survive karta hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority element = " + majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int value : nums) {
            if (count == 0) {
                candidate = value;
            }

            if (value == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}

import java.util.HashSet;
import java.util.Set;

public class q2 {
    /*
     * Pattern: Hashing / HashSet
     * Company Names: Amazon, Google, Meta, Microsoft, Apple
     * Difficulty: Easy
     *
     * LeetCode #217: Contains Duplicate
     *
     * Problem samajh lo:
     * Humein array me check karna hai ki koi element duplicate hai ya nahi.
     * Agar koi element ek se zyada baar aata hai to true return karo.
     *
     * Example:
     * nums = [1, 2, 3, 1]
     * Answer = true (1 do baar aata hai)
     *
     * nums = [1, 2, 3, 4]
     * Answer = false (sab unique hain)
     *
     * Best idea:
     * HashSet use karo — ye automatically duplicates reject karta hai.
     * Har element ko add karte jao.
     * Agar add() false return kare, matlab element pehle se tha — duplicate mil
     * gaya.
     *
     * Kyun HashSet?
     * Brute force O(n^2) me har element ko baaki sabse compare karna padta.
     * HashSet ke add() ka O(1) average time hota hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println("Contains duplicate = " + containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // add() false return kare to duplicate mil gaya
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
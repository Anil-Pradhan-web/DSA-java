import java.util.HashSet;
import java.util.Set;

public class q29 {
    /*
     * Pattern: Important Problems Jo List Mein Nahi The
     * Company Names: Amazon, Google, Apple
     *
     * LeetCode #217: Contains Duplicate
     *
     * Problem samajh lo:
     * Humein check karna hai ki array me koi bhi value ek se zyada baar aati hai ya nahi.
     *
     * Example:
     * nums = [1, 2, 3, 1]
     * Answer = true
     *
     * HashSet approach:
     * Traverse karte jao aur har element ko set me daalte jao.
     * Agar koi element pehle se set me mil gaya,
     * matlab duplicate present hai.
     *
     * Why HashSet?
     * Set unique values store karta hai,
     * isliye duplicate detect karna fast ho jaata hai.
     *
     * Alternative:
     * Sorting se bhi solve ho sakta hai,
     * lekin HashSet approach simple aur linear time me ho jaati hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int value : nums) {
            if (!seen.add(value)) {
                return true;
            }
        }

        return false;
    }
}

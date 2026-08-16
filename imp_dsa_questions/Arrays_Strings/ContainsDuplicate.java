import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /*
     * LeetCode #217: Contains Duplicate
     * Pattern: HashSet
     * Time: O(n), Space: O(n)
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println("Contains duplicate: " + containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
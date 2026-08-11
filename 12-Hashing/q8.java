import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q8 {
    /*
     * Pattern: Hashing / Frequency Count
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Easy
     *
     * LeetCode #350: Intersection of Two Arrays II
     *
     * Problem samajh lo:
     * Humein do arrays diye hain. Common elements dhoondhne hain
     * jisme duplicates ka bhi count maintain hota hai.
     *
     * Example:
     * nums1 = [1, 2, 2, 1], nums2 = [2, 2]
     * Answer = [2, 2] (dono '2' common hain)
     *
     * nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
     * Answer = [4, 9] (order koi bhi ho sakta hai)
     *
     * Best idea:
     * Step 1: Pehle array ki frequency HashMap me count karo.
     * Step 2: Dusre array me har element check karo.
     * Step 3: Agar element map me hai aur frequency > 0, to common hai.
     * Frequency decrement karo aur result me add karo.
     *
     * Kyun HashMap?
     * Duplicates ka count track karna hai, isliye set nahi map use karna hai.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(min(n, m))
     */
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] result = intersect(nums1, nums2);

        System.out.print("Intersection = ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // Step 1: Pehle array ki frequency
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2 & 3: Common elements dhoondo
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        // List to array
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
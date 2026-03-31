import java.util.HashMap;
import java.util.Map;

public class q10 {
    /*
     * Pattern: Prefix Sum / HashMap
     * Company Names: Facebook, Google, Microsoft
     *
     * LeetCode #560: Subarray Sum Equals K
     *
     * Problem samajh lo:
     * Humein count nikalna hai ki kitne contiguous subarrays ka sum exactly k ke equal hai.
     *
     * Example:
     * nums = [1, 1, 1], k = 2
     * Answer = 2
     * Valid subarrays: [1,1] at indices (0,1) and (1,2)
     *
     * Prefix sum idea:
     * Agar current prefixSum = sum
     * aur humein k chahiye,
     * to humein dekhna hai ki kya pehle kabhi prefixSum - k aaya tha.
     *
     * Kyun?
     * Kyunki agar
     * currentPrefixSum - oldPrefixSum = k
     * to old index ke next se current index tak ka subarray sum k hoga.
     *
     * HashMap me kya store karte hain?
     * Prefix sum kitni baar aaya hai, uski frequency.
     *
     * Special initialization:
     * map.put(0, 1)
     * Iska matlab empty prefix ek baar mana ja raha hai,
     * taaki agar starting se hi sum k ban raha ho to wo bhi count ho jaye.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Count = " + subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int prefixSum = 0;
        int answer = 0;

        for (int value : nums) {
            prefixSum += value;

            if (prefixCount.containsKey(prefixSum - k)) {
                answer += prefixCount.get(prefixSum - k);
            }

            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return answer;
    }
}

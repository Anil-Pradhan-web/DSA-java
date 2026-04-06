import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q11 {
    /*
     * Pattern: Sorting / Bucket Frequency
     * Company Names: Amazon, Uber, FB
     * Difficulty: Medium
     *
     * LeetCode #347: Top K Frequent Elements
     *
     * Problem samajh lo:
     * Array me sabse zyada frequent k elements return karne hain.
     *
     * Bucket idea:
     * Frequency map banao.
     * Frequency ke hisaab se buckets banao.
     * Highest frequency se elements uthate jao jab tak k answer na mil jaye.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] answer = topKFrequent(nums, k);

        for (int value : answer) {
            System.out.print(value + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int value : nums) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(entry.getKey());
        }

        int[] answer = new int[k];
        int index = 0;

        for (int count = buckets.length - 1; count >= 0 && index < k; count--) {
            if (buckets[count] != null) {
                for (int value : buckets[count]) {
                    answer[index++] = value;
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return answer;
    }
}

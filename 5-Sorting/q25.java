import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q25 {
    /*
     * Pattern: Custom Sorting / Frequency Sort
     * Company Names: Amazon, Adobe
     *
     * LeetCode #1636: Sort Array by Increasing Frequency
     *
     * Problem samajh lo:
     * Array ko frequency ke increasing order me sort karna hai.
     * Agar do numbers ki frequency same ho,
     * to larger number pehle aana chahiye.
     *
     * Comparator based sorting ka strong example hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int value : nums) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        Integer[] boxed = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            boxed[i] = nums[i];
        }

        Arrays.sort(boxed, (first, second) -> {
            int freqCompare = Integer.compare(freq.get(first), freq.get(second));
            if (freqCompare != 0) {
                return freqCompare;
            }
            return Integer.compare(second, first);
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxed[i];
        }

        return nums;
    }
}

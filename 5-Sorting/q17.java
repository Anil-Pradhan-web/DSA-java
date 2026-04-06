import java.util.Arrays;

public class q17 {
    /*
     * Pattern: Sorting / Bucket Strategy
     * Company Names: Amazon, Google
     * Difficulty: Hard
     *
     * LeetCode #164: Maximum Gap
     *
     * Problem samajh lo:
     * Sorted order me adjacent elements ke beech ka maximum difference nikalna hai,
     * but direct full sort ke bina linear-ish idea samajhna important hai.
     *
     * Pigeonhole intuition:
     * Maximum gap actual elements ke andar nahi,
     * buckets ke beech milega.
     *
     * Har bucket me sirf min aur max maintain karte hain.
     * Final answer consecutive non-empty buckets ke beech niklega.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGap(nums));
    }

    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];

        for (int value : nums) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        if (min == max) {
            return 0;
        }

        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] used = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int value : nums) {
            int bucket = (value - min) / bucketSize;
            bucketMin[bucket] = Math.min(bucketMin[bucket], value);
            bucketMax[bucket] = Math.max(bucketMax[bucket], value);
            used[bucket] = true;
        }

        int answer = 0;
        int previous = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!used[i]) {
                continue;
            }
            answer = Math.max(answer, bucketMin[i] - previous);
            previous = bucketMax[i];
        }

        return answer;
    }
}

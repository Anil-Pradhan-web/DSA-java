public class q20 {
    /*
     * Pattern: Binary Search on Answer
     * Company Names: Google, Meta, Amazon
     * Difficulty: Hard
     *
     * LeetCode #410: Split Array Largest Sum
     *
     * Problem samajh lo:
     * Array ko k non-empty continuous parts me split karna hai.
     * Humein aisa split chahiye jisme largest subarray sum minimum ho.
     *
     * Ye classic "minimum maximize" problem hai.
     *
     * Binary search on answer:
     * Candidate answer = allowed maximum subarray sum
     *
     * Feasibility:
     * Check karo ki given max sum ke andar array ko at most k parts me split kar sakte hain ya nahi.
     *
     * Search space:
     * low = largest element
     * high = total sum
     *
     * Time Complexity: O(n log(sum))
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int value : nums) {
            low = Math.max(low, value);
            high += value;
        }

        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private static boolean canSplit(int[] nums, int k, int maxAllowed) {
        int parts = 1;
        int currentSum = 0;

        for (int value : nums) {
            if (currentSum + value > maxAllowed) {
                parts++;
                currentSum = value;
            } else {
                currentSum += value;
            }
        }

        return parts <= k;
    }
}

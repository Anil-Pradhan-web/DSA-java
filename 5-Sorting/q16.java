import java.util.ArrayList;
import java.util.List;

public class q16 {
    /*
     * Pattern: Sorting / Merge Sort Counting
     * Company Names: Google, Amazon
     * Difficulty: Hard
     *
     * LeetCode #315: Count of Smaller Numbers After Self
     *
     * Problem samajh lo:
     * Har element ke right side me kitne smaller elements hain, wo count karna hai.
     *
     * Brute force O(n^2) hota hai.
     * Efficient approach me merge sort use karte hain.
     *
     * Merge ke time:
     * Jab right half ka smaller element left half ke element se pehle aata hai,
     * to left element ke count me contribution hota hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] indices = new int[n];
        int[] temp = new int[n];
        int[] counts = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(nums, indices, temp, counts, 0, n - 1);

        List<Integer> answer = new ArrayList<>();
        for (int count : counts) {
            answer.add(count);
        }

        return answer;
    }

    private static void mergeSort(int[] nums, int[] indices, int[] temp, int[] counts, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, temp, counts, left, mid);
        mergeSort(nums, indices, temp, counts, mid + 1, right);
        merge(nums, indices, temp, counts, left, mid, right);
    }

    private static void merge(int[] nums, int[] indices, int[] temp, int[] counts, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                temp[k++] = indices[j++];
                rightCount++;
            } else {
                counts[indices[i]] += rightCount;
                temp[k++] = indices[i++];
            }
        }

        while (i <= mid) {
            counts[indices[i]] += rightCount;
            temp[k++] = indices[i++];
        }

        while (j <= right) {
            temp[k++] = indices[j++];
        }

        for (int index = left; index <= right; index++) {
            indices[index] = temp[index];
        }
    }
}

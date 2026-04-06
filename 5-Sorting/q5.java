import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q5 {
    /*
     * Pattern: Sorting / Custom Order
     * Company Names: Wipro, Capgemini
     * Difficulty: Easy
     *
     * LeetCode #1122: Relative Sort Array
     *
     * Problem samajh lo:
     * arr1 ko arr2 ke order ke hisaab se sort karna hai.
     * Jo elements arr2 me nahi hain, unhe end me ascending order me rakhna hai.
     *
     * Clean idea:
     * arr2 values ka rank map bana lo.
     * Fir arr1 ko custom comparator se sort karo.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(m)
     */
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> rank = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            rank.put(arr2[i], i);
        }

        Integer[] boxed = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            boxed[i] = arr1[i];
        }

        Arrays.sort(boxed, (first, second) -> {
            boolean firstIn = rank.containsKey(first);
            boolean secondIn = rank.containsKey(second);

            if (firstIn && secondIn) {
                return Integer.compare(rank.get(first), rank.get(second));
            }
            if (firstIn) {
                return -1;
            }
            if (secondIn) {
                return 1;
            }
            return Integer.compare(first, second);
        });

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = boxed[i];
        }

        return arr1;
    }
}

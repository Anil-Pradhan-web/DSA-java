import java.util.Arrays;

public class q18 {
    /*
     * Pattern: Sorting
     * Company Names: Google, Amazon
     * Difficulty: Medium
     *
     * LeetCode #274: H-Index
     *
     * Problem samajh lo:
     * H-index ka matlab:
     * maximum h aisa ho jahan kam se kam h papers ke citations h ya usse zyada hon.
     *
     * Sorting approach:
     * Citations ko ascending order me sort karo.
     * Har position par dekhte hain kitne papers right side me bache hain.
     *
     * Agar citations[i] >= papersOnRight,
     * to answer candidate mil gaya.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: depends on sort
     */
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int papers = n - i;
            if (citations[i] >= papers) {
                return papers;
            }
        }

        return 0;
    }
}

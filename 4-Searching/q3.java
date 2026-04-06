public class q3 {
    /*
     * Pattern: Binary Search
     * Company Names: Infosys, Cognizant
     * Difficulty: Easy
     *
     * LeetCode #278: First Bad Version
     *
     * Problem samajh lo:
     * Versions 1 se n tak hain aur ek point ke baad saari versions bad ho jaati hain.
     * Humein first bad version dhoondhni hai.
     *
     * Important monotonic pattern:
     * false false false true true true
     *
     * Isliye ye exact binary search nahi,
     * balki first true type boundary binary search hai.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private static final int FIRST_BAD = 4;

    public static void main(String[] args) {
        int n = 8;
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int answer = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private static boolean isBadVersion(int version) {
        return version >= FIRST_BAD;
    }
}

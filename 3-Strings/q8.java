public class q8 {
    /*
     * Pattern: Strings
     * Company Names: TCS, Wipro
     *
     * LeetCode #28: Implement strStr()
     *
     * Problem samajh lo:
     * Humein haystack string ke andar needle string ki first occurrence ka index return karna hai.
     * Agar needle present nahi ho to -1 return karna hai.
     *
     * Example:
     * haystack = "sadbutsad", needle = "sad"
     * Answer = 0
     *
     * Naive matching idea:
     * Haystack ke har possible starting point par needle ko compare karo.
     * Jahan poora needle match ho jaye, wahi index answer hai.
     *
     * Yeh simplest pattern matching approach hai.
     *
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;

            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}

public class q4 {
    /*
     * Pattern: Strings
     * Company Names: Wipro, TCS
     *
     * LeetCode #14: Longest Common Prefix
     *
     * Problem samajh lo:
     * Humein string array me sab strings ka common starting part nikalna hai.
     *
     * Example:
     * strs = ["flower", "flow", "flight"]
     * Answer = "fl"
     *
     * Horizontal shrinking idea:
     * Pehli string ko prefix maan lo.
     * Phir har next string ke saath compare karo.
     * Jab tak current string us prefix se start nahi karti,
     * prefix ko chhota karte jao.
     *
     * Jis moment prefix empty ho gaya,
     * answer empty string hoga.
     *
     * Time Complexity: O(n * m)
     * Space Complexity: O(1) extra
     * yahan n = strings count, m = prefix length
     */
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}

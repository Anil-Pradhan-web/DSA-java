import java.util.Arrays;

public class q6 {
    /*
     * Pattern: Sorting / String Comparison
     * Company Names: TCS, Cognizant
     * Difficulty: Easy
     *
     * LeetCode #242: Valid Anagram
     *
     * Problem samajh lo:
     * Do strings anagram tab hoti hain jab sort karne ke baad same ban jaayein.
     *
     * Sorting-based approach:
     * Dono strings ke characters sort karo aur compare karo.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);

        return Arrays.equals(first, second);
    }
}

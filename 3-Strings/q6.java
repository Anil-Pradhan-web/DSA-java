public class q6 {
    /*
     * Pattern: Strings
     * Company Names: Cognizant, TCS
     *
     * LeetCode #242: Valid Anagram
     *
     * Problem samajh lo:
     * Do strings anagram tab hoti hain jab unme same characters
     * same frequencies ke saath present hon.
     *
     * Example:
     * s = "anagram", t = "nagaram"
     * Answer = true
     *
     * Frequency idea:
     * Agar sirf lowercase English letters hain,
     * to size 26 ka frequency array enough hota hai.
     *
     * Ek string ke letters count badhao
     * aur doosri ke count ghatao.
     * End me sab frequencies zero honi chahiye.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
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

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

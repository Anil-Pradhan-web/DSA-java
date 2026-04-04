import java.util.ArrayList;
import java.util.List;

public class q17 {
    /*
     * Pattern: Strings
     * Company Names: Adobe, Flipkart
     *
     * LeetCode #438: Find All Anagrams in a String
     *
     * Problem samajh lo:
     * Humein text string me pattern string ke saare anagram starting indices return karne hain.
     *
     * Example:
     * s = "cbaebabacd", p = "abc"
     * Answer = [0, 6]
     *
     * Sliding window idea:
     * Pattern ki frequency count banao.
     * Text me size `p.length()` ki window chalao.
     * Har window ki frequency compare karo.
     *
     * Agar frequencies same hain,
     * to current window ek anagram hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * assuming lowercase English letters
     */
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();

        if (p.length() > s.length()) {
            return answer;
        }

        int[] target = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }

        if (matches(target, window)) {
            answer.add(0);
        }

        for (int right = p.length(); right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;
            window[s.charAt(right - p.length()) - 'a']--;

            if (matches(target, window)) {
                answer.add(right - p.length() + 1);
            }
        }

        return answer;
    }

    private static boolean matches(int[] first, int[] second) {
        for (int i = 0; i < 26; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }
}

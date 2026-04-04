import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q12 {
    /*
     * Pattern: Strings
     * Company Names: Adobe, Atlassian
     *
     * LeetCode #49: Group Anagrams
     *
     * Problem samajh lo:
     * Humein strings ko aise groups me rakhna hai jahan same group ki sab strings
     * ek doosre ki anagrams hon.
     *
     * Example:
     * strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * Answer = [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
     *
     * Best idea:
     * Har string ka ek canonical form banao.
     * Sabse common canonical form hota hai sorted version of string.
     *
     * Agar do strings sort hone ke baad same ban rahi hain,
     * to wo anagrams hain aur same group me jayengi.
     *
     * Time Complexity: O(n * k log k)
     * yahan k average string length hai
     * Space Complexity: O(n * k)
     */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);
        }

        return new ArrayList<>(groups.values());
    }
}

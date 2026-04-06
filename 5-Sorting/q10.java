import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q10 {
    /*
     * Pattern: Sorting / Frequency
     * Company Names: Amazon, Adobe
     * Difficulty: Medium
     *
     * LeetCode #451: Sort Characters by Frequency
     *
     * Problem samajh lo:
     * String ko aise reorder karna hai ki higher frequency wale characters pehle aayein.
     *
     * Frequency map banao, phir unique characters ko frequency ke descending order me sort karo.
     *
     * Time Complexity: O(n log k)
     * yahan k = unique characters
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(freq.keySet());
        chars.sort((first, second) -> Integer.compare(freq.get(second), freq.get(first)));

        StringBuilder answer = new StringBuilder();
        for (char ch : chars) {
            for (int i = 0; i < freq.get(ch); i++) {
                answer.append(ch);
            }
        }

        return answer.toString();
    }
}

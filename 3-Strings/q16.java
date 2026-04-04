import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q16 {
    /*
     * Pattern: Strings
     * Company Names: Atlassian, PhonePe
     *
     * LeetCode #271: Encode and Decode Strings
     *
     * Problem samajh lo:
     * String list ko ek single encoded string me convert karna hai
     * aur phir us encoded string se original list wapas banana hai.
     *
     * Challenge:
     * Strings ke andar special characters ya delimiter bhi ho sakte hain,
     * isliye simple join reliable nahi hota.
     *
     * Safe idea:
     * Har string ko length + '#' + actual string ke format me encode karo.
     *
     * Example:
     * ["lint", "code", "love", "you"]
     * Encode karke kuch aisa banega:
     * "4#lint4#code4#love3#you"
     *
     * Decode karte waqt:
     * pehle length padho
     * phir utne characters ka actual string nikaalo
     *
     * Time Complexity: O(total characters)
     * Space Complexity: O(total characters)
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("lint", "code", "love", "you");
        String encoded = encode(words);
        System.out.println(encoded);
        System.out.println(decode(encoded));
    }

    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String word : strs) {
            encoded.append(word.length()).append('#').append(word);
        }

        return encoded.toString();
    }

    public static List<String> decode(String s) {
        List<String> answer = new ArrayList<>();
        int index = 0;

        while (index < s.length()) {
            int separator = index;

            while (s.charAt(separator) != '#') {
                separator++;
            }

            int length = Integer.parseInt(s.substring(index, separator));
            String word = s.substring(separator + 1, separator + 1 + length);
            answer.add(word);
            index = separator + 1 + length;
        }

        return answer;
    }
}

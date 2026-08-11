import java.util.HashMap;
import java.util.Map;

public class q18 {
    /*
     * Pattern: Hashing / HashMap + Encoding
     * Company Names: Amazon, Google, Meta
     * Difficulty: Medium
     *
     * LeetCode #535: Encode and Decode TinyURL
     *
     * Problem samajh lo:
     * Humein ek URL ko chhote TinyURL me convert karna hai (encode).
     * Aur TinyURL se wapas original URL nikalna hai (decode).
     *
     * Example:
     * encode("https://leetcode.com/problems/design-tinyurl")
     * -> "http://tinyurl.com/abc123"
     * decode("http://tinyurl.com/abc123")
     * -> "https://leetcode.com/problems/design-tinyurl"
     *
     * Best idea:
     * Step 1: Har URL ko ek unique short code assign karo.
     * Step 2: HashMap me (shortCode -> originalUrl) store karo.
     * Step 3: Encode me naya code generate karke map me daalo.
     * Step 4: Decode me code se map lookup karo.
     *
     * Kyun HashMap?
     * URL lookup O(1) me ho jata hai.
     * Code generation me counter ya random string use kar sakte hain.
     *
     * Time Complexity: O(1) for both encode and decode
     * Space Complexity: O(n) where n = number of URLs
     */
    private static Map<String, String> urlMap = new HashMap<>();
    private static int counter = 0;
    private static final String BASE = "http://tinyurl.com/";

    public static void main(String[] args) {
        String original = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = encode(original);
        System.out.println("Encoded = " + shortUrl);
        System.out.println("Decoded = " + decode(shortUrl));
    }

    public static String encode(String longUrl) {
        // Unique code generate karo
        String code = Integer.toString(counter++);
        urlMap.put(code, longUrl);
        return BASE + code;
    }

    public static String decode(String shortUrl) {
        // Code extract karo aur lookup karo
        String code = shortUrl.replace(BASE, "");
        return urlMap.get(code);
    }
}
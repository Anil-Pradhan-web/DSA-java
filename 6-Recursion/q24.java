import java.util.ArrayList;
import java.util.List;

public class q24 {
    /*
     * Pattern: Backtracking / Constraint Satisfaction
     * Company Names: Amazon, Meta
     * Difficulty: Medium
     *
     * LeetCode #93: Restore IP Addresses
     *
     * Problem samajh lo:
     * String ko valid IP addresses me split karna hai.
     * Total 4 parts chahiye, each part 0 to 255 ke beech ho,
     * aur leading zero invalid hota hai unless part exactly "0" ho.
     *
     * Time Complexity: Bounded small search space
     * Space Complexity: O(1) recursion depth limited
     */
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), answer);
        return answer;
    }

    private static void backtrack(String s, int index, int parts, StringBuilder current, List<String> answer) {
        if (parts == 4 && index == s.length()) {
            answer.add(current.substring(0, current.length() - 1));
            return;
        }

        if (parts == 4 || index == s.length()) {
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            if ((part.length() > 1 && part.charAt(0) == '0') || Integer.parseInt(part) > 255) {
                continue;
            }

            int oldLength = current.length();
            current.append(part).append('.');
            backtrack(s, index + len, parts + 1, current, answer);
            current.setLength(oldLength);
        }
    }
}

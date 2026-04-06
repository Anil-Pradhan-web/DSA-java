import java.util.Arrays;

public class q23 {
    /*
     * Pattern: Custom Sorting / Comparator
     * Company Names: Amazon
     *
     * LeetCode #937: Reorder Data in Log Files
     *
     * Problem samajh lo:
     * Letter-logs ko pehle rakhna hai aur digit-logs ko baad me.
     * Letter-logs ko content ke basis par sort karna hai,
     * tie ho to identifier ke basis par.
     * Digit-logs ka original order preserve rehna chahiye.
     *
     * Yahan stable/custom comparator thinking bahut important hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: depends on sorting internals
     */
    public static void main(String[] args) {
        String[] logs = {
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig",
            "let3 art zero"
        };
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (first, second) -> {
            String firstContent = first.substring(first.indexOf(' ') + 1);
            String secondContent = second.substring(second.indexOf(' ') + 1);

            boolean firstDigit = Character.isDigit(firstContent.charAt(0));
            boolean secondDigit = Character.isDigit(secondContent.charAt(0));

            if (!firstDigit && !secondDigit) {
                int compare = firstContent.compareTo(secondContent);
                if (compare != 0) {
                    return compare;
                }
                String firstId = first.substring(0, first.indexOf(' '));
                String secondId = second.substring(0, second.indexOf(' '));
                return firstId.compareTo(secondId);
            }

            if (!firstDigit) {
                return -1;
            }
            if (!secondDigit) {
                return 1;
            }
            return 0;
        });

        return logs;
    }
}

public class q10 {
    /*
     * Pattern: Strings
     * Company Names: TCS, Infosys
     *
     * LeetCode #13: Roman to Integer
     *
     * Problem samajh lo:
     * Roman numeral string ko integer me convert karna hai.
     *
     * Basic symbols:
     * I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
     *
     * Important special cases:
     * IV = 4
     * IX = 9
     * XL = 40
     * XC = 90
     * CD = 400
     * CM = 900
     *
     * Core observation:
     * Agar current symbol ki value next symbol se chhoti hai,
     * to usse subtract karna hota hai.
     * Warna add karna hota hai.
     *
     * Example:
     * s = "MCMXCIV"
     * Answer = 1994
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = valueOf(s.charAt(i));

            if (i + 1 < s.length() && current < valueOf(s.charAt(i + 1))) {
                answer -= current;
            } else {
                answer += current;
            }
        }

        return answer;
    }

    private static int valueOf(char ch) {
        if (ch == 'I') {
            return 1;
        }
        if (ch == 'V') {
            return 5;
        }
        if (ch == 'X') {
            return 10;
        }
        if (ch == 'L') {
            return 50;
        }
        if (ch == 'C') {
            return 100;
        }
        if (ch == 'D') {
            return 500;
        }
        return 1000;
    }
}

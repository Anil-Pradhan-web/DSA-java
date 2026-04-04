public class q5 {
    /*
     * Pattern: Strings
     * Company Names: Infosys, HCL
     *
     * LeetCode #38: Count and Say
     *
     * Problem samajh lo:
     * Yeh sequence previous string ko read karke next string banata hai.
     * Har group of same characters ko count + character ke form me bola jaata hai.
     *
     * Sequence:
     * 1
     * 11
     * 21
     * 1211
     * 111221
     *
     * Example:
     * n = 4
     * Answer = "1211"
     *
     * Core idea:
     * Current string ko left se right read karo.
     * Consecutive same digits ko count karo.
     * Phir count aur digit append karke next string banao.
     *
     * Time Complexity: Roughly exponential growth of output size ke hisaab se
     * Space Complexity: Output dependent
     */
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        String current = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;

            for (int j = 1; j < current.length(); j++) {
                if (current.charAt(j) == current.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count).append(current.charAt(j - 1));
                    count = 1;
                }
            }

            next.append(count).append(current.charAt(current.length() - 1));
            current = next.toString();
        }

        return current;
    }
}

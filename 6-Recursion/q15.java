public class q15 {
    /*
     * Pattern: Sliding Window on String
     * Company Names: Amazon, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #567: Permutation in String
     *
     * Note:
     * Ye strict recursion problem nahi hai,
     * but permutation topic me related pattern ke roop me padha jaata hai.
     *
     * Idea:
     * s1 ki frequency aur s2 ke window ki frequency compare karo.
     * Agar kisi window ki frequency same hai,
     * to s1 ki koi permutation present hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] target = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            target[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (matches(target, window)) {
            return true;
        }

        for (int right = s1.length(); right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;
            window[s2.charAt(right - s1.length()) - 'a']--;

            if (matches(target, window)) {
                return true;
            }
        }

        return false;
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

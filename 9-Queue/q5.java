import java.util.ArrayDeque;
import java.util.Queue;

public class q5 {
    /*
     * Pattern: Queue / First Unique Character
     * Company Names: TCS, Infosys
     * Difficulty: Easy
     *
     * LeetCode #387: First Unique Character in String
     *
     * Problem samajh lo:
     * Pehla non-repeating character ka index return karna hai.
     *
     * Frequency count + queue idea:
     * Queue possible unique candidates maintain karti hai.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            freq[index]++;
            queue.offer(i);

            while (!queue.isEmpty() && freq[s.charAt(queue.peek()) - 'a'] > 1) {
                queue.poll();
            }
        }

        return queue.isEmpty() ? -1 : queue.peek();
    }
}

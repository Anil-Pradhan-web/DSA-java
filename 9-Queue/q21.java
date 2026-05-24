import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Pattern: BFS Queue on Graph
 * Company Names: Amazon, Google, LinkedIn
 * Difficulty: Hard
 *
 * Problem: Word Ladder
 * LeetCode: 127
 *
 * Hinglish Explanation:
 * Hume beginWord se endWord tak minimum transformations chahiye.
 * Ek transformation mein sirf ek character change kar sakte hain, aur new word
 * wordList mein present hona chahiye.
 *
 * Isko graph ki tarah socho:
 * - Har word ek node hai.
 * - Do words connected hain agar unmein sirf ek character different hai.
 * - Minimum transformation sequence = shortest path.
 *
 * Shortest path unweighted graph mein BFS se milta hai.
 *
 * Important:
 * Visited word ko set se remove kar do, warna same word baar-baar queue mein
 * aayega aur TLE ho sakta hai.
 *
 * Time Complexity: O(n * L * 26)
 * Space Complexity: O(n)
 */
public class q21 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        words.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return level;
                }

                char[] chars = current.toCharArray();
                for (int pos = 0; pos < chars.length; pos++) {
                    char original = chars[pos];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) {
                            continue;
                        }

                        chars[pos] = ch;
                        String next = new String(chars);
                        if (words.remove(next)) {
                            queue.offer(next);
                        }
                    }

                    chars[pos] = original;
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", words)); // 5
    }
}

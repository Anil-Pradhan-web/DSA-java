import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class q10 {
    /*
     * Pattern: BFS / Shortest Path in State Space
     * Company Names: Bloomberg, Paytm
     * Difficulty: Medium
     *
     * LeetCode #752: Open the Lock
     *
     * Problem samajh lo:
     * Lock "0000" se target tak minimum moves me jana hai.
     * Deadends avoid karne hain.
     *
     * BFS:
     * Har lock state ek node hai.
     * Ek move me 8 possible neighbor states bante hain.
     *
     * Time Complexity: O(10000)
     * Space Complexity: O(10000)
     */
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> blocked = new HashSet<>();

        for (String deadend : deadends) {
            blocked.add(deadend);
        }

        if (blocked.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return moves;
                }

                for (String next : neighbors(current)) {
                    if (!blocked.contains(next) && visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private static java.util.List<String> neighbors(String state) {
        java.util.List<String> result = new java.util.ArrayList<>();
        char[] chars = state.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];
            chars[i] = original == '9' ? '0' : (char) (original + 1);
            result.add(new String(chars));
            chars[i] = original == '0' ? '9' : (char) (original - 1);
            result.add(new String(chars));
            chars[i] = original;
        }

        return result;
    }
}

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class q7 {
    /*
     * Pattern: Queue Simulation
     * Company Names: Cognizant, Infosys
     * Difficulty: Medium
     *
     * LeetCode #950: Reveal Cards in Increasing Order
     *
     * Problem samajh lo:
     * Cards ko aise arrange karna hai ki reveal process ke baad increasing order mile.
     *
     * Idea:
     * Indices queue me rakho.
     * Sorted cards ko reveal positions par place karo.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> indices = new ArrayDeque<>();

        for (int i = 0; i < deck.length; i++) {
            indices.offer(i);
        }

        int[] answer = new int[deck.length];

        for (int card : deck) {
            answer[indices.poll()] = card;

            if (!indices.isEmpty()) {
                indices.offer(indices.poll());
            }
        }

        return answer;
    }
}

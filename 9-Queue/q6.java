import java.util.ArrayDeque;
import java.util.Queue;

public class q6 {
    /*
     * Pattern: Queue Simulation
     * Company Names: TCS, Wipro
     * Difficulty: Easy
     *
     * LeetCode #2073: Time Needed to Buy Tickets
     *
     * Problem samajh lo:
     * Queue me log tickets khareed rahe hain.
     * Index k wale person ko tickets complete karne me kitna time lagega.
     *
     * Simulation queue se natural hai.
     *
     * Time Complexity: O(total tickets processed)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] tickets = {2, 3, 2};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            tickets[index]--;
            time++;

            if (tickets[index] == 0 && index == k) {
                return time;
            }

            if (tickets[index] > 0) {
                queue.offer(index);
            }
        }

        return time;
    }
}

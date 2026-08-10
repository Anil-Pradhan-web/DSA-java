import java.util.PriorityQueue;

public class q14 {
    /*
     * Pattern: Heap / Greedy
     * Company Names: Amazon, Google, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #1167: Minimum Cost to Connect Sticks
     *
     * Problem samajh lo:
     * Humein sticks ki lengths di gayi hain.
     * Do sticks ko jodne ka cost unki lengths ka sum hota hai.
     * Humein saare sticks ko ek single stick me jodne ka minimum total cost nikalna
     * hai.
     *
     * Example:
     * sticks = [2, 4, 3]
     * Step 1: 2 + 3 = 5 (cost 5), sticks = [4, 5]
     * Step 2: 4 + 5 = 9 (cost 9), sticks = [9]
     * Total cost = 5 + 9 = 14
     *
     * Best idea:
     * Min heap use karo.
     * Har baar sabse chhote do sticks nikalo (kyunki unhe jodna sabse sasta hota
     * hai).
     * Unhe jodo, cost add karo, aur naya stick wapas heap me daalo.
     *
     * Kyun chhote pehle?
     * Greedy approach — chhote sticks ko pehle jodne se unka cost baar-baar
     * add nahi hota. Bade sticks ko baad me jodne se total cost kam rehta hai.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void main(String[] args) {
        int[] sticks = { 2, 4, 3 };
        System.out.println("Minimum cost = " + connectSticks(sticks));
    }

    public static int connectSticks(int[] sticks) {
        // Min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int stick : sticks) {
            minHeap.add(stick);
        }

        int totalCost = 0;

        // Jab tak ek stick nahi bachta
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;
            totalCost += cost;

            minHeap.add(cost);
        }

        return totalCost;
    }
}
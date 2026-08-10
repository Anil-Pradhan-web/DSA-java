import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class q19 {
    /*
     * Pattern: Heap / Dijkstra's Algorithm (modified)
     * Company Names: Amazon, Google, Meta, Uber
     * Difficulty: Medium
     *
     * LeetCode #787: Cheapest Flights Within K Stops
     *
     * Problem samajh lo:
     * Humein flights diye hain jisme har flight (from, to, price) hai.
     * Humein source se destination tak ka cheapest price nikalna hai
     * jisme at most k stops ho.
     *
     * Example:
     * flights = [[0, 1, 100], [1, 2, 100], [0, 2, 500]], src = 0, dst = 2, k = 1
     * Answer = 200 (0 -> 1 -> 2 = 100 + 100)
     *
     * Best idea:
     * Modified Dijkstra use karo:
     * Step 1: Adjacency list banao.
     * Step 2: Min heap (cost, node, stops) use karo.
     * Step 3: Stops ko track karo — agar kisi node par kam stops ke saath
     * kam cost mila hai, to usi ko process karo.
     *
     * Time Complexity: O(E log V)
     * Space Complexity: O(V + E)
     */
    public static void main(String[] args) {
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        int n = 3;
        int src = 0;
        int dst = 2;
        int k = 1;
        System.out.println("Cheapest flight = " + findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new int[] { to, price });
        }

        // Step 2: Min heap [cost, node, stops]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] { 0, src, 0 });

        // Step 3: Best cost with stops tracking
        int[] bestCost = new int[n];
        Arrays.fill(bestCost, Integer.MAX_VALUE);
        bestCost[src] = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int cost = current[0];
            int node = current[1];
            int stops = current[2];

            if (node == dst) {
                return cost;
            }

            if (stops > k) {
                continue;
            }

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int price = neighbor[1];
                int newCost = cost + price;

                if (newCost < bestCost[nextNode]) {
                    bestCost[nextNode] = newCost;
                    minHeap.add(new int[] { newCost, nextNode, stops + 1 });
                }
            }
        }

        return -1; // destination unreachable
    }
}
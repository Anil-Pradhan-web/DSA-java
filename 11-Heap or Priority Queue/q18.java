import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class q18 {
    /*
     * Pattern: Heap / Dijkstra's Algorithm
     * Company Names: Amazon, Google, Meta, Microsoft
     * Difficulty: Medium
     *
     * LeetCode #743: Network Delay Time
     *
     * Problem samajh lo:
     * Humein network me nodes (1 to n) aur edges diye hain.
     * Har edge: (source, target, time) — signal source se target tak time me
     * pahunchta hai.
     * Signal source node k se start hota hai.
     * Humein minimum time nikalna hai jisme signal saare nodes tak pahunch jaye.
     * Agar koi node unreachable hai, to -1 return karo.
     *
     * Example:
     * times = [[2, 1, 1], [2, 3, 1], [3, 4, 1]], n = 4, k = 2
     * Answer = 2
     * 2 -> 1 (1 time), 2 -> 3 (1 time), 3 -> 4 (1 time)
     * Total = 1 + 1 = 2
     *
     * Best idea:
     * Dijkstra's algorithm use karo:
     * Step 1: Adjacency list banao.
     * Step 2: Min heap (distance, node) use karo.
     * Step 3: Source se start karke har node ka shortest distance nikaalo.
     * Step 4: Maximum distance hi answer hai.
     *
     * Time Complexity: O(E log V)
     * Space Complexity: O(V + E)
     */
    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;
        System.out.println("Network delay time = " + networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int source = edge[0];
            int target = edge[1];
            int time = edge[2];
            graph.get(source).add(new int[] { target, time });
        }

        // Step 2: Dijkstra with min heap [distance, node]
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] { 0, k });

        // Step 3: Shortest distances nikaalo
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentDist = current[0];
            int node = current[1];

            if (currentDist > distances[node]) {
                continue; // stale entry
            }

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeTime = neighbor[1];
                int newDist = currentDist + edgeTime;

                if (newDist < distances[nextNode]) {
                    distances[nextNode] = newDist;
                    minHeap.add(new int[] { newDist, nextNode });
                }
            }
        }

        // Step 4: Maximum distance nikaalo
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1; // unreachable node
            }
            maxTime = Math.max(maxTime, distances[i]);
        }

        return maxTime;
    }
}
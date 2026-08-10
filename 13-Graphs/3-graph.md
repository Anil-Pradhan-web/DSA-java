# Graphs in Java for DSA - Part 3

## 1. BFS for shortest path in unweighted graph

Unweighted graph me BFS shortest path deta hai.

```java
public static int[] shortestPathUnweighted(int n, java.util.List<java.util.List<Integer>> adj, int src) {
    int[] dist = new int[n];
    java.util.Arrays.fill(dist, -1);
    java.util.Queue<Integer> queue = new java.util.LinkedList<>();

    queue.offer(src);
    dist[src] = 0;

    while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int neighbor : adj.get(node)) {
            if (dist[neighbor] == -1) {
                dist[neighbor] = dist[node] + 1;
                queue.offer(neighbor);
            }
        }
    }

    return dist;
}
```

## 2. Dijkstra's Algorithm

Use when:

- weighted graph ho
- negative weights na ho
- shortest path chahiye

### Complexity

- `O((V + E) log V)`

```java
static class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public static int[] dijkstra(int n, java.util.List<java.util.List<Edge>> adj, int src) {
    int[] dist = new int[n];
    java.util.Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    pq.offer(new int[]{src, 0});

    while (!pq.isEmpty()) {
        int[] current = pq.poll();
        int node = current[0];
        int d = current[1];

        if (d > dist[node]) {
            continue;
        }

        for (Edge edge : adj.get(node)) {
            if (dist[node] + edge.weight < dist[edge.to]) {
                dist[edge.to] = dist[node] + edge.weight;
                pq.offer(new int[]{edge.to, dist[edge.to]});
            }
        }
    }

    return dist;
}
```

## 3. Bellman-Ford Algorithm

Use when:

- negative weights ho sakte hain
- negative cycle detect karna ho

### Complexity

- `O(VE)`

```java
public static int[] bellmanFord(int n, int[][] edges, int src) {
    int[] dist = new int[n];
    java.util.Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    for (int i = 1; i < n; i++) {
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
            }
        }
    }

    for (int[] edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];
        if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
            throw new RuntimeException("Negative weight cycle detected");
        }
    }

    return dist;
}
```

## 4. Floyd-Warshall Algorithm

All-pairs shortest path ke liye.

### Complexity

- `O(V^3)`

```java
public static void floydWarshall(int[][] dist) {
    int n = dist.length;

    for (int via = 0; via < n; via++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
    }
}
```

## 5. 0-1 BFS

Use when edge weights sirf `0` ya `1` hon.

Deque use hota hai.

```java
public static int[] zeroOneBFS(int n, java.util.List<java.util.List<Edge>> adj, int src) {
    int[] dist = new int[n];
    java.util.Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
    deque.offerFirst(src);

    while (!deque.isEmpty()) {
        int node = deque.pollFirst();

        for (Edge edge : adj.get(node)) {
            if (dist[node] + edge.weight < dist[edge.to]) {
                dist[edge.to] = dist[node] + edge.weight;
                if (edge.weight == 0) {
                    deque.offerFirst(edge.to);
                } else {
                    deque.offerLast(edge.to);
                }
            }
        }
    }

    return dist;
}
```

## 6. Minimum Spanning Tree (MST)

MST ek weighted connected undirected graph ka aisa spanning tree hota hai jisme:

- saare vertices connected hon
- cycles na ho
- total weight minimum ho
- total edges = `V - 1`

## 7. Prim's Algorithm

Greedy approach.

- ek node se start karo
- minimum edge choose karte jao
- tree grow karte jao

### Complexity

- `O(E log V)`

```java
public static int primMST(int n, java.util.List<java.util.List<Edge>> adj) {
    boolean[] visited = new boolean[n];
    java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    pq.offer(new int[]{0, 0});

    int total = 0;

    while (!pq.isEmpty()) {
        int[] current = pq.poll();
        int node = current[0];
        int weight = current[1];

        if (visited[node]) {
            continue;
        }

        visited[node] = true;
        total += weight;

        for (Edge edge : adj.get(node)) {
            if (!visited[edge.to]) {
                pq.offer(new int[]{edge.to, edge.weight});
            }
        }
    }

    return total;
}
```

## 8. Union-Find (Disjoint Set Union)

Use cases:

- cycle detection
- MST
- connected components

### Path compression + union by size

```java
static class DSU {
    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }

        if (size[pa] < size[pb]) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;
        size[pa] += size[pb];
        return true;
    }
}
```

## 9. Kruskal's Algorithm

Greedy approach.

- edges sort karo by weight
- smallest edge pick karo
- cycle create ho to skip karo
- DSU use karo

### Complexity

- `O(E log E)`

```java
public static int kruskalMST(int n, int[][] edges) {
    java.util.Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
    DSU dsu = new DSU(n);
    int total = 0;

    for (int[] edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];
        if (dsu.union(u, v)) {
            total += w;
        }
    }

    return total;
}
```

## 10. Practice Problems

## 10.1 Dijkstra's shortest path

Use `dijkstra()` from above.

## 10.2 Bellman-Ford algorithm

Use `bellmanFord()` from above.

## 10.3 Floyd-Warshall all-pairs shortest path

Use `floydWarshall()` from above.

## 10.4 Kruskal's MST

Use `kruskalMST()` from above.

## 10.5 Word ladder (BFS shortest path)

```java
public static int ladderLength(String beginWord, String endWord, java.util.List<String> wordList) {
    java.util.Set<String> dict = new java.util.HashSet<>(wordList);
    if (!dict.contains(endWord)) {
        return 0;
    }

    java.util.Queue<String> queue = new java.util.LinkedList<>();
    queue.offer(beginWord);
    int level = 1;

    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String word = queue.poll();
            if (word.equals(endWord)) {
                return level;
            }

            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char original = chars[j];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[j] = c;
                    String next = new String(chars);
                    if (dict.remove(next)) {
                        queue.offer(next);
                    }
                }
                chars[j] = original;
            }
        }
        level++;
    }

    return 0;
}
```

## 11. Quick revision summary

- unweighted shortest path = BFS
- weighted non-negative = Dijkstra
- negative edges = Bellman-Ford
- all pairs shortest path = Floyd-Warshall
- 0/1 weights = 0-1 BFS
- MST ke liye Prim aur Kruskal important hain
- DSU path compression aur union by size/rank ke saath optimize hota hai

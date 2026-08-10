# Graphs in Java for DSA - Part 4

## 1. Strongly Connected Components (SCC)

SCC directed graph ke aise components hote hain jahan har node se har dusre node tak path hota hai.

## 1.1 Kosaraju's algorithm

Steps:

- DFS and finish time stack
- transpose graph banao
- reversed finish order me DFS

### Complexity

- `O(V + E)`

## 1.2 Tarjan's algorithm

Tarjan low-link values use karta hai SCC nikalne ke liye.

Interview note:

- concept samajhna useful hai
- implementation thoda advanced hota hai

## 2. Articulation points and bridges

### Articulation point

Aisa vertex jise remove karne par graph disconnected ho jaye.

### Bridge

Aisi edge jise remove karne par graph disconnected ho jaye.

Ye low-link / discovery time based DFS se nikale jaate hain.

## 3. Bipartite graph check

Bipartite graph ko 2 colors me color kar sakte hain without adjacent same color.

### BFS using 2-coloring

```java
public static boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] color = new int[n];

    for (int i = 0; i < n; i++) {
        if (color[i] != 0) {
            continue;
        }

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(i);
        color[i] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {
                    color[neighbor] = -color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
    }

    return true;
}
```

## 4. Eulerian path and circuit

### Eulerian path

Har edge exactly once traverse hoti hai.

### Eulerian circuit

Har edge exactly once traverse hoti hai aur start node par wapas aate hain.

Undirected graph conditions idea:

- Eulerian circuit -> sab vertices even degree
- Eulerian path -> exactly 2 odd degree vertices

## 5. Hamiltonian path

Hamiltonian path har vertex ko exactly once visit karta hai.

Important note:

- NP-complete concept hai
- usually conceptually jana enough hota hai unless explicitly implementation poochhi ho

## 6. Multi-source BFS

Jab multiple starting nodes se shortest distance nikalni ho tab multi-source BFS use hoti hai.

```java
public static int[][] multiSourceBFS(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    java.util.Queue<int[]> queue = new java.util.LinkedList<>();
    int[][] dist = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
        java.util.Arrays.fill(dist[i], -1);
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 1) {
                queue.offer(new int[]{i, j});
                dist[i][j] = 0;
            }
        }
    }

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        for (int[] d : dirs) {
            int nr = cell[0] + d[0];
            int nc = cell[1] + d[1];

            if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && dist[nr][nc] == -1) {
                dist[nr][nc] = dist[cell[0]][cell[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }

    return dist;
}
```

## 7. Graph problems on grids

Grid problems ko graph ki tarah treat kar sakte ho.

- har cell = node
- adjacent cells = edges

Examples:

- number of islands
- shortest path in matrix
- rotten oranges
- flood fill

## 8. Practice Problems

## 8.1 Bipartite graph check

Use `isBipartite()` from above.

## 8.2 Accounts merge (Union-Find)

```java
public static java.util.List<java.util.List<String>> accountsMerge(java.util.List<java.util.List<String>> accounts) {
    int n = accounts.size();
    DSU dsu = new DSU(n);
    java.util.Map<String, Integer> emailToIndex = new java.util.HashMap<>();

    for (int i = 0; i < n; i++) {
        for (int j = 1; j < accounts.get(i).size(); j++) {
            String email = accounts.get(i).get(j);
            if (!emailToIndex.containsKey(email)) {
                emailToIndex.put(email, i);
            } else {
                dsu.union(i, emailToIndex.get(email));
            }
        }
    }

    java.util.Map<Integer, java.util.TreeSet<String>> groups = new java.util.HashMap<>();
    for (java.util.Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
        int parent = dsu.find(entry.getValue());
        groups.computeIfAbsent(parent, k -> new java.util.TreeSet<>()).add(entry.getKey());
    }

    java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();
    for (int parent : groups.keySet()) {
        java.util.List<String> merged = new java.util.ArrayList<>();
        merged.add(accounts.get(parent).get(0));
        merged.addAll(groups.get(parent));
        result.add(merged);
    }

    return result;
}

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

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }

        if (size[pa] < size[pb]) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;
        size[pa] += size[pb];
    }
}
```

## 8.3 Articulation points and bridges

Interview level par concept + Tarjan low-link idea yaad rakhna useful hai.

## 8.4 SCC

Kosaraju and Tarjan dono important named algorithms hain.

## 9. Final roadmap summary

### File coverage

- `1-graph.md` -> representations, BFS, DFS, components, transitive closure, islands, clone graph
- `2-graph.md` -> cycle detection, topological sort, course schedule, alien dictionary
- `3-graph.md` -> shortest paths, MST, DSU, Dijkstra, Bellman-Ford, Floyd-Warshall, Word Ladder
- `4-graph.md` -> SCC, articulation/bridges, bipartite, Eulerian, Hamiltonian concept, multi-source BFS, accounts merge

## 10. Final takeaway

Graphs DSA ke sabse powerful topics me se ek hain, kyunki almost har advanced problem ko graph model me convert kiya ja sakta hai.

Java interview ke liye most important practical points:

- adjacency list mastery
- BFS and DFS strongly clear hona
- cycle detection and topo sort
- shortest path algorithms ka correct use case
- DSU for union-find style problems
- grid as graph mindset
- bipartite, SCC, articulation concepts ka overview

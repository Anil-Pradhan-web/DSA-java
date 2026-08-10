# Graphs in Java for DSA - Part 1

## 1. Graph kya hota hai?

Graph ek non-linear data structure hota hai jo nodes (vertices) aur edges ka collection hota hai.

Example:

- cities as nodes
- roads as edges

## 2. Graph representations

## 2.1 Adjacency Matrix

Matrix size `V x V` hota hai.

Agar node `u` aur `v` ke beech edge hai to matrix me mark karte hain.

### Java code

```java
int vertices = 4;
int[][] graph = new int[vertices][vertices];
graph[0][1] = 1;
graph[1][0] = 1;
```

### Complexity

- space = `O(V^2)`
- edge check = `O(1)`

## 2.2 Adjacency List

Har node ke liye uske neighbors store karte hain.

### Java code

```java
int vertices = 4;
java.util.List<java.util.List<Integer>> adj = new java.util.ArrayList<>();
for (int i = 0; i < vertices; i++) {
    adj.add(new java.util.ArrayList<>());
}
adj.get(0).add(1);
adj.get(1).add(0);
```

### Complexity

- space = `O(V + E)`
- sparse graphs ke liye better

## 3. Types of graphs

- directed graph
- undirected graph
- weighted graph
- unweighted graph
- cyclic graph
- acyclic graph

## 4. BFS (Breadth First Search)

BFS queue based traversal hai.

Ye level by level explore karta hai.

### Complexity

- `O(V + E)`

### Java code

```java
public static java.util.List<Integer> bfs(int start, java.util.List<java.util.List<Integer>> adj) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    boolean[] visited = new boolean[adj.size()];
    java.util.Queue<Integer> queue = new java.util.LinkedList<>();

    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
        int node = queue.poll();
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }

    return result;
}
```

## 5. DFS (Depth First Search)

DFS recursion ya stack based traversal hai.

Ye ek path ko depth me explore karta hai.

### Complexity

- `O(V + E)`

### Recursive Java code

```java
public static void dfs(int node, java.util.List<java.util.List<Integer>> adj,
                       boolean[] visited, java.util.List<Integer> result) {
    visited[node] = true;
    result.add(node);

    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited, result);
        }
    }
}
```

### Iterative Java code

```java
public static java.util.List<Integer> dfsIterative(int start, java.util.List<java.util.List<Integer>> adj) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    boolean[] visited = new boolean[adj.size()];
    java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
    stack.push(start);

    while (!stack.isEmpty()) {
        int node = stack.pop();
        if (visited[node]) {
            continue;
        }

        visited[node] = true;
        result.add(node);

        java.util.List<Integer> neighbors = adj.get(node);
        for (int i = neighbors.size() - 1; i >= 0; i--) {
            int neighbor = neighbors.get(i);
            if (!visited[neighbor]) {
                stack.push(neighbor);
            }
        }
    }

    return result;
}
```

## 6. Connected components in undirected graph

Connected components ka matlab graph ke disconnected groups.

### Java code

```java
public static int countComponents(int n, java.util.List<java.util.List<Integer>> adj) {
    boolean[] visited = new boolean[n];
    int components = 0;

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            components++;
            dfsMark(i, adj, visited);
        }
    }

    return components;
}

private static void dfsMark(int node, java.util.List<java.util.List<Integer>> adj, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfsMark(neighbor, adj, visited);
        }
    }
}
```

## 7. Transitive closure of a graph

Transitive closure batata hai ki kaun se node se kaun se node reachable hain.

Agar `closure[i][j] = true`, matlab `i` se `j` reachable hai.

### DFS based Java code

```java
public static boolean[][] transitiveClosure(int n, java.util.List<java.util.List<Integer>> adj) {
    boolean[][] closure = new boolean[n][n];

    for (int i = 0; i < n; i++) {
        dfsClosure(i, i, adj, closure);
    }

    return closure;
}

private static void dfsClosure(int source, int node, java.util.List<java.util.List<Integer>> adj,
                               boolean[][] closure) {
    closure[source][node] = true;

    for (int neighbor : adj.get(node)) {
        if (!closure[source][neighbor]) {
            dfsClosure(source, neighbor, adj, closure);
        }
    }
}
```

## 8. Practice Problems

## 8.1 Implement BFS and DFS

Use the BFS and DFS methods above.

## 8.2 Find if path exists between two nodes

```java
public static boolean hasPath(int source, int destination, java.util.List<java.util.List<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    java.util.Queue<Integer> queue = new java.util.LinkedList<>();
    queue.offer(source);
    visited[source] = true;

    while (!queue.isEmpty()) {
        int node = queue.poll();
        if (node == destination) {
            return true;
        }

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }

    return false;
}
```

## 8.3 Number of provinces

```java
public static int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    boolean[] visited = new boolean[n];
    int provinces = 0;

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            provinces++;
            dfsProvince(i, isConnected, visited);
        }
    }

    return provinces;
}

private static void dfsProvince(int city, int[][] isConnected, boolean[] visited) {
    visited[city] = true;
    for (int j = 0; j < isConnected.length; j++) {
        if (isConnected[city][j] == 1 && !visited[j]) {
            dfsProvince(j, isConnected, visited);
        }
    }
}
```

## 8.4 Number of islands (grid as graph)

```java
public static int numIslands(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int count = 0;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == '1') {
                count++;
                dfsIsland(grid, i, j);
            }
        }
    }

    return count;
}

private static void dfsIsland(char[][] grid, int r, int c) {
    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
        return;
    }

    grid[r][c] = '0';
    dfsIsland(grid, r + 1, c);
    dfsIsland(grid, r - 1, c);
    dfsIsland(grid, r, c + 1);
    dfsIsland(grid, r, c - 1);
}
```

## 8.5 Clone a graph

```java
static class Node {
    public int val;
    public java.util.List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        this.neighbors = new java.util.ArrayList<>();
    }
}

public static Node cloneGraph(Node node) {
    if (node == null) {
        return null;
    }

    java.util.Map<Node, Node> map = new java.util.HashMap<>();
    return cloneDfs(node, map);
}

private static Node cloneDfs(Node node, java.util.Map<Node, Node> map) {
    if (map.containsKey(node)) {
        return map.get(node);
    }

    Node copy = new Node(node.val);
    map.put(node, copy);

    for (Node neighbor : node.neighbors) {
        copy.neighbors.add(cloneDfs(neighbor, map));
    }

    return copy;
}
```

## 9. Quick revision summary

- adjacency matrix = `O(V^2)` space
- adjacency list = `O(V + E)` space
- BFS queue based hota hai
- DFS recursion/stack based hota hai
- connected components DFS/BFS se nikalte hain
- transitive closure reachability batata hai
- grid problems ko graph ki tarah treat kar sakte ho

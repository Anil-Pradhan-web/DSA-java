# Graphs in Java for DSA - Part 2

## 1. Cycle detection in undirected graph using DFS

```java
public static boolean hasCycleUndirectedDFS(int n, java.util.List<java.util.List<Integer>> adj) {
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
        if (!visited[i] && dfsCycleUndirected(i, -1, adj, visited)) {
            return true;
        }
    }

    return false;
}

private static boolean dfsCycleUndirected(int node, int parent,
                                          java.util.List<java.util.List<Integer>> adj,
                                          boolean[] visited) {
    visited[node] = true;

    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            if (dfsCycleUndirected(neighbor, node, adj, visited)) {
                return true;
            }
        } else if (neighbor != parent) {
            return true;
        }
    }

    return false;
}
```

## 2. Cycle detection in undirected graph using BFS

```java
static class Pair {
    int node;
    int parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public static boolean hasCycleUndirectedBFS(int n, java.util.List<java.util.List<Integer>> adj) {
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            java.util.Queue<Pair> queue = new java.util.LinkedList<>();
            queue.offer(new Pair(i, -1));
            visited[i] = true;

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                for (int neighbor : adj.get(pair.node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(new Pair(neighbor, pair.node));
                    } else if (neighbor != pair.parent) {
                        return true;
                    }
                }
            }
        }
    }

    return false;
}
```

## 3. Cycle detection in directed graph using DFS

Directed graph me back edge cycle indicate karta hai.

```java
public static boolean hasCycleDirectedDFS(int n, java.util.List<java.util.List<Integer>> adj) {
    boolean[] visited = new boolean[n];
    boolean[] pathVisited = new boolean[n];

    for (int i = 0; i < n; i++) {
        if (!visited[i] && dfsCycleDirected(i, adj, visited, pathVisited)) {
            return true;
        }
    }

    return false;
}

private static boolean dfsCycleDirected(int node, java.util.List<java.util.List<Integer>> adj,
                                        boolean[] visited, boolean[] pathVisited) {
    visited[node] = true;
    pathVisited[node] = true;

    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            if (dfsCycleDirected(neighbor, adj, visited, pathVisited)) {
                return true;
            }
        } else if (pathVisited[neighbor]) {
            return true;
        }
    }

    pathVisited[node] = false;
    return false;
}
```

## 4. Cycle detection in directed graph using Kahn's BFS

Agar topo sort me saare nodes process na ho paayein, cycle present hai.

```java
public static boolean hasCycleDirectedKahn(int n, java.util.List<java.util.List<Integer>> adj) {
    int[] indegree = new int[n];

    for (int i = 0; i < n; i++) {
        for (int neighbor : adj.get(i)) {
            indegree[neighbor]++;
        }
    }

    java.util.Queue<Integer> queue = new java.util.LinkedList<>();
    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) {
            queue.offer(i);
        }
    }

    int count = 0;
    while (!queue.isEmpty()) {
        int node = queue.poll();
        count++;

        for (int neighbor : adj.get(node)) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                queue.offer(neighbor);
            }
        }
    }

    return count != n;
}
```

## 5. Topological sort using DFS

Idea:

- node ke saare outgoing neighbors process karo
- finish hone par stack me push karo
- reverse finish order answer hota hai

```java
public static java.util.List<Integer> topoSortDFS(int n, java.util.List<java.util.List<Integer>> adj) {
    boolean[] visited = new boolean[n];
    java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            topoDfs(i, adj, visited, stack);
        }
    }

    java.util.List<Integer> result = new java.util.ArrayList<>();
    while (!stack.isEmpty()) {
        result.add(stack.pop());
    }
    return result;
}

private static void topoDfs(int node, java.util.List<java.util.List<Integer>> adj,
                            boolean[] visited, java.util.Deque<Integer> stack) {
    visited[node] = true;

    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            topoDfs(neighbor, adj, visited, stack);
        }
    }

    stack.push(node);
}
```

## 6. Topological sort using Kahn's Algorithm

```java
public static java.util.List<Integer> topoSortKahn(int n, java.util.List<java.util.List<Integer>> adj) {
    int[] indegree = new int[n];
    for (int i = 0; i < n; i++) {
        for (int neighbor : adj.get(i)) {
            indegree[neighbor]++;
        }
    }

    java.util.Queue<Integer> queue = new java.util.LinkedList<>();
    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) {
            queue.offer(i);
        }
    }

    java.util.List<Integer> result = new java.util.ArrayList<>();
    while (!queue.isEmpty()) {
        int node = queue.poll();
        result.add(node);

        for (int neighbor : adj.get(node)) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                queue.offer(neighbor);
            }
        }
    }

    return result;
}
```

## 7. Applications of topological sort

- build systems
- course prerequisites
- dependency resolution
- scheduling with order constraints

## 8. Practice Problems

## 8.1 Detect cycle in directed and undirected graph

Use methods from above sections.

## 8.2 Course Schedule I

```java
public static boolean canFinish(int numCourses, int[][] prerequisites) {
    java.util.List<java.util.List<Integer>> adj = new java.util.ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
        adj.add(new java.util.ArrayList<>());
    }

    int[] indegree = new int[numCourses];
    for (int[] pre : prerequisites) {
        adj.get(pre[1]).add(pre[0]);
        indegree[pre[0]]++;
    }

    java.util.Queue<Integer> queue = new java.util.LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) queue.offer(i);
    }

    int done = 0;
    while (!queue.isEmpty()) {
        int node = queue.poll();
        done++;
        for (int neighbor : adj.get(node)) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) queue.offer(neighbor);
        }
    }

    return done == numCourses;
}
```

## 8.3 Course Schedule II

```java
public static int[] findOrder(int numCourses, int[][] prerequisites) {
    java.util.List<java.util.List<Integer>> adj = new java.util.ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
        adj.add(new java.util.ArrayList<>());
    }

    int[] indegree = new int[numCourses];
    for (int[] pre : prerequisites) {
        adj.get(pre[1]).add(pre[0]);
        indegree[pre[0]]++;
    }

    java.util.Queue<Integer> queue = new java.util.LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) queue.offer(i);
    }

    int[] order = new int[numCourses];
    int index = 0;

    while (!queue.isEmpty()) {
        int node = queue.poll();
        order[index++] = node;
        for (int neighbor : adj.get(node)) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) queue.offer(neighbor);
        }
    }

    return index == numCourses ? order : new int[0];
}
```

## 8.4 Alien dictionary

```java
public static String alienOrder(String[] words) {
    java.util.Map<Character, java.util.Set<Character>> graph = new java.util.HashMap<>();
    java.util.Map<Character, Integer> indegree = new java.util.HashMap<>();

    for (String word : words) {
        for (char c : word.toCharArray()) {
            graph.putIfAbsent(c, new java.util.HashSet<>());
            indegree.putIfAbsent(c, 0);
        }
    }

    for (int i = 0; i < words.length - 1; i++) {
        String w1 = words[i];
        String w2 = words[i + 1];
        int len = Math.min(w1.length(), w2.length());
        boolean found = false;

        for (int j = 0; j < len; j++) {
            char c1 = w1.charAt(j);
            char c2 = w2.charAt(j);
            if (c1 != c2) {
                if (graph.get(c1).add(c2)) {
                    indegree.put(c2, indegree.get(c2) + 1);
                }
                found = true;
                break;
            }
        }

        if (!found && w1.length() > w2.length()) {
            return "";
        }
    }

    java.util.Queue<Character> queue = new java.util.LinkedList<>();
    for (char c : indegree.keySet()) {
        if (indegree.get(c) == 0) queue.offer(c);
    }

    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
        char c = queue.poll();
        sb.append(c);

        for (char next : graph.get(c)) {
            indegree.put(next, indegree.get(next) - 1);
            if (indegree.get(next) == 0) queue.offer(next);
        }
    }

    return sb.length() == indegree.size() ? sb.toString() : "";
}
```

## 9. Quick revision summary

- undirected cycle detect me parent track karna hota hai
- directed cycle detect me recursion path ya indegree logic use hota hai
- topological sort sirf DAG par valid hota hai
- Kahn's algorithm BFS + indegree use karta hai
- course schedule aur alien dictionary classic topo sort problems hain

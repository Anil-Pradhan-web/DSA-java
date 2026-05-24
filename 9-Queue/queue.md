# Queue in Java for DSA

## 1. Queue kya hota hai?

Queue ek linear data structure hota hai jo **FIFO** principle follow karta hai.

FIFO ka full form:
- First In First Out

Matlab jo element sabse pehle insert hua, wahi sabse pehle remove hoga.

```text
Enqueue 10
Enqueue 20
Enqueue 30

Front -> 10 20 30 <- Rear
Dequeue -> 10
```

## 2. Queue interview me kyun important hai?

Queue sirf basic data structure nahi hai. Interview me queue multiple forms me aati hai:
- normal FIFO processing
- circular queue design
- deque based sliding window
- BFS traversal in trees, graphs, and grids
- monotonic deque for optimized window problems
- priority queue for scheduling and heap-style problems

## 3. Queue ke 4 interview forms

### Form 1: Basic Queue / Circular Queue

Ye TCS/Wipro level par common hota hai.

Focus:
- enqueue
- dequeue
- front/rear
- circular queue modulo logic

### Form 2: Deque

Deque ka full form hai Double Ended Queue.

Isme dono ends se add/remove kar sakte ho.

Focus:
- sliding window
- palindrome style logic
- both-side processing

### Form 3: BFS Queue

BFS me queue ka use level by level traversal ke liye hota hai.

Use cases:
- binary tree level order
- graph shortest path
- grid spread problems
- rotten oranges
- word ladder

### Form 4: Monotonic Deque

Ye FAANG-style important pattern hai.

Use cases:
- sliding window maximum
- jump game VI
- longest subarray with limit
- max/min window optimization

## 4. Basic queue operations

Core operations:
- `offer(x)` -> enqueue
- `poll()` -> dequeue
- `peek()` -> front element
- `isEmpty()` -> empty check
- `size()` -> current size

Ideal complexity:
- enqueue = `O(1)`
- dequeue = `O(1)`
- peek = `O(1)`

## 5. Java Queue Cheatsheet

### Standard Queue

```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(x);
queue.poll();
queue.peek();
queue.isEmpty();
```

### Better option for normal queue

```java
Queue<Integer> queue = new ArrayDeque<>();
queue.offer(x);
queue.poll();
queue.peek();
```

### Deque

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.offerFirst(x);
deque.offerLast(x);
deque.pollFirst();
deque.pollLast();
deque.peekFirst();
deque.peekLast();
```

### PriorityQueue

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

## 6. Queue using array

Array queue me `front`, `rear`, aur `size` maintain karte hain.

```java
static class ArrayQueue {
    int[] arr;
    int front;
    int rear;
    int size;

    ArrayQueue(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(int value) {
        if (size == arr.length) {
            throw new RuntimeException("Queue Overflow");
        }
        rear++;
        arr[rear] = value;
        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        int value = arr[front];
        front++;
        size--;
        return value;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }
        return arr[front];
    }

    boolean isEmpty() {
        return size == 0;
    }
}
```

Issue:
- repeated dequeue ke baad front aage badhta rahega
- unused space waste ho sakti hai

Circular queue isko solve karti hai.

## 7. Circular Queue

Circular queue me array ko ring ki tarah use karte hain.

Key formula:
- next index = `(index + 1) % capacity`

```java
static class CircularQueue {
    int[] arr;
    int front;
    int rear;
    int size;

    CircularQueue(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean enqueue(int value) {
        if (size == arr.length) return false;
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        size++;
        return true;
    }

    boolean dequeue() {
        if (size == 0) return false;
        front = (front + 1) % arr.length;
        size--;
        return true;
    }

    int front() {
        return size == 0 ? -1 : arr[front];
    }

    int rear() {
        return size == 0 ? -1 : arr[rear];
    }
}
```

## 8. Queue using linked list

Linked list queue me:
- enqueue rear par
- dequeue front se

```java
static class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

static class LinkedListQueue {
    Node front;
    Node rear;

    void enqueue(int value) {
        Node node = new Node(value);

        if (rear == null) {
            front = node;
            rear = node;
            return;
        }

        rear.next = node;
        rear = node;
    }

    int dequeue() {
        if (front == null) {
            throw new RuntimeException("Queue Underflow");
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }
}
```

## 9. Deque theory

Deque double-ended queue hota hai.

Operations:
- front se add/remove
- back se add/remove

Use cases:
- sliding window maximum
- monotonic deque
- palindrome-like checks
- BFS variations

## 10. Priority Queue

PriorityQueue normal FIFO nahi hoti. Ye priority ke basis par element remove karti hai.

Java me:
- default `PriorityQueue` min heap hota hai
- max heap ke liye reverse comparator use karte hain

Use cases:
- task scheduling
- kth largest/smallest
- Dijkstra
- merge k sorted structures

## 11. BFS kya hota hai?

BFS ka full form hai Breadth First Search.

Idea:
- pehle current level process karo
- phir next level
- queue current frontier maintain karti hai

BFS important hai because:
- shortest path in unweighted graph
- level order traversal
- multi-source spread problems
- grid distance problems

## 12. Standard BFS Template for Grid

```java
Queue<int[]> queue = new LinkedList<>();
boolean[][] visited = new boolean[m][n];
int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

queue.offer(new int[]{startRow, startCol});
visited[startRow][startCol] = true;
int steps = 0;

while (!queue.isEmpty()) {
    int size = queue.size();

    for (int i = 0; i < size; i++) {
        int[] current = queue.poll();

        for (int[] dir : dirs) {
            int nr = current[0] + dir[0];
            int nc = current[1] + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }

    steps++;
}
```

## 13. Tree Level Order BFS Template

```java
Queue<TreeNode> queue = new LinkedList<>();
List<List<Integer>> result = new ArrayList<>();

if (root != null) {
    queue.offer(root);
}

while (!queue.isEmpty()) {
    int size = queue.size();
    List<Integer> level = new ArrayList<>();

    for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }

    result.add(level);
}
```

## 14. Monotonic Deque

Monotonic deque useful candidates ko order me maintain karti hai.

Sliding Window Maximum me:
- deque indices store karti hai
- front current window ka maximum hota hai
- back se smaller values remove hoti hain

## 15. Sliding Window Maximum Template

```java
Deque<Integer> deque = new ArrayDeque<>();
int[] result = new int[n - k + 1];

for (int i = 0; i < n; i++) {
    while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
    }

    while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
    }

    deque.offerLast(i);

    if (i >= k - 1) {
        result[i - k + 1] = nums[deque.peekFirst()];
    }
}
```

## 16. Queue vs Stack

### Queue

- FIFO
- process oldest first
- BFS, scheduling

### Stack

- LIFO
- process newest first
- DFS, parentheses, backtracking simulation

## 17. Queue using Stacks

Two stacks se queue simulate karte hain:
- input stack
- output stack

Amortized complexity:
- `O(1)` per operation

## 18. Stack using Queue

Queue se stack banane ke liye:
- push ke baad queue rotate kar sakte hain
- new element front par aa jata hai

## 19. TIER 1 expectation

Service-based companies usually puchte hain:
- Implement Queue using Stacks
- Implement Stack using Queues
- Design Circular Queue
- Number of Recent Calls
- First Unique Character
- Time Needed to Buy Tickets
- Reveal Cards in Increasing Order

## 20. TIER 2 expectation

Mid product based companies puchte hain:
- Rotting Oranges
- Walls and Gates
- Open the Lock
- Jump Game III
- Task Scheduler
- Design Hit Counter

Focus:
- BFS
- simulation
- queue state management

## 21. TIER 3 expectation

FAANG level queue questions:
- Binary Tree Level Order
- Zigzag Level Order
- Right Side View
- Word Ladder
- Number of Islands
- Shortest Path in Binary Matrix
- Sliding Window Maximum
- Jump Game VI
- Longest Subarray with Limit

## 22. Decision tree

### FIFO processing?

Use basic queue.

### Level by level traversal?

Use BFS queue.

### Grid shortest path or spreading?

Use BFS queue with directions.

### Window max/min?

Use monotonic deque.

### Both ends se add/remove?

Use deque.

### Priority based removal?

Use priority queue.

## 23. Company-wise expectation

### TCS / Wipro

- Queue/Stack implementation
- Circular Queue
- Recent Calls

### Infosys / Cognizant

- First Unique Character
- Basic Queue operations
- Reveal Cards

### Flipkart / Adobe

- Rotting Oranges
- Walls and Gates
- Task Scheduler

### Amazon

- Rotting Oranges
- Word Ladder
- Level Order
- Sliding Window Maximum

### Microsoft

- Level Order Traversal
- Sliding Window Maximum
- BFS grid

### Google

- Word Ladder
- Pacific Atlantic
- Monotonic Deque

### Meta

- Number of Islands
- Level Order
- Right Side View

## 24. Common mistakes

- `poll()` vs `remove()` ka difference ignore karna
- circular queue me modulo logic bhool jaana
- BFS me visited mark late karna
- queue size level loop ke bahar/andar confuse karna
- deque me front/back confuse karna
- monotonic deque me outdated indices remove na karna
- BFS shortest path me level count galat karna

## 25. Edge cases

- empty queue
- single element queue
- circular queue full/empty
- grid boundary
- already visited cells
- tree root null
- window size 1
- window size equals array length
- unreachable target in BFS

## 26. Time complexity summary

- enqueue/dequeue = `O(1)`
- circular queue operations = `O(1)`
- ArrayDeque end operations = `O(1)` amortized
- PriorityQueue offer/poll = `O(log n)`
- BFS tree/grid/graph = `O(V + E)` or `O(m * n)`
- sliding window maximum = `O(n)`
- queue using stacks = amortized `O(1)`

## 27. Must-do top queue problems

1. `#232 Implement Queue using Stacks`
2. `#102 Binary Tree Level Order Traversal`
3. `#994 Rotting Oranges`
4. `#127 Word Ladder`
5. `#239 Sliding Window Maximum`
6. `#200 Number of Islands`

## 28. Final takeaway

Queue mastery ka matlab sirf FIFO samajhna nahi hai. Real value tab aati hai jab tum identify kar pao:

- simple queue lagegi
- BFS level order chahiye
- grid shortest path hai
- multi-source BFS hai
- deque chahiye
- monotonic deque optimization lagegi

Queue strong ho gayi to trees, graphs, grid BFS, scheduling, stream processing, aur sliding window problems kaafi manageable ho jaate hain.

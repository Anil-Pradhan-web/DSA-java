# Queues in Java for DSA

## 1. Queue kya hota hai?

Queue ek linear data structure hota hai jo **FIFO** principle follow karta hai.

FIFO ka full form:

- First In First Out

Matlab jo element sabse pehle insert hua hai, wahi sabse pehle remove hoga.

Example:

```text
Enqueue 10
Enqueue 20
Enqueue 30

Front -> 10 20 30 <- Rear
Dequeue -> 10
```

## 2. Basic queue operations

- `offer()` / `add()` -> enqueue
- `poll()` / `remove()` -> dequeue
- `peek()` -> front element dekho
- `isEmpty()` -> queue empty hai ya nahi
- `size()` -> number of elements

## 3. Queue using arrays

Array based queue me `front` aur `rear` pointers maintain karte hain.

### Java code

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

    public void enqueue(int value) {
        if (size == arr.length) {
            throw new RuntimeException("Queue Overflow");
        }
        rear++;
        arr[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }
        int value = arr[front];
        front++;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
```

### Note

Ye simple array queue hai. Isme repeated dequeue ke baad front aage badhta jayega aur wasted space issue aa sakta hai. Is problem ko circular queue solve karti hai.

## 4. Queue using linked list

Linked list based queue me:

- enqueue rear par hota hai
- dequeue front se hota hai

### Java code

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

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
```

## 5. Circular Queue (Ring Buffer)

Circular queue me array ko circular manner me use karte hain.

Isse wasted space problem solve hoti hai.

### Java code

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

    public void enqueue(int value) {
        if (size == arr.length) {
            throw new RuntimeException("Queue Overflow");
        }

        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        int value = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
```

## 6. Deque - Double-ended queue

Deque me insert aur delete dono ends se ho sakte hain.

Operations:

- front se add/remove
- rear se add/remove

### Java me `ArrayDeque`

```java
java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
deque.addFirst(10);
deque.addLast(20);
System.out.println(deque.removeFirst());
System.out.println(deque.removeLast());
```

### Use cases

- stack ki tarah use kar sakte ho
- queue ki tarah use kar sakte ho
- sliding window maximum
- palindrome checks

## 7. Priority Queue / Min-Max Heap in Java

Priority queue normal queue jaisa nahi hota. Yahan dequeue priority ke basis par hota hai.

Java me `PriorityQueue` by default **min-heap** hota hai.

### Min-heap

```java
java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
minHeap.offer(30);
minHeap.offer(10);
minHeap.offer(20);
System.out.println(minHeap.poll()); // 10
```

### Max-heap

```java
java.util.PriorityQueue<Integer> maxHeap =
    new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
maxHeap.offer(30);
maxHeap.offer(10);
maxHeap.offer(20);
System.out.println(maxHeap.poll()); // 30
```

### Use cases

- kth largest/smallest
- scheduling problems
- shortest path style algorithms
- merge k sorted lists

## 8. Monotonic Deque concept

Monotonic deque me elements ek monotonic order me maintain kiye jaate hain.

Usually sliding window maximum/minimum jaisi problems me use hota hai.

### Idea

- deque me useful candidates hi rakhte hain
- smaller ya larger unnecessary elements remove kar dete hain
- front always current best answer hold karta hai

## 9. Applications of queue

- BFS traversal
- scheduling
- buffering
- CPU task handling
- printer queue
- stream processing
- sliding window problems

## 10. In-built Queue in Java

Queue interface commonly `LinkedList` ya `ArrayDeque` ke saath use hota hai.

```java
java.util.Queue<Integer> queue = new java.util.LinkedList<>();
queue.offer(10);
queue.offer(20);
System.out.println(queue.poll()); // 10
System.out.println(queue.peek()); // 20
```

Better modern option for many cases:

```java
java.util.Queue<Integer> queue = new java.util.ArrayDeque<>();
```

## 11. Practice Problems

## 11.1 Implement queue using two stacks

```java
static class MyQueue {
    java.util.Deque<Integer> stack1 = new java.util.ArrayDeque<>();
    java.util.Deque<Integer> stack2 = new java.util.ArrayDeque<>();

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        moveIfNeeded();
        return stack2.pop();
    }

    public int peek() {
        moveIfNeeded();
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void moveIfNeeded() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
```

## 11.2 Generate binary numbers from 1 to n using queue

Idea:

- start with `1`
- front nikalo, print karo
- usme `0` aur `1` append karke queue me dalo

```java
public static java.util.List<String> generateBinaryNumbers(int n) {
    java.util.List<String> result = new java.util.ArrayList<>();
    java.util.Queue<String> queue = new java.util.LinkedList<>();
    queue.offer("1");

    for (int i = 0; i < n; i++) {
        String current = queue.poll();
        result.add(current);
        queue.offer(current + "0");
        queue.offer(current + "1");
    }

    return result;
}
```

## 11.3 Reverse a queue using recursion

```java
public static void reverseQueue(java.util.Queue<Integer> queue) {
    if (queue.isEmpty()) {
        return;
    }

    int front = queue.poll();
    reverseQueue(queue);
    queue.offer(front);
}
```

## 11.4 First non-repeating character in a stream

```java
public static String firstNonRepeating(String stream) {
    int[] freq = new int[26];
    java.util.Queue<Character> queue = new java.util.LinkedList<>();
    StringBuilder result = new StringBuilder();

    for (char ch : stream.toCharArray()) {
        freq[ch - 'a']++;
        queue.offer(ch);

        while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            result.append('#');
        } else {
            result.append(queue.peek());
        }
    }

    return result.toString();
}
```

## 11.5 Sliding window maximum using monotonic deque

```java
public static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0 || k == 0) {
        return new int[0];
    }

    java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
    int[] result = new int[nums.length - k + 1];
    int index = 0;

    for (int i = 0; i < nums.length; i++) {
        while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
            deque.pollFirst();
        }

        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
            deque.pollLast();
        }

        deque.offerLast(i);

        if (i >= k - 1) {
            result[index++] = nums[deque.peekFirst()];
        }
    }

    return result;
}
```

## 11.6 LRU Cache implementation

Java me `LinkedHashMap` se elegant LRU cache ban sakta hai.

```java
static class LRUCache extends java.util.LinkedHashMap<Integer, Integer> {
    private final int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void putValue(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
```

### Interview note

Classic manual implementation usually:

- doubly linked list
- hashmap

Lekin Java me concept samjhane ke liye `LinkedHashMap` bhi useful hai.

## 12. Common mistakes in queue problems

- `poll()` aur `remove()` ka difference na samajhna
- circular queue me modulo update bhool jana
- deque me front/back operation confuse kar dena
- monotonic deque me outdated indices remove na karna
- queue using two stacks me transfer logic galat kar dena

## 13. Time complexity summary

- enqueue/dequeue in array queue = `O(1)`
- enqueue/dequeue in linked list queue = `O(1)`
- circular queue operations = `O(1)`
- `ArrayDeque` push/pop from ends = `O(1)` amortized
- priority queue insert/remove = `O(log n)`
- queue using two stacks = amortized `O(1)`
- binary numbers generation = `O(n)` strings output aside
- reverse queue using recursion = `O(n)`
- first non-repeating in stream = `O(n)`
- sliding window maximum = `O(n)`

## 14. Quick revision summary

- queue FIFO principle follow karta hai
- array, linked list, circular queue se implement kar sakte ho
- `Deque` double-ended queue hota hai
- Java me `ArrayDeque` bohot useful hai
- `PriorityQueue` by default min-heap hota hai
- monotonic deque sliding window problems me powerful hota hai
- BFS, scheduling, buffering queue ke common applications hain

## 15. Final takeaway

Queue DSA ka bohot important topic hai because ye ordering, scheduling, stream processing aur BFS problems ka foundation hai.

Java interview ke liye most important practical points:

- FIFO principle
- circular queue
- `ArrayDeque`
- `PriorityQueue`
- monotonic deque
- queue using two stacks
- sliding window maximum
- LRU cache concept

Agar queue strong ho gayi, to BFS, graphs, streaming aur cache-related interview problems kaafi easy lagne lagte hain.

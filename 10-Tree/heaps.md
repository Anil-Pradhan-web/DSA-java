# Heaps and Priority Queue in Java for DSA

## 1. Heap kya hota hai?

Heap ek complete binary tree hota hai jo usually array me store hota hai.

Types:

- Min Heap -> parent <= children
- Max Heap -> parent >= children

## 2. Heap property

### Min Heap

Sabse chhota element root par hota hai.

### Max Heap

Sabse bada element root par hota hai.

## 3. Complete binary tree as array

Agar index `i` hai, to:

- left child = `2 * i + 1`
- right child = `2 * i + 2`
- parent = `(i - 1) / 2`

## 4. Heapify up (insert)

Naya element end me add hota hai, phir parent ke saath compare karke upar move hota hai.

```java
static class MinHeap {
    java.util.ArrayList<Integer> heap = new java.util.ArrayList<>();

    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(parent) <= heap.get(index)) {
                break;
            }
            swap(parent, index);
            index = parent;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
```

## 5. Heapify down (delete)

```java
    public int removeMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    private void heapifyDown(int index) {
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }
}
```

## 6. Build heap from array - `O(n)`

```java
public static void buildHeap(int[] arr) {
    for (int i = arr.length / 2 - 1; i >= 0; i--) {
        heapify(arr, arr.length, i);
    }
}

private static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest]) {
        largest = left;
    }
    if (right < n && arr[right] > arr[largest]) {
        largest = right;
    }

    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr, n, largest);
    }
}
```

## 7. PriorityQueue in Java

Java me `PriorityQueue` by default min-heap hota hai.

```java
java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
minHeap.offer(30);
minHeap.offer(10);
minHeap.offer(20);
System.out.println(minHeap.poll()); // 10
```

## 8. Custom comparator in PriorityQueue

Max-heap banane ke liye:

```java
java.util.PriorityQueue<Integer> maxHeap =
    new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
```

Custom objects ke liye:

```java
java.util.PriorityQueue<int[]> pq =
    new java.util.PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
```

## 9. Heap Sort

```java
public static void heapSort(int[] arr) {
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, i, 0);
    }
}
```

### Complexity

- time = `O(n log n)`
- space = `O(1)`
- stable = no

## 10. Two heaps technique

Median problems me use hota hai.

- left side ke liye max-heap
- right side ke liye min-heap
- dono heaps balanced rehte hain

## 11. Practice Problems

## 11.1 Kth largest element in array

```java
public static int findKthLargest(int[] nums, int k) {
    java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();

    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    return minHeap.peek();
}
```

## 11.2 Merge k sorted lists

```java
static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public static ListNode mergeKLists(ListNode[] lists) {
    java.util.PriorityQueue<ListNode> pq =
        new java.util.PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

    for (ListNode node : lists) {
        if (node != null) {
            pq.offer(node);
        }
    }

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    while (!pq.isEmpty()) {
        ListNode node = pq.poll();
        tail.next = node;
        tail = tail.next;

        if (node.next != null) {
            pq.offer(node.next);
        }
    }

    return dummy.next;
}
```

## 11.3 Find top k frequent elements

```java
public static int[] topKFrequent(int[] nums, int k) {
    java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();
    for (int num : nums) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    java.util.PriorityQueue<int[]> pq =
        new java.util.PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

    for (java.util.Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        pq.offer(new int[]{entry.getKey(), entry.getValue()});
        if (pq.size() > k) {
            pq.poll();
        }
    }

    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) {
        result[i] = pq.poll()[0];
    }

    return result;
}
```

## 11.4 Sort a nearly sorted (k-sorted) array

```java
public static int[] sortKSorted(int[] arr, int k) {
    java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
    int index = 0;

    for (int num : arr) {
        pq.offer(num);
        if (pq.size() > k) {
            arr[index++] = pq.poll();
        }
    }

    while (!pq.isEmpty()) {
        arr[index++] = pq.poll();
    }

    return arr;
}
```

## 11.5 Median in a data stream

```java
static class MedianFinder {
    java.util.PriorityQueue<Integer> left =
        new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
    java.util.PriorityQueue<Integer> right = new java.util.PriorityQueue<>();

    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }
        return (left.peek() + right.peek()) / 2.0;
    }
}
```

## 11.6 Task scheduler

```java
public static int leastInterval(char[] tasks, int n) {
    int[] freq = new int[26];
    for (char task : tasks) {
        freq[task - 'A']++;
    }

    java.util.PriorityQueue<Integer> maxHeap =
        new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());

    for (int f : freq) {
        if (f > 0) {
            maxHeap.offer(f);
        }
    }

    int time = 0;

    while (!maxHeap.isEmpty()) {
        java.util.List<Integer> temp = new java.util.ArrayList<>();
        int cycle = n + 1;

        while (cycle > 0 && !maxHeap.isEmpty()) {
            int count = maxHeap.poll();
            if (count - 1 > 0) {
                temp.add(count - 1);
            }
            time++;
            cycle--;
        }

        for (int remaining : temp) {
            maxHeap.offer(remaining);
        }

        if (maxHeap.isEmpty()) {
            break;
        }

        time += cycle;
    }

    return time;
}
```

## 11.7 K closest points to origin

```java
public static int[][] kClosest(int[][] points, int k) {
    java.util.PriorityQueue<int[]> maxHeap = new java.util.PriorityQueue<>(
        (a, b) -> Integer.compare(distance(b), distance(a))
    );

    for (int[] point : points) {
        maxHeap.offer(point);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }

    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
        result[i] = maxHeap.poll();
    }

    return result;
}

private static int distance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
}
```

## 12. Time complexity summary

- insert in heap = `O(log n)`
- delete root = `O(log n)`
- peek root = `O(1)`
- build heap = `O(n)`
- heap sort = `O(n log n)`
- kth largest = `O(n log k)`
- merge k sorted lists = `O(n log k)`
- median stream = `O(log n)` per insertion

## 13. Quick revision summary

- heap complete binary tree hota hai
- min heap aur max heap ke rules alag hote hain
- `PriorityQueue` Java me default min-heap hota hai
- custom comparator se max-heap ya custom ordering bana sakte ho
- two heaps technique median problems me useful hoti hai
- heaps top-k, scheduling, merge problems me bohot powerful hote hain

## 14. Final takeaway

Heap aur PriorityQueue DSA me ranking, scheduling aur top-k problems ke liye bohot useful hote hain.

Java interview ke liye most important practical points:

- heap property
- array representation
- heapify up/down
- `PriorityQueue`
- custom comparator
- two heaps technique
- heap sort and top-k patterns

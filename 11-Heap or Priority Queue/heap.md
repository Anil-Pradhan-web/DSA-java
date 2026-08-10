# Heap / Priority Queue Theory Notes

## 1. Heap kya hota hai?

Heap ek special tree-based data structure hota hai jo **complete binary tree** ki property follow karta hai. Iska main use hota hai **fast access to min or max element**.

Simple words me:
- heap ek tree hai jisme parent-child ka specific order hota hai
- top par hamesha minimum ya maximum element hota hai
- insert aur remove dono fast hote hain

### Heap ki sabse important property

Har parent node ka value apne children se:
- **Max Heap** me: parent >= children (top par sabse bada element)
- **Min Heap** me: parent <= children (top par sabse chhota element)

```
Max Heap example:
        50
       /  \
     30    40
    /  \   /
   10  20 35

Min Heap example:
        5
       / \
     10   15
    /  \
   20  12
```

---

## 2. Heap vs Priority Queue — kya difference hai?

Ye dono terms aksar ek saath use hoti hain, lekin technically alag hain:

| Concept | Kya hai |
|---|---|
| **Heap** | Data structure (tree-based implementation) |
| **Priority Queue** | Abstract Data Type (ADT) — interface/contract |

### Priority Queue kya hota hai?

Priority Queue ek ADT hai jisme:
- har element ki ek **priority** hoti hai
- highest (ya lowest) priority wala element pehle remove hota hai
- normal queue me FIFO hota hai, lekin priority queue me priority decide karti hai

### Java me kya use hota hai?

Java me `PriorityQueue` class internally **heap** use karti hai. Matlab:
- aap `PriorityQueue` use karte ho
- andar se wo heap ki tarah kaam karta hai

```java
// Min Heap (default behavior)
java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();

// Max Heap (reverse order)
java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
```

---

## 3. Heap ki properties

- Heap ek **complete binary tree** hota hai — matlab saare levels full hote hain, last level left se right bharta hai
- Heap me **left-right order** ka koi rule nahi hota — sirf parent-child ka order important hai
- Heap **sorted** nahi hota — sirf top element guaranteed min/max hota hai
- Heap ko **array** me efficiently represent kiya ja sakta hai

### Array representation

Heap ko array me store karne ka formula:

```
For index i:
- left child  = 2*i + 1
- right child = 2*i + 2
- parent      = (i - 1) / 2
```

Example — Max Heap `[50, 30, 40, 10, 20, 35]`:

```
Index:  0    1    2    3    4    5
Value:  50   30   40   10   20   35

index 0 (50) -> left = 2*0+1 = 1 (30), right = 2*0+2 = 2 (40)
index 1 (30) -> left = 2*1+1 = 3 (10), right = 2*1+2 = 4 (20)
index 2 (40) -> left = 2*2+1 = 5 (35)
```

---

## 4. Java me PriorityQueue ka syntax

### 4.1 Basic operations

```java
import java.util.PriorityQueue;

public class HeapExample {
    public static void main(String[] args) {
        // Min Heap (default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // add element
        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);

        // peek — top element dekho (remove nahi karta)
        System.out.println(minHeap.peek()); // 5 (minimum)

        // poll — top element remove karke return karo
        System.out.println(minHeap.poll()); // 5
        System.out.println(minHeap.poll()); // 10

        // size
        System.out.println(minHeap.size()); // 2

        // empty check
        System.out.println(minHeap.isEmpty()); // false
    }
}
```

### 4.2 Max Heap banana

```java
import java.util.PriorityQueue;
import java.util.Collections;

public class MaxHeapExample {
    public static void main(String[] args) {
        // Max Heap using reverseOrder
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(50);
        maxHeap.add(30);

        System.out.println(maxHeap.peek()); // 50 (maximum)
        System.out.println(maxHeap.poll()); // 50
    }
}
```

### 4.3 Custom objects ke saath

Agar custom class ka object store karna ho, to comparator define karna padta hai.

```java
import java.util.PriorityQueue;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

public class CustomHeapExample {
    public static void main(String[] args) {
        // Min heap by marks
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.marks, b.marks)
        );

        pq.add(new Student("Anil", 85));
        pq.add(new Student("Rahul", 92));
        pq.add(new Student("Priya", 78));

        System.out.println(pq.poll()); // Priya (78) — lowest marks
        System.out.println(pq.poll()); // Anil (85)
        System.out.println(pq.poll()); // Rahul (92)
    }
}
```

### 4.4 Lambda vs Comparator

```java
// Lambda (simple)
PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> a - b);       // min heap
PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);       // max heap

// Comparator (explicit)
PriorityQueue<Integer> pq3 = new PriorityQueue<>(Comparator.naturalOrder());      // min
PriorityQueue<Integer> pq4 = new PriorityQueue<>(Comparator.reverseOrder());      // max
```

---

## 5. Heap operations ka theory

### 5.1 Insert (add)

Naya element hamesha **last position** par add hota hai, phir **bubble up** (heapify up) hota hai.

Steps:
1. Element ko array ke end me add karo
2. Uske parent se compare karo
3. Agar order galat hai to swap karo
4. Jab tak correct position nahi milti, upar jaate raho

```
Insert 15 in Max Heap [50, 30, 40, 10, 20, 35]

Step 1: Add at end -> [50, 30, 40, 10, 20, 35, 15]
Step 2: 15 ka parent = index (6-1)/2 = 2 -> value 40
Step 3: 15 < 40, order sahi hai (max heap me parent bada hona chahiye)
Done!
```

### 5.2 Remove (poll)

Top element remove hota hai, phir **bubble down** (heapify down) hota hai.

Steps:
1. Top element ko last element se replace karo
2. Last element remove karo
3. Naye top ko children se compare karo
4. Bade (max heap) ya chhote (min heap) child se swap karo
5. Jab tak correct position nahi milti, neeche jaate raho

```
Remove top from Max Heap [50, 30, 40, 10, 20, 35]

Step 1: Top (50) ko last (35) se replace -> [35, 30, 40, 10, 20]
Step 2: 50 remove -> [35, 30, 40, 10, 20]
Step 3: 35 ke children = 30 (left), 40 (right)
Step 4: Bada child 40 hai, 35 < 40, swap -> [40, 30, 35, 10, 20]
Step 5: 35 ke children = 10, 20 — dono chhote hain, done!
```

### 5.3 Peek

Sirf top element return karta hai, koi change nahi hota. Complexity `O(1)`.

---

## 6. Time complexity summary

| Operation | Complexity |
|---|---|
| `add()` / `offer()` | `O(log n)` |
| `poll()` / `remove()` | `O(log n)` |
| `peek()` | `O(1)` |
| `size()` | `O(1)` |
| `isEmpty()` | `O(1)` |
| `contains()` | `O(n)` |
| `remove(Object)` | `O(n)` |

**Important:** Heap me search `O(n)` hota hai kyunki heap sorted nahi hota — sirf top guaranteed min/max hota hai.

---

## 7. Heapify — array se heap banana

Agar ek unsorted array diya ho aur usse heap banana ho, to `heapify` use hota hai.

### Java me PriorityQueue se direct

```java
import java.util.PriorityQueue;
import java.util.Arrays;

public class HeapifyExample {
    public static void main(String[] args) {
        int[] nums = {5, 3, 8, 1, 9, 2};

        // Direct array se heap banao
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }

        // Ya ek saath add karo
        PriorityQueue<Integer> heap2 = new PriorityQueue<>();
        for (int num : nums) {
            heap2.offer(num);
        }

        // Sorted order me nikal lo
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " "); // 1 2 3 5 8 9
        }
    }
}
```

### Heap sort concept

Heap se sorted order nikalne ka idea:
1. Saare elements heap me daalo
2. Ek-ek karke poll karo
3. Min heap se ascending order, max heap se descending order

```java
public static void heapSort(int[] nums) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
        minHeap.add(num);
    }

    for (int i = 0; i < nums.length; i++) {
        nums[i] = minHeap.poll();
    }
}
```

---

## 8. PriorityQueue ke important methods

| Method | Kya karta hai |
|---|---|
| `add(e)` | Element add karo (throws exception agar fail ho) |
| `offer(e)` | Element add karo (returns false agar fail ho) |
| `peek()` | Top element dekho, remove nahi karta (null agar empty) |
| `poll()` | Top element remove karke return karo (null agar empty) |
| `remove()` | Top element remove karo (throws exception agar empty) |
| `size()` | Number of elements |
| `isEmpty()` | Empty check |
| `clear()` | Saare elements remove karo |
| `contains(e)` | Element present hai ya nahi |

### add vs offer

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.add(10);   // add — exception throw kar sakta hai
pq.offer(20); // offer — false return karta hai

// Dono ka result same hota hai, bas error handling alag
```

### poll vs remove

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

// Empty queue par:
System.out.println(pq.poll());   // null
// System.out.println(pq.remove()); // throws NoSuchElementException
```

---

## 9. Heap ke use cases

Heap ka use hota hai jab humein **fast min/max access** chahiye:

- **Kth largest/smallest element** — heap se O(n log k) me milta hai
- **Top K elements** — max/min heap use karke
- **Merge K sorted lists** — har list ka head heap me daalo
- **Median finding** — do heaps (max + min) use karke
- **Task scheduling** — priority based execution
- **Dijkstra's algorithm** — shortest path me min heap
- **Sliding window maximum** — deque + heap combination
- **Huffman coding** — min heap se tree build hota hai

---

## 10. Common interview patterns

### 10.1 Kth largest element

```java
import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        // Min heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // extra element remove
            }
        }

        return minHeap.peek(); // kth largest
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2)); // 5
    }
}
```

### 10.2 Top K frequent elements

```java
import java.util.*;

public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Frequency count
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min heap by frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(freq.get(a), freq.get(b))
        );

        for (int key : freq.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 2)); // [1, 2]
    }
}
```

### 10.3 Merge K sorted lists

```java
import java.util.*;

public class MergeKSorted {
    public static List<Integer> mergeKLists(List<List<Integer>> lists) {
        // Min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (List<Integer> list : lists) {
            minHeap.addAll(list);
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 4, 5));
        lists.add(Arrays.asList(1, 3, 4));
        lists.add(Arrays.asList(2, 6));

        System.out.println(mergeKLists(lists)); // [1, 1, 2, 3, 4, 4, 5, 6]
    }
}
```

### 10.4 Find median from data stream

```java
import java.util.PriorityQueue;

public class MedianFinder {
    // Max heap for left half
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    // Min heap for right half
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        // Balance sizes
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2.0
    }
}
```

---

## 11. Heap vs other data structures

| Operation | Heap | Sorted Array | BST |
|---|---|---|---|
| Insert | `O(log n)` | `O(n)` | `O(log n)` avg |
| Get min/max | `O(1)` | `O(1)` | `O(log n)` |
| Remove min/max | `O(log n)` | `O(n)` | `O(log n)` |
| Search | `O(n)` | `O(log n)` | `O(log n)` |
| Memory | `O(n)` | `O(n)` | `O(n)` |

**Key takeaway:** Heap best hai jab sirf min/max access chahiye, search nahi.

---

## 12. Common mistakes in heap problems

- `PriorityQueue` default **min heap** hota hai — max heap ke liye `reverseOrder()` bhool jana
- `peek()` empty queue par `null` deta hai, `remove()` exception throw karta hai
- Custom objects ke liye comparator define karna bhool jana
- Heap sorted nahi hota — sirf top guaranteed min/max hai
- `contains()` O(n) hai, O(1) nahi
- Kth largest ke liye **min heap** use hota hai (size k), max heap nahi
- `add()` vs `offer()` ka difference bhool jana

---

## 13. Quick revision summary

- Heap ek complete binary tree hai
- Max heap: parent >= children, Min heap: parent <= children
- Java me `PriorityQueue` heap implement karta hai
- Default `PriorityQueue` min heap hai
- Max heap ke liye `Collections.reverseOrder()` use karo
- Insert = `O(log n)`, Remove = `O(log n)`, Peek = `O(1)`
- Array representation: left = `2i+1`, right = `2i+2`, parent = `(i-1)/2`
- Kth largest/smallest = heap of size k
- Median = do heaps (max + min)
- Heap search = `O(n)` — sorted nahi hota

---

## 14. Final takeaway

Heap ek powerful data structure hai jo **fast min/max access** deta hai. Java me `PriorityQueue` use karna simple hai, lekin interview me important hai ki:
- kab min heap use karna hai aur kab max heap
- custom comparator kaise likhna hai
- Kth element, Top K, Median jaise patterns kaise solve karte hain

Heap ke 5-6 core problems solve kar lo to interview me ye topic confidently handle ho jata hai.
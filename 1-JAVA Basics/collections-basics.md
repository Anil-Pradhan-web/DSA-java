# Collections Basics in Java - Hinglish Notes

## 1. Collections Framework kya hota hai?

Java Collections Framework ready-made data structures provide karta hai jisse data store aur manage karna easy ho jata hai.

Common collections:

- `ArrayList`
- `LinkedList`
- `HashSet`
- `HashMap`
- `Queue`
- `Deque`
- `PriorityQueue`

## 2. Array vs Collection

### Array

- fixed size
- primitive types directly store kar sakta hai
- basic structure hai

### Collection

- dynamic size
- utility methods milte hain
- wrapper classes use hoti hain

## 3. Generics basics

Generics type safety provide karte hain.

```java
java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
list.add(10);
list.add(20);
```

Yahan sirf `Integer` values allow hongi.

## 4. ArrayList

Dynamic array hota hai.

### Java code

```java
java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
list.add(10);
list.add(20);
list.add(1, 15);
System.out.println(list.get(0));
System.out.println(list.size());
```

### Important methods

- `add()`
- `get()`
- `set()`
- `remove()`
- `size()`
- `contains()`

### Complexity idea

- access = `O(1)`
- add at end = amortized `O(1)`
- insert/delete middle = `O(n)`

## 5. LinkedList

Doubly linked list based collection hai.

```java
java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
list.add(10);
list.addFirst(5);
list.addLast(20);
System.out.println(list.removeFirst());
```

### Useful when

- front/back operations zyada ho
- queue/deque behavior chahiye ho

## 6. HashSet

Unique elements store karta hai.

```java
java.util.HashSet<Integer> set = new java.util.HashSet<>();
set.add(10);
set.add(20);
set.add(10);
System.out.println(set); // duplicate store nahi hoga
```

## 7. LinkedHashSet

Insertion order maintain karta hai.

```java
java.util.LinkedHashSet<Integer> set = new java.util.LinkedHashSet<>();
set.add(20);
set.add(10);
set.add(30);
System.out.println(set);
```

## 8. TreeSet

Sorted order me elements store karta hai.

```java
java.util.TreeSet<Integer> set = new java.util.TreeSet<>();
set.add(30);
set.add(10);
set.add(20);
System.out.println(set);
```

## 9. HashMap

Key-value pairs store karta hai.

```java
java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
map.put("Anil", 90);
map.put("Rahul", 85);
System.out.println(map.get("Anil"));
```

## 10. LinkedHashMap

Insertion order maintain karta hai.

```java
java.util.LinkedHashMap<Integer, String> map = new java.util.LinkedHashMap<>();
map.put(2, "B");
map.put(1, "A");
System.out.println(map);
```

## 11. TreeMap

Sorted keys rakhta hai.

```java
java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
map.put(3, "C");
map.put(1, "A");
map.put(2, "B");
System.out.println(map);
```

## 12. Queue

FIFO structure ke liye queue use hoti hai.

```java
java.util.Queue<Integer> queue = new java.util.LinkedList<>();
queue.offer(10);
queue.offer(20);
System.out.println(queue.poll());
System.out.println(queue.peek());
```

## 13. Deque

Front aur rear dono se operations possible hote hain.

```java
java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
deque.addFirst(10);
deque.addLast(20);
System.out.println(deque.removeFirst());
```

## 14. PriorityQueue

Default min-heap hota hai.

```java
java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
pq.offer(30);
pq.offer(10);
pq.offer(20);
System.out.println(pq.poll()); // 10
```

## 15. Iterating collections

### For-each loop

```java
for (int x : list) {
    System.out.println(x);
}
```

### Map iteration

```java
for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

## 16. `Collections` utility class

Useful helper methods:

```java
java.util.Collections.sort(list);
java.util.Collections.reverse(list);
java.util.Collections.max(list);
java.util.Collections.min(list);
```

## 17. `Arrays` utility class

```java
int[] arr = {3, 1, 2};
java.util.Arrays.sort(arr);
System.out.println(java.util.Arrays.toString(arr));
```

## 18. Common interview confusion points

### Primitive vs wrapper

Collections primitive types directly store nahi karti.

Wrong:

```java
ArrayList<int> list;
```

Correct:

```java
ArrayList<Integer> list;
```

### `HashMap` order guarantee nahi deta

Agar order chahiye:

- insertion order -> `LinkedHashMap`
- sorted order -> `TreeMap`

### `HashSet` duplicate allow nahi karta

## 19. When to use what?

- `ArrayList` -> frequent random access
- `LinkedList` -> front/back insert/delete
- `HashSet` -> unique fast lookup
- `HashMap` -> key-value fast lookup
- `TreeMap` / `TreeSet` -> sorted data
- `Queue` -> FIFO problems
- `Deque` -> stack + queue dono
- `PriorityQueue` -> min/max priority problems

## 20. Quick revision summary

- collections dynamic data structures provide karte hain
- generics type safety dete hain
- `ArrayList` dynamic array hai
- `HashSet` unique elements store karta hai
- `HashMap` key-value pairs store karta hai
- `Queue` FIFO hai
- `Deque` double-ended hai
- `PriorityQueue` default min-heap hai
- wrapper classes collections ke saath use hoti hain

# Hashing in Java for DSA

## 1. Hashing kya hota hai?

Hashing ek technique hai jisme hum data ko quickly store aur retrieve karne ke liye hash function use karte hain. Iska main goal hai **fast O(1) operations**.

Simple words me:
- hashing me ek key ko ek unique index me convert karte hain
- us index par value store ho jati hai
- jab wahi key wapas aati hai, to directly us index se value mil jati hai

DSA me hashing bohot important hai kyunki:
- frequency counting easy ho jata hai
- duplicate detection fast hota hai
- pair sum type problems efficient ho jati hain
- grouping and caching easy hota hai

---

## 2. Hash function kya hota hai?

Hash function ek aisa function hai jo input (key) ko ek integer index ya hash code me convert karta hai.

```
key -> hash function -> bucket/index
```

Example idea:
```
"apple" -> hash function -> 42
"banana" -> hash function -> 17
```

### Good hash function ki properties

1. **Deterministic** — same input ka hamesha same output hona chahiye
2. **Uniform** — keys evenly distribute honi chahiye (sab ek jagah na aayein)
3. **Fast** — quickly compute hona chahiye

---

## 3. HashMap in Java

`HashMap` key-value pairs store karta hai. Ye sabse commonly use hone wala hashing structure hai.

### Java syntax

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // HashMap create karo
        HashMap<String, Integer> map = new HashMap<>();

        // put — key-value add karo
        map.put("apple", 3);
        map.put("banana", 5);
        map.put("orange", 2);

        // get — value retrieve karo
        System.out.println(map.get("apple"));  // 3
        System.out.println(map.get("mango"));  // null (key nahi hai)

        // containsKey — key exist karta hai ya nahi
        System.out.println(map.containsKey("banana"));  // true

        // remove — key-value delete karo
        map.remove("orange");
        System.out.println(map.containsKey("orange"));  // false

        // size — kitni entries hain
        System.out.println(map.size());  // 2

        // getOrDefault — default value with get
        System.out.println(map.getOrDefault("mango", 0));  // 0
    }
}
```

### Important operations

| Method | Kya karta hai |
|---|---|
| `put(key, value)` | Key-value add/update karo |
| `get(key)` | Value retrieve karo (null agar nahi hai) |
| `containsKey(key)` | Key exist karta hai ya nahi |
| `remove(key)` | Key-value delete karo |
| `getOrDefault(key, default)` | Value ya default return karo |
| `size()` | Entries count karo |
| `keySet()` | Saari keys ka set |
| `values()` | Saare values ka collection |

### Iteration ka tarika

```java
// keySet se iterate karo
for (String key : map.keySet()) {
    System.out.println(key + " -> " + map.get(key));
}

// entrySet se iterate karo (faster)
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

### Complexity

- average `get/put/remove` = `O(1)`
- worst case theoretically `O(n)` ho sakta hai collisions ki wajah se, but average case `O(1)` hi use karte hain

---

## 4. HashSet in Java

`HashSet` sirf unique elements store karta hai. Koi key-value nahi hota, sirf keys.

### Java syntax

```java
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // add — element add karo
        set.add(10);
        set.add(20);
        set.add(10);  // duplicate — add nahi hoga
        System.out.println(set.size());  // 2

        // contains — element hai ya nahi
        System.out.println(set.contains(10));  // true
        System.out.println(set.contains(30));  // false

        // remove — element delete karo
        set.remove(20);
        System.out.println(set.contains(20));  // false

        // add returns boolean — duplicate rejection detect karo
        boolean added = set.add(10);
        System.out.println(added);  // false (already tha)
    }
}
```

### HashSet vs HashMap

| HashSet | HashMap |
|---|---|
| Sirf keys store karta hai | Key-value pairs store karta hai |
| `add(element)` | `put(key, value)` |
| `contains(element)` | `containsKey(key)` |
| `remove(element)` | `remove(key)` |
| Duplicate add nahi hota | Duplicate key update hota hai |

---

## 5. LinkedHashMap

`LinkedHashMap` HashMap jaisa hi hai, lekin ye **insertion order maintain** karta hai.

### Java syntax

```java
import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(2, "B");
        map.put(1, "A");
        map.put(3, "C");

        // Insertion order me iterate hota hai
        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
        // Output: 2 -> B, 1 -> A, 3 -> C
    }
}
```

### Use cases

- ordered iteration chahiye ho
- LRU (Least Recently Used) cache style problems

---

## 6. TreeMap

`TreeMap` keys ko **sorted order** me store karta hai. HashMap jaisa fast nahi hai, lekin ordering guarantee deta hai.

### Java syntax

```java
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(5, "E");
        map.put(1, "A");
        map.put(3, "C");
        map.put(2, "B");
        map.put(4, "D");

        // Sorted by keys
        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
        // Output: 1 -> A, 2 -> B, 3 -> C, 4 -> D, 5 -> E

        // Useful methods
        System.out.println(map.firstKey());  // 1 (smallest)
        System.out.println(map.lastKey());   // 5 (largest)
    }
}
```

### Complexity

- `put/get/remove` = `O(log n)` (binary search tree based)

### Map comparison

| Map type | Order | Complexity |
|---|---|---|
| `HashMap` | No order | `O(1)` average |
| `LinkedHashMap` | Insertion order | `O(1)` average |
| `TreeMap` | Sorted by key | `O(log n)` |

---

## 7. Collision resolution

Collision tab hota hai jab do different keys same hash bucket me map ho jayein. Java me two main techniques hain:

## 7.1 Chaining

Chaining me har bucket par ek linked list (ya similar structure) hota hai. Same bucket wale elements chain me store hote hain.

```text
bucket[5] -> (A) -> (B) -> (C)
```

Java `HashMap` internally chaining use karta hai. Modern implementations me jab chain bahut lambi ho jati hai (Java 8+ me 8+ elements), to linked list tree me convert ho jati hai for better performance.

## 7.2 Open Addressing

Open addressing me collision hone par next available slot dhoondhte hain.

### Linear probing

Agar slot occupied hai to next slot try karo:

```text
index, index+1, index+2, ...
```

### Quadratic probing

Quadratic jump se try karo:

```text
index + 1^2, index + 2^2, index + 3^2, ...
```

Interview note:
- Java `HashMap` implementation me chaining use hoti hai
- open addressing ka use Java me nahi hota, but ye concept interview questions me aa sakta hai

---

## 8. Load factor and rehashing

### Load factor

Load factor batata hai ki hash table kitna full ho gaya hai:

```text
load factor = number of elements / number of buckets
```

Default Java load factor = `0.75` — iska matlab 75% full hone par rehash hota hai.

### Rehashing

Jab load factor threshold cross hota hai:
1. nayi (badi) table create hoti hai (usually double size)
2. saare purane elements ko dubara hash karke nayi table me place kiya jata hai

Isse performance maintain rehti hai aur collisions kam hote hain.

---

## 9. Hashing ke important patterns

### 9.1 Frequency counting

Sabse common pattern — har element ki kitni baar aayi hai:

```java
Map<Integer, Integer> freq = new HashMap<>();
for (int num : arr) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

### 9.2 Two Sum (complement search)

Pair find karne ka pattern:

```java
Map<Integer, Integer> seen = new HashMap<>();
for (int i = 0; i < arr.length; i++) {
    int needed = target - arr[i];
    if (seen.containsKey(needed)) {
        // mil gaya pair
    }
    seen.put(arr[i], i);
}
```

### 9.3 Prefix sum

Subarray sum problems ke liye:

```java
Map<Integer, Integer> prefixCount = new HashMap<>();
prefixCount.put(0, 1);
int prefixSum = 0;

for (int num : arr) {
    prefixSum += num;
    if (prefixCount.containsKey(prefixSum - target)) {
        // count += prefixCount.get(prefixSum - target)
    }
    prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
}
```

### 9.4 Sliding window + HashMap

Substring problems me window me character counts track karte hain:

```java
Map<Character, Integer> window = new HashMap<>();
// window me har character ki frequency maintain karo
// left aur right pointers se window slide karo
```

---

## 10. Time complexity summary

| Operation | HashMap | HashSet | TreeMap |
|---|---|---|---|
| Insert | `O(1)` avg | `O(1)` avg | `O(log n)` |
| Delete | `O(1)` avg | `O(1)` avg | `O(log n)` |
| Search | `O(1)` avg | `O(1)` avg | `O(log n)` |
| Contains | `O(1)` avg | `O(1)` avg | `O(log n)` |

| Algorithm pattern | Complexity |
|---|---|
| Frequency count | `O(n)` |
| Two sum | `O(n)` |
| Longest consecutive sequence | `O(n)` average |
| Group anagrams | `O(n * k log k)` |
| Subarray sum equals k | `O(n)` |
| Sliding window + hashmap | `O(n)` |

---

## 11. Common mistakes in hashing

- `null` handling ignore kar dena — `map.get(key)` null return karta hai agar key nahi hai
- `HashMap` aur `TreeMap` ka difference na samajhna — ordering vs speed
- duplicate keys overwrite behavior bhool jana — `put` same key par value overwrite karta hai
- hash-based solution me order assume kar lena — `HashMap` unordered hai
- worst-case vs average-case confusion — average `O(1)`, worst `O(n)`
- `get()` ko double call karna — `getOrDefault` use karke optimize karo
- `remove()` ko `get()` se pehle validate na karna

---

## 12. Quick revision summary

- Hash function deterministic, uniform, and fast hona chahiye
- `HashMap` key-value pairs store karta hai — unordered, `O(1)` average
- `HashSet` unique elements store karta hai
- `LinkedHashMap` insertion order maintain karta hai
- `TreeMap` sorted keys rakhta hai — `O(log n)`
- Collisions chaining se handle hoti hain Java me
- Load factor badhne par rehashing hoti hai (default 0.75)
- Frequency counting, two sum, prefix sum — 3 sabse important patterns
- `getOrDefault` use karo null handling ke liye
- Hashing + sliding window = substring problems

---

## 13. Final takeaway

Hashing DSA ke sabse practical topics me se ek hai. Ye bohot saare `O(n^2)` problems ko `O(n)` average tak reduce kar deta hai.

Java interview ke liye most important practical points:
- `HashMap`, `HashSet`, `LinkedHashMap`, `TreeMap` — kab kya use karna hai
- collision aur rehashing concepts
- frequency count pattern
- two-sum / complement search
- prefix sum pattern
- grouping (anagrams, etc.) aur caching
- hashing + sliding window combination
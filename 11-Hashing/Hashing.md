# Hashing in Java for DSA

## 1. Hashing kya hota hai?

Hashing ek technique hai jisme hum data ko quickly store aur retrieve karne ke liye hash function use karte hain.

Goal:

- fast lookup
- fast insertion
- fast deletion

DSA me hashing bohot important hai because:

- frequency counting easy ho jata hai
- duplicate detection fast hota hai
- pair sum type problems efficient ho jati hain
- grouping and caching easy hota hai

## 2. Hash function kya hota hai?

Hash function input ko ek integer index ya hash code me convert karta hai.

Example idea:

```text
key -> hash function -> bucket/index
```

### Good hash function properties

- deterministic -> same input ka same output
- uniform -> keys evenly distribute honi chahiye
- fast -> quickly compute hona chahiye

## 3. HashMap in Java

`HashMap` key-value pairs store karta hai.

### Important operations

- `put(key, value)`
- `get(key)`
- `containsKey(key)`
- `remove(key)`

### Java code

```java
java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
map.put("apple", 3);
map.put("banana", 5);
System.out.println(map.get("apple")); // 3
```

### Complexity

- average `get/put/remove` = `O(1)`
- worst case theoretically worse ho sakta hai, but average case `O(1)` hi use karte hain

## 4. HashSet in Java

`HashSet` unique elements store karta hai.

### Java code

```java
java.util.HashSet<Integer> set = new java.util.HashSet<>();
set.add(10);
set.add(20);
System.out.println(set.contains(10)); // true
```

### Complexity

- average `add/contains/remove` = `O(1)`

## 5. LinkedHashMap

`LinkedHashMap` insertion order maintain karta hai.

### Java code

```java
java.util.LinkedHashMap<Integer, String> map = new java.util.LinkedHashMap<>();
map.put(2, "B");
map.put(1, "A");
map.put(3, "C");
System.out.println(map); // insertion order maintain hota hai
```

### Use cases

- ordered iteration
- LRU cache style problems

## 6. TreeMap

`TreeMap` keys ko sorted order me store karta hai.

### Java code

```java
java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
map.put(5, "E");
map.put(1, "A");
map.put(3, "C");
System.out.println(map); // sorted by keys
```

### Complexity

- `put/get/remove` = `O(log n)`

## 7. Collision resolution

Collision tab hota hai jab do different keys same bucket me map ho jayein.

## 7.1 Chaining

Chaining me har bucket par linked list ya similar structure hota hai.

Idea:

- same bucket wale multiple elements chain ke form me store hote hain

```text
bucket[5] -> (A) -> (B) -> (C)
```

Java HashMap internally collision handling ke liye chaining idea use karta hai, aur modern implementations me buckets tree bhi ban sakte hain in bad cases.

## 7.2 Open Addressing

Open addressing me collision hone par next available slot dhoondte hain.

### Linear probing

Next slot try karo.

```text
index, index+1, index+2, ...
```

### Quadratic probing

Quadratic jump use hota hai.

```text
index + 1^2, index + 2^2, index + 3^2
```

Interview note:

- Java `HashMap` ke conceptual comparison ke liye ye jaana useful hai
- implementation details alag languages me alag ho sakti hain

## 8. Load factor and rehashing

### Load factor

Load factor approx batata hai ki hash table kitna full ho gaya hai.

Formula idea:

```text
load factor = number of elements / number of buckets
```

### Rehashing

Jab load factor zyada ho jata hai:

- new bigger table banti hai
- old elements dubara hash hoke new table me jate hain

Isse performance maintain rehti hai.

## 9. Applications of hashing

- frequency counting
- two sum
- caching
- grouping data
- duplicate detection
- prefix sum + hashmap
- sliding window support

## 10. Practice Problems

## 10.1 Count frequency of each element

```java
public static java.util.Map<Integer, Integer> countFrequency(int[] arr) {
    java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();

    for (int num : arr) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    return freq;
}
```

## 10.2 Find intersection and union of two arrays

### Intersection

```java
public static java.util.Set<Integer> intersection(int[] a, int[] b) {
    java.util.Set<Integer> set1 = new java.util.HashSet<>();
    java.util.Set<Integer> result = new java.util.HashSet<>();

    for (int x : a) {
        set1.add(x);
    }

    for (int x : b) {
        if (set1.contains(x)) {
            result.add(x);
        }
    }

    return result;
}
```

### Union

```java
public static java.util.Set<Integer> union(int[] a, int[] b) {
    java.util.Set<Integer> result = new java.util.HashSet<>();

    for (int x : a) {
        result.add(x);
    }

    for (int x : b) {
        result.add(x);
    }

    return result;
}
```

## 10.3 Longest consecutive sequence

```java
public static int longestConsecutive(int[] nums) {
    java.util.Set<Integer> set = new java.util.HashSet<>();
    for (int num : nums) {
        set.add(num);
    }

    int longest = 0;

    for (int num : set) {
        if (!set.contains(num - 1)) {
            int current = num;
            int length = 1;

            while (set.contains(current + 1)) {
                current++;
                length++;
            }

            longest = Math.max(longest, length);
        }
    }

    return longest;
}
```

## 10.4 Subarray sum equals k

```java
public static int subarraySum(int[] nums, int k) {
    java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
    map.put(0, 1);

    int sum = 0;
    int count = 0;

    for (int num : nums) {
        sum += num;
        if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
}
```

## 10.5 Group anagrams together

```java
public static java.util.List<java.util.List<String>> groupAnagrams(String[] strs) {
    java.util.Map<String, java.util.List<String>> map = new java.util.HashMap<>();

    for (String str : strs) {
        char[] chars = str.toCharArray();
        java.util.Arrays.sort(chars);
        String key = new String(chars);

        map.computeIfAbsent(key, k -> new java.util.ArrayList<>()).add(str);
    }

    return new java.util.ArrayList<>(map.values());
}
```

## 10.6 Find all duplicates in array

```java
public static java.util.List<Integer> findDuplicates(int[] nums) {
    java.util.Set<Integer> seen = new java.util.HashSet<>();
    java.util.List<Integer> duplicates = new java.util.ArrayList<>();

    for (int num : nums) {
        if (!seen.add(num)) {
            duplicates.add(num);
        }
    }

    return duplicates;
}
```

## 10.7 First recurring character

```java
public static Character firstRecurringCharacter(String s) {
    java.util.Set<Character> seen = new java.util.HashSet<>();

    for (char ch : s.toCharArray()) {
        if (seen.contains(ch)) {
            return ch;
        }
        seen.add(ch);
    }

    return null;
}
```

## 10.8 4Sum problem

```java
public static java.util.List<java.util.List<Integer>> fourSum(int[] nums, int target) {
    java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
    java.util.Arrays.sort(nums);
    int n = nums.length;

    for (int i = 0; i < n - 3; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;

        for (int j = i + 1; j < n - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;

            int left = j + 1;
            int right = n - 1;

            while (left < right) {
                long sum = 1L * nums[i] + nums[j] + nums[left] + nums[right];

                if (sum == target) {
                    result.add(java.util.Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    return result;
}
```

## 10.9 Minimum window substring

Hashing + sliding window ka classic problem.

```java
public static String minWindow(String s, String t) {
    if (s.length() < t.length()) {
        return "";
    }

    java.util.Map<Character, Integer> need = new java.util.HashMap<>();
    for (char ch : t.toCharArray()) {
        need.put(ch, need.getOrDefault(ch, 0) + 1);
    }

    java.util.Map<Character, Integer> window = new java.util.HashMap<>();
    int have = 0;
    int needCount = need.size();
    int left = 0;
    int minLen = Integer.MAX_VALUE;
    int start = 0;

    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        window.put(ch, window.getOrDefault(ch, 0) + 1);

        if (need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()) {
            have++;
        }

        while (have == needCount) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                start = left;
            }

            char leftChar = s.charAt(left);
            window.put(leftChar, window.get(leftChar) - 1);

            if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                have--;
            }

            left++;
        }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
}
```

## 11. Common mistakes in hashing

- `null` handling ignore kar dena
- `HashMap` aur `TreeMap` ka difference na samajhna
- duplicate keys overwrite behavior bhool jana
- hash-based solution me order assume kar lena
- worst-case vs average-case confusion

## 12. Time complexity summary

- `HashMap` get/put = average `O(1)`
- `HashSet` add/contains = average `O(1)`
- `LinkedHashMap` operations = average `O(1)`
- `TreeMap` operations = `O(log n)`
- frequency count = `O(n)`
- longest consecutive sequence = `O(n)` average
- group anagrams = depends on string sorting, often `O(n * k log k)`
- subarray sum equals `k` = `O(n)`

## 13. Quick revision summary

- hash function deterministic, uniform, and fast hona chahiye
- `HashMap` key-value pairs store karta hai
- `HashSet` unique elements store karta hai
- `LinkedHashMap` insertion order maintain karta hai
- `TreeMap` sorted keys rakhta hai
- collisions chaining ya open addressing se handle hoti hain
- load factor badhne par rehashing hoti hai
- hashing frequency counting aur lookup problems me bohot powerful hoti hai

## 14. Final takeaway

Hashing DSA ke sabse practical topics me se ek hai, kyunki ye bohot saare `O(n^2)` problems ko `O(n)` average tak reduce kar deta hai.

Java interview ke liye most important practical points:

- `HashMap`, `HashSet`, `LinkedHashMap`, `TreeMap`
- collision and rehashing concepts
- frequency count
- two-sum / prefix sum ideas
- grouping and caching patterns
- hashing + sliding window combinations

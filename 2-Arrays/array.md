# Arrays in Java for DSA

## 1. Array kya hota hai?

Array ek linear data structure hota hai jo same type ke elements ko contiguous memory me store karta hai.

Java examples:

- `int[] arr = {1, 2, 3, 4, 5};`
- `String[] names = {"Anil", "Raj", "Aman"};`

Why arrays are important:

- fast index-based access
- many data structures arrays ke concept par build hote hain
- interviews me bohot common hain
- sliding window, prefix sum, two pointers jaisi techniques mostly arrays par hi start hoti hain

## 2. Java me array declaration and initialization

### Declaration

```java
int[] arr;
```

### Memory allocation

```java
arr = new int[5];
```

### Declaration + allocation together

```java
int[] arr = new int[5];
```

### Direct initialization

```java
int[] arr = {10, 20, 30, 40, 50};
```

### Default values in Java arrays

Java me agar array `new` se banaya hai, to default values milti hain:

- `int` -> `0`
- `boolean` -> `false`
- `double` -> `0.0`
- object references -> `null`

Example:

```java
int[] arr = new int[3];
System.out.println(arr[0]); // 0
```

## 3. Traversal of array in Java

### Normal for loop

```java
int[] arr = {10, 20, 30, 40};
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + " ");
}
```

### Enhanced for loop

```java
for (int x : arr) {
    System.out.print(x + " ");
}
```

Time complexity:

- traversal = `O(n)`

## 4. Important array properties in Java

- array ka size fixed hota hai
- index `0` se start hota hai
- last index `n - 1` hota hai
- length nikalne ke liye `arr.length` use hota hai, `length()` nahi

Example:

```java
int[] arr = {5, 6, 7};
System.out.println(arr.length); // 3
```

## 5. Basic operations on arrays

### 5.1 Access element

```java
int[] arr = {10, 20, 30};
System.out.println(arr[1]); // 20
```

Time complexity:

- `O(1)`

### 5.2 Update element

```java
arr[1] = 99;
```

Time complexity:

- `O(1)`

### 5.3 Insert at a position in fixed-size array

Fixed-size array me insertion ke liye right shift karna padta hai.

```java
public static int insertAtPosition(int[] arr, int n, int pos, int value) {
    for (int i = n; i > pos; i--) {
        arr[i] = arr[i - 1];
    }
    arr[pos] = value;
    return n + 1;
}
```

Time complexity:

- beginning/middle = `O(n)`
- end = `O(1)` if empty space exists

### 5.4 Delete from a position

```java
public static int deleteAtPosition(int[] arr, int n, int pos) {
    for (int i = pos; i < n - 1; i++) {
        arr[i] = arr[i + 1];
    }
    return n - 1;
}
```

Time complexity:

- `O(n)`

### 5.5 Linear search

```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```

Time complexity:

- best = `O(1)`
- worst = `O(n)`

## 6. Java arrays vs ArrayList

### Array

- fixed size
- primitive types directly store kar sakta hai
- faster and lightweight hota hai

### ArrayList

- dynamic size
- insert/delete easier hota hai from API side
- wrapper classes use hoti hain like `Integer`

Example:

```java
java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
list.add(10);
list.add(20);
```

Interview note:

- DSA me low-level array logic samajhne ke liye array important hai
- practical coding me kabhi kabhi `ArrayList` easier hota hai

## 7. Common array patterns in DSA

## 7.1 Two pointers

Use cases:

- reverse array
- move zeros
- remove duplicates
- two sum in sorted array

Example: reverse array

```java
public static void reverseArray(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
```

Time complexity:

- `O(n)`

## 7.2 Sliding window

Contiguous subarray problems me useful hota hai.

Example: maximum sum of subarray of size `k`

```java
public static int maxSumSubarray(int[] arr, int k) {
    int windowSum = 0;

    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }

    int maxSum = windowSum;

    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
}
```

Time complexity:

- `O(n)`

## 7.3 Prefix sum

Range sum queries fast karne ke liye use hota hai.

Definition:

- `prefix[i] = sum of elements from 0 to i`

```java
public static int[] buildPrefix(int[] arr) {
    int n = arr.length;
    int[] prefix = new int[n];
    prefix[0] = arr[0];

    for (int i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] + arr[i];
    }

    return prefix;
}
```

Range sum from `l` to `r`:

```java
int sum = prefix[r] - (l > 0 ? prefix[l - 1] : 0);
```

Time complexity:

- build prefix = `O(n)`
- query = `O(1)`

## 7.4 Difference array

Range update problems me useful hota hai.

```java
public static void rangeUpdate(int[] diff, int l, int r, int val) {
    diff[l] += val;
    if (r + 1 < diff.length) {
        diff[r + 1] -= val;
    }
}
```

Rebuild final array:

```java
for (int i = 1; i < diff.length; i++) {
    diff[i] += diff[i - 1];
}
```

Time complexity:

- one update = `O(1)`
- final rebuild = `O(n)`

## 7.5 Hashing with arrays

Agar values ya characters fixed range me ho, to array as frequency table use kar sakte ho.

Example:

```java
int[] freq = new int[101];
for (int x : arr) {
    freq[x]++;
}
```

## 8. Common interview problems in Java arrays

## 8.1 Reverse an array

Approach:

- two pointers
- first aur last element swap karte jao

```java
public static void reverse(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
```

## 8.2 Find max and min

```java
public static void printMaxMin(int[] arr) {
    int maxi = arr[0];
    int mini = arr[0];

    for (int x : arr) {
        maxi = Math.max(maxi, x);
        mini = Math.min(mini, x);
    }

    System.out.println("Max = " + maxi);
    System.out.println("Min = " + mini);
}
```

Time complexity:

- `O(n)`

## 8.3 Move zeros to end

```java
public static void moveZeros(int[] arr) {
    int j = 0;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j++;
        }
    }
}
```

Time complexity:

- `O(n)`

## 8.4 Two Sum

Approach:

- use `HashMap`
- for each element, check if `target - arr[i]` already exists

```java
public static int[] twoSum(int[] nums, int target) {
    java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        int need = target - nums[i];
        if (map.containsKey(need)) {
            return new int[]{map.get(need), i};
        }
        map.put(nums[i], i);
    }

    return new int[]{};
}
```

Time complexity:

- `O(n)`

## 8.5 Best time to buy and sell stock

```java
public static int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int profit = 0;

    for (int price : prices) {
        minPrice = Math.min(minPrice, price);
        profit = Math.max(profit, price - minPrice);
    }

    return profit;
}
```

Time complexity:

- `O(n)`

## 8.6 Merge two sorted arrays

```java
public static int[] mergeSorted(int[] a, int[] b) {
    int i = 0, j = 0, k = 0;
    int[] ans = new int[a.length + b.length];

    while (i < a.length && j < b.length) {
        if (a[i] <= b[j]) {
            ans[k++] = a[i++];
        } else {
            ans[k++] = b[j++];
        }
    }

    while (i < a.length) {
        ans[k++] = a[i++];
    }

    while (j < b.length) {
        ans[k++] = b[j++];
    }

    return ans;
}
```

Time complexity:

- `O(n + m)`

## 8.7 Find duplicate number using hashing

```java
public static int findDuplicate(int[] nums) {
    java.util.HashSet<Integer> seen = new java.util.HashSet<>();

    for (int x : nums) {
        if (seen.contains(x)) {
            return x;
        }
        seen.add(x);
    }

    return -1;
}
```

Time complexity:

- `O(n)`

## 8.8 Subarray sum equals K

```java
public static int subarraySum(int[] nums, int k) {
    java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
    map.put(0, 1);

    int sum = 0;
    int count = 0;

    for (int x : nums) {
        sum += x;
        if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
}
```

Time complexity:

- `O(n)`

## 9. Binary search on arrays

Binary search sorted array par apply hoti hai.

```java
public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1;
}
```

Time complexity:

- `O(log n)`

## 10. 2D arrays in Java

Declaration:

```java
int[][] matrix = new int[3][4];
```

Initialization:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

Traversal:

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

Use cases:

- matrices
- grid problems
- graph representation

## 11. Important Java array utilities

### `Arrays.sort()`

```java
import java.util.Arrays;

int[] arr = {4, 1, 3, 2};
Arrays.sort(arr);
```

### `Arrays.toString()`

```java
System.out.println(Arrays.toString(arr));
```

### `Arrays.fill()`

```java
Arrays.fill(arr, 0);
```

## 12. Common mistakes in Java arrays

### Using `length()` instead of `length`

Wrong:

```java
arr.length()
```

Correct:

```java
arr.length
```

### Index out of bounds

Valid indices:

- `0` to `arr.length - 1`

### Empty array case ignore karna

Example:

```java
int[] arr = {};
```

### Fixed size bhool jana

Java arrays resize nahi hote.

## 13. Time complexity cheat sheet

- access by index = `O(1)`
- update by index = `O(1)`
- traversal = `O(n)`
- linear search = `O(n)`
- insertion in middle = `O(n)`
- deletion in middle = `O(n)`
- binary search = `O(log n)` on sorted array

## 14. Quick revision summary

- Java array fixed-size hota hai.
- Length ke liye `arr.length` use hota hai.
- Frequent insert/delete ke liye array best nahi hota.
- Two pointers, sliding window, prefix sum, hashing arrays ke core patterns hain.
- `HashMap`, `HashSet`, `Arrays.sort()`, `Arrays.toString()` practical interviews me bohot useful hote hain.

## 15. Suggested order to practice

1. reverse array
2. max/min in array
3. linear search
4. move zeros to end
5. two sum
6. merge sorted arrays
7. best time to buy and sell stock
8. subarray sum equals `k`
9. binary search
10. 2D matrix traversal

## 16. Final takeaway

Agar arrays Java me strong ho gaye, to tum in topics me bhi strong ho jaoge:

- strings
- sliding window
- hashing
- binary search
- matrices
- dynamic programming basics

Java interview ke liye arrays ka practical focus ye hona chahiye:

- `arr.length`
- loops and traversal
- `HashMap` and `HashSet`
- `Arrays` utility class
- pattern recognition like two pointers and prefix sum

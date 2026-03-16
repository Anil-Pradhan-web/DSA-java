# Searching Algorithms in Java

## 1. Searching kya hota hai?

Searching ka matlab hota hai kisi element ko data structure me find karna.

Example:

- array me `7` present hai ya nahi
- target element kis index par hai
- condition satisfy karne wala smallest ya largest answer kya hai

DSA me searching bohot important hai because:

- interviews me frequently aata hai
- arrays ke saath direct use hota hai
- optimization problems me binary search bahut powerful hota hai

## 2. Linear Search

Linear search me hum array ko left se right tak traverse karte hain aur har element ko target se compare karte hain.

Example:

```text
arr = [4, 2, 7, 1, 9]
target = 7
```

### Java code

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

### Time complexity

- best case = `O(1)`
- worst case = `O(n)`

## 3. Binary Search

Binary search ek efficient searching algorithm hai jo sorted array par kaam karta hai.

Idea:

- middle element nikaalo
- target compare karo
- left half ya right half choose karo

Important condition:

- array sorted honi chahiye

## 4. Binary Search Iterative

```java
public static int binarySearchIterative(int[] arr, int target) {
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

### Complexity

- time = `O(log n)`
- space = `O(1)`

## 5. Binary Search Recursive

```java
public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
    if (left > right) {
        return -1;
    }

    int mid = left + (right - left) / 2;

    if (arr[mid] == target) {
        return mid;
    } else if (arr[mid] < target) {
        return binarySearchRecursive(arr, mid + 1, right, target);
    } else {
        return binarySearchRecursive(arr, left, mid - 1, target);
    }
}
```

### Complexity

- time = `O(log n)`
- space = `O(log n)` due to recursion stack

## 6. Binary Search on Answer

Yahan hum directly element search nahi karte. Hum answer space par binary search lagate hain.

Use when:

- minimum ya maximum possible answer chahiye
- answer monotonic ho

Monotonic ka matlab:

- false false false true true true
- ya true true true false false false

### Generic idea

```java
public static int binarySearchOnAnswer(int low, int high) {
    int answer = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (isPossible(mid)) {
            answer = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return answer;
}
```

## 7. Ternary Search concept

Ternary Search sorted array ya unimodal function ke concept me discuss hota hai.

Basic idea:

- search space ko 2 parts nahi, 3 parts me divide karte hain
- do mid points nikalte hain
- comparison karke ek part eliminate karte hain

For sorted discrete arrays, practical interviews me binary search zyada common hai.

Ternary search zyada useful hota hai jab:

- function unimodal ho
- ek peak ya minimum point dhoondna ho in continuous/discrete optimization settings

### Concept formula

```java
int mid1 = left + (right - left) / 3;
int mid2 = right - (right - left) / 3;
```

Interview note:

- standard array searching ke liye binary search usually enough hota hai
- ternary search conceptually important hai, but less common than binary search

## 8. Exponential Search

Exponential search sorted array me useful hota hai, especially jab target beginning ke paas ho ya array size effectively unknown jaisa scenario ho.

Idea:

- pehle range exponentially expand karo: `1, 2, 4, 8, ...`
- phir us range ke andar binary search lagao

### Java code

```java
public static int exponentialSearch(int[] arr, int target) {
    if (arr.length == 0) {
        return -1;
    }

    if (arr[0] == target) {
        return 0;
    }

    int index = 1;
    while (index < arr.length && arr[index] <= target) {
        index *= 2;
    }

    return binarySearchInRange(arr, target, index / 2, Math.min(index, arr.length - 1));
}

public static int binarySearchInRange(int[] arr, int target, int left, int right) {
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

### Complexity

- range expansion = `O(log i)` where `i` target position hai
- binary search = `O(log i)`
- overall = `O(log i)`

## 9. Important observations for binary search

- sorted array hona zaroori hai
- `mid = left + (right - left) / 2` safer hota hai
- duplicates hone par normal binary search koi bhi valid index de sakta hai
- first occurrence aur last occurrence ke liye modified binary search use hota hai

## 10. Practice Problems

## 10.1 Binary search on sorted array

```java
public static int searchSorted(int[] arr, int target) {
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

## 10.2 First and last occurrence of element

```java
public static int firstOccurrence(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int ans = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            ans = mid;
            right = mid - 1;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return ans;
}

public static int lastOccurrence(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int ans = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            ans = mid;
            left = mid + 1;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return ans;
}
```

## 10.3 Search in rotated sorted array

```java
public static int searchRotated(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[left] <= arr[mid]) {
            if (target >= arr[left] && target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            if (target > arr[mid] && target <= arr[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    return -1;
}
```

## 10.4 Find peak element

```java
public static int findPeakElement(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] < arr[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}
```

## 10.5 Square root using binary search

```java
public static int sqrtBinarySearch(int x) {
    if (x == 0 || x == 1) {
        return x;
    }

    int left = 1;
    int right = x;
    int ans = 0;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        long square = 1L * mid * mid;

        if (square == x) {
            return mid;
        } else if (square < x) {
            ans = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return ans;
}
```

## 10.6 Find minimum in rotated sorted array

```java
public static int findMinRotated(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] > arr[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return arr[left];
}
```

### Complexity

- time = `O(log n)`
- space = `O(1)`

## 10.7 Allocate minimum pages

Question:

- books array diya hai jahan har element pages count batata hai
- `m` students ko books allocate karni hain
- books contiguous manner me assign hongi
- maximum pages assigned to a student minimum karna hai

Ye binary search on answer ka classic problem hai.

### Feasibility helper

```java
public static boolean canAllocate(int[] books, int students, int maxPages) {
    int usedStudents = 1;
    int currentPages = 0;

    for (int pages : books) {
        if (pages > maxPages) {
            return false;
        }

        if (currentPages + pages > maxPages) {
            usedStudents++;
            currentPages = pages;
        } else {
            currentPages += pages;
        }
    }

    return usedStudents <= students;
}
```

### Main solution

```java
public static int allocateMinimumPages(int[] books, int students) {
    if (students > books.length) {
        return -1;
    }

    int low = 0;
    int high = 0;

    for (int pages : books) {
        low = Math.max(low, pages);
        high += pages;
    }

    int answer = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (canAllocate(books, students, mid)) {
            answer = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return answer;
}
```

### Complexity

- time = `O(n log(sum))`
- space = `O(1)`

## 11. Common mistakes in searching problems

### Unsorted array par binary search laga dena

Binary search ke liye sorted order ya monotonic property chahiye hoti hai.

### `left < right` aur `left <= right` me confusion

Normal binary search me mostly `left <= right` use hota hai.

### Wrong mid calculation

```java
int mid = left + (right - left) / 2;
```

### Infinite loop

Pointers ko sahi update karna zaroori hai:

- `left = mid + 1`
- `right = mid - 1`

### Binary search on answer me wrong search space lena

Low aur high carefully choose karne padte hain.

## 12. Time complexity summary

- linear search = `O(n)`
- binary search iterative = `O(log n)`
- binary search recursive = `O(log n)`
- exponential search = `O(log i)`
- first/last occurrence = `O(log n)`
- rotated sorted array search = `O(log n)`
- peak element = `O(log n)`
- square root = `O(log x)`
- find minimum in rotated sorted array = `O(log n)`
- allocate minimum pages = `O(n log(sum))`

## 13. Quick revision summary

- Linear search unsorted array par bhi kaam karta hai.
- Binary search sorted ya monotonic cases me powerful hota hai.
- Iterative binary search zyada practical hota hai.
- Ternary search concept important hai, but standard interviews me binary search zyada common hai.
- Exponential search useful hai jab target beginning ke paas ho ya effective range unknown ho.
- Binary search on answer optimization problems me use hota hai.
- Rotated sorted array problems modified binary search se solve hote hain.
- Allocate minimum pages binary search on answer ka classic problem hai.

## 14. Final takeaway

Searching algorithms me sabse important cheez code ratna nahi, pattern samajhna hai:

- simple search -> linear search
- sorted array -> binary search
- unknown-ish range -> exponential search
- optimization problem -> binary search on answer
- modified sorted structure -> custom binary search

Agar searching ka pattern strong ho gaya, to bohot saare interview problems easy lagne lagte hain.

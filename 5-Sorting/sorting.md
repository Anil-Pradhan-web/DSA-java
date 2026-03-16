# Sorting in Java for DSA

## 1. Sorting kya hota hai?

Sorting ka matlab hota hai elements ko kisi order me arrange karna.

Most common orders:

- increasing order
- decreasing order
- custom order based on frequency, value, ya condition

Example:

```text
[5, 2, 8, 1, 3] -> [1, 2, 3, 5, 8]
```

Sorting DSA me bohot important hai because:

- searching fast ho jati hai
- duplicates handling easy hota hai
- greedy aur interval problems simpler ho jati hain
- interviews me bohot common topic hai

## 2. Bubble Sort

Idea:

- adjacent elements compare karo
- agar wrong order me hain to swap karo
- har pass ke baad largest element end me chala jata hai

### Java code

```java
public static void bubbleSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
        boolean swapped = false;

        for (int j = 0; j < n - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }

        if (!swapped) {
            break;
        }
    }
}
```

### Complexity

- time = `O(n^2)`
- best case with optimization = `O(n)`
- space = `O(1)`
- stable = yes

## 3. Selection Sort

Idea:

- har position ke liye minimum element dhoondo
- usse current index par swap karo

### Java code

```java
public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIndex = i;

        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
```

### Complexity

- time = `O(n^2)`
- space = `O(1)`
- stable = no

## 4. Insertion Sort

Idea:

- current element ko uski correct position par insert karo
- sorted aur unsorted part ka concept use hota hai

### Java code

```java
public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}
```

### Complexity

- time = `O(n^2)`
- best case = `O(n)`
- space = `O(1)`
- stable = yes

### Important point

- nearly sorted arrays ke liye bohot achha hota hai

## 5. Merge Sort

Merge sort divide and conquer algorithm hai.

### Java code

```java
public static void mergeSort(int[] arr, int left, int right) {
    if (left >= right) {
        return;
    }

    int mid = left + (right - left) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }

    while (i <= mid) {
        temp[k++] = arr[i++];
    }

    while (j <= right) {
        temp[k++] = arr[j++];
    }

    for (int p = 0; p < temp.length; p++) {
        arr[left + p] = temp[p];
    }
}
```

### Complexity

- time = `O(n log n)`
- space = `O(n)`
- stable = yes

### Important point

- divide and conquer ka classic example hai

## 6. Quick Sort

Quick sort bhi divide and conquer algorithm hai.

### Java code

```java
public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pivotIndex = partition(arr, low, high);
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
}

public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}
```

### Complexity

- average = `O(n log n)`
- worst = `O(n^2)`
- space = average recursion stack `O(log n)`
- stable = no
- in-place = yes

## 7. Heap Sort

Heap sort binary heap use karta hai.

Idea:

- max heap banao
- root ko end me swap karo
- heap size reduce karo
- heapify repeat karo

### Java code

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

public static void heapify(int[] arr, int n, int i) {
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

### Complexity

- time = `O(n log n)`
- space = `O(1)`
- stable = no

## 8. Counting Sort

Counting sort tab useful hota hai jab integer range small ho.

### Java code

```java
public static void countingSort(int[] arr) {
    int max = arr[0];

    for (int x : arr) {
        max = Math.max(max, x);
    }

    int[] count = new int[max + 1];

    for (int x : arr) {
        count[x]++;
    }

    int index = 0;
    for (int value = 0; value < count.length; value++) {
        while (count[value] > 0) {
            arr[index++] = value;
            count[value]--;
        }
    }
}
```

### Complexity

- time = `O(n + k)`
- space = `O(k)`
- stable = can be made stable in standard implementation

## 9. Radix Sort

Radix sort numbers ko digit by digit sort karta hai.

Idea:

- ones place par sort karo
- tens place par sort karo
- hundreds place par sort karo
- usually stable counting sort as subroutine use hota hai

### Java code

```java
public static void radixSort(int[] arr) {
    int max = arr[0];
    for (int x : arr) {
        max = Math.max(max, x);
    }

    for (int exp = 1; max / exp > 0; exp *= 10) {
        countingSortByDigit(arr, exp);
    }
}

public static void countingSortByDigit(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[10];

    for (int i = 0; i < n; i++) {
        int digit = (arr[i] / exp) % 10;
        count[digit]++;
    }

    for (int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
        int digit = (arr[i] / exp) % 10;
        output[count[digit] - 1] = arr[i];
        count[digit]--;
    }

    for (int i = 0; i < n; i++) {
        arr[i] = output[i];
    }
}
```

### Complexity

- time = `O(nk)`
- space = `O(n + k)` depending on digit base

Here `k` means number of digits.

## 10. Shell Sort

Shell sort insertion sort ka improved version hai.

Idea:

- gap based insertion sort lagao
- pehle bade gap use karo
- gradually gap reduce karo until `1`

### Java code

```java
public static void shellSort(int[] arr) {
    int n = arr.length;

    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j = i;

            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }

            arr[j] = temp;
        }
    }
}
```

### Complexity

- depends on gap sequence
- usually practical improvement over insertion sort
- stable = no

## 11. `Arrays.sort()` in Java

### For primitive arrays

```java
import java.util.Arrays;

int[] arr = {5, 2, 9, 1};
Arrays.sort(arr);
```

### Important interview note

- primitive arrays ke liye `Arrays.sort()` internally Dual-Pivot QuickSort use karta hai
- object arrays ke liye implementation alag ho sakti hai

## 12. Stable vs unstable sorting

### Stable sorts

- Bubble Sort
- Insertion Sort
- Merge Sort
- Counting Sort standard stable version

### Unstable sorts

- Selection Sort
- Quick Sort
- Heap Sort
- Shell Sort

## 13. Quick comparison

- Bubble Sort -> simple, stable, slow
- Selection Sort -> simple, not stable
- Insertion Sort -> stable, nearly sorted arrays ke liye good
- Merge Sort -> stable, guaranteed `O(n log n)`
- Quick Sort -> average fast, in-place
- Heap Sort -> `O(n log n)`, not stable
- Counting Sort -> small integer range ke liye
- Radix Sort -> digit by digit sorting
- Shell Sort -> improved insertion sort

## 14. Practice Problems

## 14.1 Sort array of 0s, 1s, 2s

Dutch National Flag problem.

```java
public static void sortColors(int[] arr) {
    int low = 0;
    int mid = 0;
    int high = arr.length - 1;

    while (mid <= high) {
        if (arr[mid] == 0) {
            int temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
            low++;
            mid++;
        } else if (arr[mid] == 1) {
            mid++;
        } else {
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
            high--;
        }
    }
}
```

## 14.2 Merge two sorted arrays without extra space

Simple gap method idea use kar sakte ho.

```java
public static void mergeWithoutExtraSpace(int[] a, int[] b) {
    int n = a.length;
    int m = b.length;
    int gap = (n + m + 1) / 2;

    while (gap > 0) {
        int i = 0;
        int j = gap;

        while (j < n + m) {
            int first = getValue(a, b, i, n);
            int second = getValue(a, b, j, n);

            if (first > second) {
                setValue(a, b, i, second, n);
                setValue(a, b, j, first, n);
            }
            i++;
            j++;
        }

        if (gap == 1) {
            break;
        }
        gap = (gap + 1) / 2;
    }
}

public static int getValue(int[] a, int[] b, int index, int n) {
    return index < n ? a[index] : b[index - n];
}

public static void setValue(int[] a, int[] b, int index, int value, int n) {
    if (index < n) {
        a[index] = value;
    } else {
        b[index - n] = value;
    }
}
```

## 14.3 Find kth smallest element using QuickSelect

```java
public static int quickSelect(int[] arr, int low, int high, int k) {
    int pivotIndex = partition(arr, low, high);

    if (pivotIndex == k) {
        return arr[pivotIndex];
    } else if (pivotIndex > k) {
        return quickSelect(arr, low, pivotIndex - 1, k);
    } else {
        return quickSelect(arr, pivotIndex + 1, high, k);
    }
}
```

Usage:

```java
int kthSmallest = quickSelect(arr, 0, arr.length - 1, k - 1);
```

## 14.4 Sort characters by frequency

```java
public static String frequencySort(String s) {
    java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();

    for (char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    java.util.List<Character> list = new java.util.ArrayList<>(map.keySet());
    list.sort((a, b) -> map.get(b) - map.get(a));

    StringBuilder sb = new StringBuilder();
    for (char ch : list) {
        int freq = map.get(ch);
        for (int i = 0; i < freq; i++) {
            sb.append(ch);
        }
    }

    return sb.toString();
}
```

## 14.5 Merge overlapping intervals

```java
public static int[][] mergeIntervals(int[][] intervals) {
    java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    java.util.List<int[]> result = new java.util.ArrayList<>();

    for (int[] interval : intervals) {
        if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
            result.add(new int[]{interval[0], interval[1]});
        } else {
            result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
        }
    }

    return result.toArray(new int[result.size()][]);
}
```

## 14.6 Sort array by parity

Even numbers pehle, odd numbers baad me.

```java
public static void sortArrayByParity(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        if (nums[left] % 2 > nums[right] % 2) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        if (nums[left] % 2 == 0) {
            left++;
        }

        if (nums[right] % 2 == 1) {
            right--;
        }
    }
}
```

## 15. Common mistakes in sorting

- sorting algorithm ko blindly use kar dena
- stable vs unstable sort ignore kar dena
- extra space ko ignore kar dena
- quick sort ke worst case ko bhool jana
- counting sort ko large range par use kar dena

## 16. Time complexity summary

- Bubble Sort = `O(n^2)`
- Selection Sort = `O(n^2)`
- Insertion Sort = `O(n^2)`
- Merge Sort = `O(n log n)`
- Quick Sort average = `O(n log n)`
- Quick Sort worst = `O(n^2)`
- Heap Sort = `O(n log n)`
- Counting Sort = `O(n + k)`
- Radix Sort = `O(nk)`
- Shell Sort = gap sequence dependent
- QuickSelect average = `O(n)`

## 17. Quick revision summary

- Bubble and Insertion stable hote hain
- Selection, Quick, Heap, Shell usually unstable hote hain
- Merge Sort stable aur divide and conquer based hota hai
- Quick Sort in-place hota hai aur practical bohot important hai
- Counting Sort aur Radix Sort non-comparison style sorting me aate hain
- `Arrays.sort()` primitive arrays me Dual-Pivot QuickSort use karta hai
- Dutch National Flag, intervals, QuickSelect aur parity sorting common interview questions hain

## 18. Final takeaway

Sorting DSA ka core topic hai jo bohot saare problems ko simplify karta hai.

Java interview ke liye most important practical points:

- `Arrays.sort()`
- merge sort recursion
- quick sort partition logic
- heap sort idea
- counting/radix sort use cases
- QuickSelect
- interval sorting patterns

Agar sorting strong ho gayi, to searching, greedy, intervals, two pointers aur custom comparator problems kaafi easy ho jaati hain.

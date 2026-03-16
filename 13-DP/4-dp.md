# Dynamic Programming in Java for DSA - Part 4

## 1. Advanced DP Topics

## 1.1 Longest Increasing Subsequence (O(n^2) DP)

```java
public static int lengthOfLISDP(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    java.util.Arrays.fill(dp, 1);
    int ans = 1;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        ans = Math.max(ans, dp[i]);
    }

    return ans;
}
```

## 1.2 Longest Increasing Subsequence (O(n log n))

```java
public static int lengthOfLISBinarySearch(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;

    for (int num : nums) {
        int left = 0, right = size;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        tails[left] = num;
        if (left == size) {
            size++;
        }
    }

    return size;
}
```

## 1.3 Matrix Chain Multiplication

Interval DP.

```java
public static int matrixChainOrder(int[] arr) {
    int n = arr.length;
    int[][] dp = new int[n][n];

    for (int len = 2; len < n; len++) {
        for (int i = 1; i < n - len + 1; i++) {
            int j = i + len - 1;
            dp[i][j] = Integer.MAX_VALUE;

            for (int k = i; k < j; k++) {
                dp[i][j] = Math.min(dp[i][j],
                    dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j]);
            }
        }
    }

    return dp[1][n - 1];
}
```

## 1.4 Palindrome Partitioning - minimum cuts

```java
public static int minCut(String s) {
    int n = s.length();
    boolean[][] palindrome = new boolean[n][n];
    int[] dp = new int[n];

    for (int end = 0; end < n; end++) {
        dp[end] = end;
        for (int start = 0; start <= end; start++) {
            if (s.charAt(start) == s.charAt(end) &&
                (end - start <= 2 || palindrome[start + 1][end - 1])) {
                palindrome[start][end] = true;
                if (start == 0) {
                    dp[end] = 0;
                } else {
                    dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                }
            }
        }
    }

    return dp[n - 1];
}
```

## 1.5 Burst Balloons

```java
public static int maxCoins(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n + 2];
    arr[0] = 1;
    arr[n + 1] = 1;
    for (int i = 0; i < n; i++) {
        arr[i + 1] = nums[i];
    }

    int[][] dp = new int[n + 2][n + 2];

    for (int len = 1; len <= n; len++) {
        for (int left = 1; left <= n - len + 1; left++) {
            int right = left + len - 1;
            for (int k = left; k <= right; k++) {
                dp[left][right] = Math.max(dp[left][right],
                    arr[left - 1] * arr[k] * arr[right + 1] +
                    dp[left][k - 1] + dp[k + 1][right]);
            }
        }
    }

    return dp[1][n];
}
```

## 1.6 DP on Trees

Tree DP me answer subtree based states par depend karta hai.

Example:

- tree diameter
- tree matching
- subtree sums

### Rerooting technique

Concept:

- ek root se answer nikalo
- root shift karke baki nodes ke answers efficiently nikalo

Interview note:

- conceptually bahut important hai
- implementation thoda advanced hota hai

## 1.7 DP on Bitmasks

Small `n` subset problems ke liye useful.

State often hota hai:

- `dp[mask]`
- `dp[mask][i]`

Use cases:

- travelling salesman style
- assignment problems
- subset enumeration

## 1.8 Digit DP

Digit constraints wale counting problems ke liye.

Examples:

- numbers with no repeated digits
- sum of digits constraint
- range counting problems

State often hota hai:

- current index
- tight bound
- started/non-started
- extra custom state

## 1.9 DP with states - stock buy/sell with cooldown, transaction limit

State example:

- day index
- buy/sell permission
- cooldown
- transactions left

## 2. Practice Problems

## 2.1 Longest Increasing Subsequence

Use both `lengthOfLISDP()` and `lengthOfLISBinarySearch()`.

## 2.2 Matrix Chain Multiplication

Use `matrixChainOrder()`.

## 2.3 Palindrome Partitioning

Use `minCut()`.

## 2.4 Partition equal subset sum

Covered in `2-dp.md`.

## 2.5 Best time to buy stock with cooldown

Covered in `1-dp.md`.

## 3. Time complexity reminders

- LIS DP = `O(n^2)`
- LIS binary search = `O(n log n)`
- matrix chain multiplication = `O(n^3)`
- palindrome partitioning = `O(n^2)` to `O(n^3)` style depending on implementation
- burst balloons = `O(n^3)`

## 4. Final revision summary

- interval DP me range `[i...j]` common hoti hai
- LIS ka binary search optimization bohot important hai
- DP on trees, bitmasks, digits advanced interview topics hain
- stock DP state machine type problems me aata hai
- recurrence relation samajhna sabse important skill hai

## 5. Final takeaway

Dynamic Programming DSA ke hardest but most rewarding topics me se ek hai.

Java interview ke liye most important practical points:

- memoization vs tabulation difference
- state define karna
- recurrence likhna
- base case identify karna
- space optimize karna
- interval DP, string DP, knapsack, LIS, stock DP patterns pe strong hona

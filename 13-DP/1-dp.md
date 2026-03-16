# Dynamic Programming in Java for DSA - Part 1

## 1. Dynamic Programming kya hota hai?

Dynamic Programming (DP) ek optimization technique hai jisme hum repeated subproblems ka answer store karte hain taaki same calculation baar baar na karni pade.

## 2. Core concepts

### Overlapping subproblems

Same subproblem multiple times solve ho raha hota hai.

Example:

- Fibonacci me `fib(3)` baar baar calculate hota hai

### Optimal substructure

Final optimal solution, smaller optimal solutions se build hota hai.

Example:

- shortest path
- knapsack
- LCS

## 3. Memoization (top-down DP)

Recursion + cache.

- pehle recursion socho
- repeated states ko array ya `HashMap` me store karo

### Java example: Fibonacci memoization

```java
public static int fibMemo(int n, int[] dp) {
    if (n <= 1) {
        return n;
    }

    if (dp[n] != -1) {
        return dp[n];
    }

    dp[n] = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
    return dp[n];
}
```

## 4. Tabulation (bottom-up DP)

Iterative approach hota hai.

- base cases se table fill karte hain
- final answer table ke end me aata hai

### Java example: Fibonacci tabulation

```java
public static int fibTab(int n) {
    if (n <= 1) {
        return n;
    }

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
}
```

## 5. Space optimization in DP

Kabhi full 2D ya large array ki zarurat nahi hoti.

Agar current state sirf previous few states par depend karti ho, to memory reduce kar sakte hain.

### Java example: Fibonacci space optimized

```java
public static int fibOptimized(int n) {
    if (n <= 1) {
        return n;
    }

    int prev2 = 0;
    int prev1 = 1;

    for (int i = 2; i <= n; i++) {
        int current = prev1 + prev2;
        prev2 = prev1;
        prev1 = current;
    }

    return prev1;
}
```

## 6. DP solve karne ka general approach

1. state define karo
2. recurrence relation likho
3. base case define karo
4. memoization ya tabulation choose karo
5. possible ho to space optimize karo

## 7. 1D DP Problems

## 7.1 Fibonacci sequence

Already covered above.

## 7.2 Climbing stairs

`n`th stair tak pahunchne ke total ways.

```java
public static int climbStairs(int n) {
    if (n <= 2) {
        return n;
    }

    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
}
```

## 7.3 House robber

Adjacent houses ek saath rob nahi kar sakte.

```java
public static int rob(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    if (nums.length == 1) {
        return nums[0];
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
    }

    return dp[nums.length - 1];
}
```

## 7.4 House robber II

Circular array version.

```java
public static int rob2(int[] nums) {
    if (nums.length == 1) {
        return nums[0];
    }
    return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
}

private static int robRange(int[] nums, int start, int end) {
    int prev2 = 0;
    int prev1 = 0;

    for (int i = start; i <= end; i++) {
        int current = Math.max(prev1, nums[i] + prev2);
        prev2 = prev1;
        prev1 = current;
    }

    return prev1;
}
```

## 7.5 Jump game

Can reach last index?

```java
public static boolean canJump(int[] nums) {
    int maxReach = 0;

    for (int i = 0; i < nums.length; i++) {
        if (i > maxReach) {
            return false;
        }
        maxReach = Math.max(maxReach, i + nums[i]);
    }

    return true;
}
```

## 7.6 Jump game II

Minimum jumps to reach last index.

```java
public static int jump(int[] nums) {
    int jumps = 0;
    int currentEnd = 0;
    int farthest = 0;

    for (int i = 0; i < nums.length - 1; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (i == currentEnd) {
            jumps++;
            currentEnd = farthest;
        }
    }

    return jumps;
}
```

## 7.7 Decode ways

```java
public static int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
        return 0;
    }

    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        int oneDigit = s.charAt(i - 1) - '0';
        int twoDigits = Integer.parseInt(s.substring(i - 2, i));

        if (oneDigit >= 1) {
            dp[i] += dp[i - 1];
        }
        if (twoDigits >= 10 && twoDigits <= 26) {
            dp[i] += dp[i - 2];
        }
    }

    return dp[n];
}
```

## 8. Practice Problems

## 8.1 Fibonacci (memoization vs tabulation)

Use `fibMemo()` and `fibTab()`.

## 8.2 Climbing stairs

Use `climbStairs()`.

## 8.3 Best time to buy stock with cooldown

DP with states example.

```java
public static int maxProfitCooldown(int[] prices) {
    if (prices.length == 0) {
        return 0;
    }

    int hold = -prices[0];
    int sold = 0;
    int rest = 0;

    for (int i = 1; i < prices.length; i++) {
        int prevSold = sold;
        sold = hold + prices[i];
        hold = Math.max(hold, rest - prices[i]);
        rest = Math.max(rest, prevSold);
    }

    return Math.max(sold, rest);
}
```

## 9. Quick revision summary

- DP repeated subproblems ko optimize karta hai
- memoization = recursion + cache
- tabulation = iterative table filling
- space optimization bahut important interview skill hai
- 1D DP me state aksar index based hoti hai

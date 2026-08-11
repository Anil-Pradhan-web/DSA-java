# Dynamic Programming in Java for DSA - Part 2

## 1. 2D / Grid DP Problems

## 1.1 Unique paths in a grid

```java
public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
        dp[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
        dp[0][j] = 1;
    }

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }

    return dp[m - 1][n - 1];
}
```

## 1.2 Unique paths II (with obstacles)

```java
public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];

    if (obstacleGrid[0][0] == 1) {
        return 0;
    }

    dp[0][0] = 1;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[i][j] == 1) {
                dp[i][j] = 0;
            } else {
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }
    }

    return dp[m - 1][n - 1];
}
```

## 1.3 Minimum path sum in a grid

```java
public static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];

    dp[0][0] = grid[0][0];

    for (int i = 1; i < m; i++) {
        dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int j = 1; j < n; j++) {
        dp[0][j] = dp[0][j - 1] + grid[0][j];
    }

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        }
    }

    return dp[m - 1][n - 1];
}
```

## 1.4 Triangle minimum path sum

```java
public static int minimumTotal(java.util.List<java.util.List<Integer>> triangle) {
    int n = triangle.size();
    int[] dp = new int[n + 1];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
            dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
        }
    }

    return dp[0];
}
```

## 1.5 Dungeon game

```java
public static int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length;
    int n = dungeon[0].length;
    int[][] dp = new int[m + 1][n + 1];

    for (int[] row : dp) {
        java.util.Arrays.fill(row, Integer.MAX_VALUE);
    }

    dp[m][n - 1] = 1;
    dp[m - 1][n] = 1;

    for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
            int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
            dp[i][j] = Math.max(1, need);
        }
    }

    return dp[0][0];
}
```

## 1.6 Maximal square of 1s in binary matrix

```java
public static int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m + 1][n + 1];
    int maxSide = 0;

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (matrix[i - 1][j - 1] == '1') {
                dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
    }

    return maxSide * maxSide;
}
```

## 2. Knapsack DP Patterns

## 2.1 0/1 Knapsack

Har item ko ya to lo ya chhodo.

```java
public static int knapsack01(int[] wt, int[] val, int W) {
    int n = wt.length;
    int[][] dp = new int[n + 1][W + 1];

    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= W; w++) {
            dp[i][w] = dp[i - 1][w];
            if (wt[i - 1] <= w) {
                dp[i][w] = Math.max(dp[i][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
            }
        }
    }

    return dp[n][W];
}
```

## 2.2 Unbounded Knapsack

Item multiple times use ho sakta hai.

```java
public static int unboundedKnapsack(int[] wt, int[] val, int W) {
    int[] dp = new int[W + 1];

    for (int w = 0; w <= W; w++) {
        for (int i = 0; i < wt.length; i++) {
            if (wt[i] <= w) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }
    }

    return dp[W];
}
```

## 2.3 Coin change - minimum coins needed

```java
public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    java.util.Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (coin <= i) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
    }

    return dp[amount] > amount ? -1 : dp[amount];
}
```

## 2.4 Coin change II - number of ways

```java
public static int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
        for (int x = coin; x <= amount; x++) {
            dp[x] += dp[x - coin];
        }
    }

    return dp[amount];
}
```

## 2.5 Subset sum problem

```java
public static boolean subsetSum(int[] nums, int target) {
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    for (int num : nums) {
        for (int sum = target; sum >= num; sum--) {
            dp[sum] = dp[sum] || dp[sum - num];
        }
    }

    return dp[target];
}
```

## 2.6 Partition equal subset sum

```java
public static boolean canPartition(int[] nums) {
    int total = 0;
    for (int num : nums) {
        total += num;
    }

    if (total % 2 != 0) {
        return false;
    }

    return subsetSum(nums, total / 2);
}
```

## 2.7 Target sum

```java
public static int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) {
        sum += num;
    }

    if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
        return 0;
    }

    int subset = (sum + target) / 2;
    int[] dp = new int[subset + 1];
    dp[0] = 1;

    for (int num : nums) {
        for (int s = subset; s >= num; s--) {
            dp[s] += dp[s - num];
        }
    }

    return dp[subset];
}
```

## 2.8 Last stone weight II

```java
public static int lastStoneWeightII(int[] stones) {
    int total = 0;
    for (int stone : stones) {
        total += stone;
    }

    int target = total / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    for (int stone : stones) {
        for (int j = target; j >= stone; j--) {
            dp[j] = dp[j] || dp[j - stone];
        }
    }

    for (int j = target; j >= 0; j--) {
        if (dp[j]) {
            return total - 2 * j;
        }
    }

    return 0;
}
```

## 3. Practice Problems

- coin change (min coins)
- coin change II (number of ways)
- 0/1 knapsack
- partition equal subset sum
- unique paths in grid
- minimum path sum

## 4. Quick revision summary

- grid DP me state aksar cell based hoti hai
- knapsack me include/exclude ya reuse pattern common hota hai
- 0/1 vs unbounded difference bahut important hai
- 2D DP ko kabhi 1D me optimize kiya ja sakta hai

# Recursion and Backtracking in Java

## 1. Recursion kya hota hai?

Recursion ek technique hai jahan koi function khud ko hi call karta hai problem ko chhote parts me todne ke liye.

Simple idea:

- problem ko smaller same type problem me convert karo
- ek stopping condition rakho
- function baar baar khud ko call karega jab tak base case hit na ho

Example:

```java
public static int factorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    }
    return n * factorial(n - 1);
}
```

## 2. Recursion ke core parts

### Base case

Wo condition jahan function ruk jata hai.

Agar base case nahi hoga to infinite recursion ho sakti hai.

### Recursive call

Function same problem ka smaller version call karta hai.

### Call stack

Java me har recursive call stack memory me store hota hai.

Har stack frame me hota hai:

- parameters
- local variables
- return address

Jab function return karta hai, uska frame stack se remove hota hai.

## 3. Recursion ka flow kaise samjhein?

Har recursive function ke liye 3 questions poochho:

1. ye function exactly kya solve karta hai?
2. base case kya hai?
3. smaller problem me kaise reduce ho raha hai?

Example:

```java
factorial(4)
= 4 * factorial(3)
= 4 * 3 * factorial(2)
= 4 * 3 * 2 * factorial(1)
= 24
```

## 4. Recursion tree visualization

Recursion tree visual way hai samajhne ka ki calls kaise branch ho rahe hain.

Example: Fibonacci

```text
fib(5)
|- fib(4)
|  |- fib(3)
|  |  |- fib(2)
|  |  |- fib(1)
|  |- fib(2)
|- fib(3)
   |- fib(2)
   |- fib(1)
```

Ye tree batata hai:

- repeated calls kaha ho rahe hain
- time complexity kyu badh rahi hai
- memoization kyu useful hota hai

## 5. Stack overflow and how to prevent it

### Stack overflow kab hota hai?

- base case missing ho
- recursion bohot deep ho jaye
- smaller problem ki taraf reduce na ho

Dangerous example:

```java
public static void badRecursion(int n) {
    badRecursion(n + 1);
}
```

Ye eventually `StackOverflowError` de sakta hai.

### Prevent kaise karein?

- base case clearly likho
- ensure karo input reduce ho raha hai
- bohot deep recursion me iterative solution socho
- memoization use karo where repeated calls ho rahe hon

## 6. Tail recursion and tail call optimization

Tail recursion me recursive call function ka last operation hota hai.

Example:

```java
public static int factorialTail(int n, int ans) {
    if (n == 0 || n == 1) {
        return ans;
    }
    return factorialTail(n - 1, ans * n);
}
```

Yahan recursive call ke baad koi extra work nahi hota.

### Tail call optimization

Kuch languages tail recursive calls ko optimize kar deti hain.

Important Java note:

- Java generally tail call optimization provide nahi karta
- isliye tail recursion likhne ke baad bhi stack overflow ka risk deep cases me reh sakta hai

## 7. Difference between recursion and iteration

### Recursion

- function khud ko call karta hai
- elegant hota hai
- tree, divide-and-conquer, backtracking me natural lagta hai
- extra stack space leta hai

### Iteration

- loops use karta hai
- memory efficient hota hai
- simple traversal ya counting problems me easy hota hai

## 8. When to use recursion vs iteration

### Recursion use karo jab:

- problem naturally smaller same problem me toot rahi ho
- tree ya graph DFS type logic ho
- subsets, permutations, backtracking ho
- divide and conquer ho

### Iteration use karo jab:

- simple loops se kaam ho raha ho
- recursion depth bohot large ho sakti ho
- memory optimize karni ho

## 9. Backtracking kya hota hai?

Backtracking ek technique hai jahan hum:

- ek choice lete hain
- recursively aage badhte hain
- galat path par undo karte hain
- next possibility try karte hain

Simple words me:

- try all possibilities
- undo the wrong path
- prune where possible

### Core pattern

1. choose
2. explore
3. unchoose
4. prune if needed

Template:

```java
public static void backtrack(...) {
    if (baseCondition) {
        addAnswer();
        return;
    }

    for (...) {
        if (!validChoice) {
            continue;
        }

        choose();
        backtrack(...);
        undo();
    }
}
```

## 10. Pruning kya hota hai?

Pruning ka matlab unnecessary branches ko jaldi cut kar dena.

Example:

- target negative ho gaya -> aage explore mat karo
- invalid Sudoku placement -> recursion stop karo
- queen unsafe position par hai -> branch skip karo

Pruning se performance kaafi improve hoti hai.

## 11. Practice Problems

## 11.1 Factorial

```java
public static int factorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    }
    return n * factorial(n - 1);
}
```

### Complexity

- time = `O(n)`
- space = `O(n)`

## 11.2 Fibonacci recursive

```java
public static int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

### Complexity

- time = exponential
- space = `O(n)`

## 11.3 Fibonacci memoized

```java
public static int fibonacciMemo(int n, int[] dp) {
    if (n <= 1) {
        return n;
    }

    if (dp[n] != -1) {
        return dp[n];
    }

    dp[n] = fibonacciMemo(n - 1, dp) + fibonacciMemo(n - 2, dp);
    return dp[n];
}
```

Usage:

```java
int n = 6;
int[] dp = new int[n + 1];
java.util.Arrays.fill(dp, -1);
System.out.println(fibonacciMemo(n, dp));
```

### Complexity

- time = `O(n)`
- space = `O(n)`

## 11.4 Power function using fast exponentiation

```java
public static long power(long a, long b) {
    if (b == 0) {
        return 1;
    }

    long half = power(a, b / 2);

    if (b % 2 == 0) {
        return half * half;
    }

    return a * half * half;
}
```

### Complexity

- time = `O(log b)`
- space = `O(log b)`

## 11.5 Print all subsets / subsequences of an array

```java
public static void printSubsets(int[] arr, int index, java.util.List<Integer> current) {
    if (index == arr.length) {
        System.out.println(current);
        return;
    }

    current.add(arr[index]);
    printSubsets(arr, index + 1, current);

    current.remove(current.size() - 1);
    printSubsets(arr, index + 1, current);
}
```

### Complexity

- time = `O(2^n)`
- space = `O(n)` excluding output

## 11.6 Generate all permutations of a string

```java
public static void permuteString(char[] arr, int index) {
    if (index == arr.length) {
        System.out.println(new String(arr));
        return;
    }

    for (int i = index; i < arr.length; i++) {
        swap(arr, index, i);
        permuteString(arr, index + 1);
        swap(arr, index, i);
    }
}

public static void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```

## 11.7 Generate all valid parentheses combinations

```java
public static void generateParentheses(int open, int close, String current,
                                       java.util.List<String> result) {
    if (open == 0 && close == 0) {
        result.add(current);
        return;
    }

    if (open > 0) {
        generateParentheses(open - 1, close, current + "(", result);
    }

    if (close > open) {
        generateParentheses(open, close - 1, current + ")", result);
    }
}
```

## 11.8 N-Queens problem

```java
public static void solveNQueens(char[][] board, int row) {
    int n = board.length;

    if (row == n) {
        printBoard(board);
        return;
    }

    for (int col = 0; col < n; col++) {
        if (isSafe(board, row, col)) {
            board[row][col] = 'Q';
            solveNQueens(board, row + 1);
            board[row][col] = '.';
        }
    }
}

public static boolean isSafe(char[][] board, int row, int col) {
    for (int i = 0; i < row; i++) {
        if (board[i][col] == 'Q') {
            return false;
        }
    }

    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q') {
            return false;
        }
    }

    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
        if (board[i][j] == 'Q') {
            return false;
        }
    }

    return true;
}
```

## 11.9 Sudoku solver

```java
public static boolean solveSudoku(char[][] board) {
    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == '.') {
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isValid(board, row, col, ch)) {
                        board[row][col] = ch;

                        if (solveSudoku(board)) {
                            return true;
                        }

                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
    }
    return true;
}

public static boolean isValid(char[][] board, int row, int col, char ch) {
    for (int i = 0; i < 9; i++) {
        if (board[row][i] == ch || board[i][col] == ch) {
            return false;
        }

        int subRow = 3 * (row / 3) + i / 3;
        int subCol = 3 * (col / 3) + i % 3;
        if (board[subRow][subCol] == ch) {
            return false;
        }
    }
    return true;
}
```

## 11.10 Rat in a maze with obstacles

Assume:

- `1` means open
- `0` means blocked

```java
public static boolean solveMaze(int[][] maze, int row, int col, int[][] path) {
    int n = maze.length;

    if (row == n - 1 && col == n - 1 && maze[row][col] == 1) {
        path[row][col] = 1;
        return true;
    }

    if (isSafeMaze(maze, row, col) && path[row][col] == 0) {
        path[row][col] = 1;

        if (solveMaze(maze, row + 1, col, path)) {
            return true;
        }

        if (solveMaze(maze, row, col + 1, path)) {
            return true;
        }

        if (solveMaze(maze, row - 1, col, path)) {
            return true;
        }

        if (solveMaze(maze, row, col - 1, path)) {
            return true;
        }

        path[row][col] = 0;
    }

    return false;
}

public static boolean isSafeMaze(int[][] maze, int row, int col) {
    int n = maze.length;
    return row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1;
}
```

## 11.11 Combination sum with repetition

```java
public static void combinationSum(int[] candidates, int target, int index,
                                  java.util.List<Integer> current,
                                  java.util.List<java.util.List<Integer>> result) {
    if (target == 0) {
        result.add(new java.util.ArrayList<>(current));
        return;
    }

    if (index == candidates.length || target < 0) {
        return;
    }

    current.add(candidates[index]);
    combinationSum(candidates, target - candidates[index], index, current, result);
    current.remove(current.size() - 1);

    combinationSum(candidates, target, index + 1, current, result);
}
```

## 11.12 Word break problem using backtracking

```java
public static boolean wordBreak(String s, java.util.Set<String> dict, int start) {
    if (start == s.length()) {
        return true;
    }

    for (int end = start + 1; end <= s.length(); end++) {
        String prefix = s.substring(start, end);
        if (dict.contains(prefix) && wordBreak(s, dict, end)) {
            return true;
        }
    }

    return false;
}
```

## 11.13 Palindrome partitioning

```java
public static void partition(String s, int start, java.util.List<String> current,
                             java.util.List<java.util.List<String>> result) {
    if (start == s.length()) {
        result.add(new java.util.ArrayList<>(current));
        return;
    }

    for (int end = start; end < s.length(); end++) {
        if (isPalindrome(s, start, end)) {
            current.add(s.substring(start, end + 1));
            partition(s, start + (end - start + 1), current, result);
            current.remove(current.size() - 1);
        }
    }
}

public static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
```

## 12. How to identify recursion and backtracking problems

Agar problem me ye signs dikhen, to recursion/backtracking ho sakta hai:

- all possible answers chahiye
- valid arrangements generate karne hain
- choose and undo pattern dikh raha ho
- subsets, permutations, paths, boards, combinations involved ho
- branching multiple choices ho

## 13. Common mistakes in recursion and backtracking

### Base case galat likhna

Ye sabse common mistake hai.

### Input reduce na karna

Agar smaller problem nahi ban raha, recursion infinite ho sakti hai.

### Undo step bhool jana

Backtracking me add/remove, place/unplace dono carefully karne hote hain.

### Mutable list ka direct result me use

Correct pattern:

```java
result.add(new java.util.ArrayList<>(current));
```

### Pruning na karna

Unnecessary branches explore karne se solution slow ho jata hai.

## 14. Time complexity intuition

- factorial = `O(n)`
- Fibonacci recursive = exponential
- Fibonacci memoized = `O(n)`
- fast exponentiation = `O(log n)`
- subsets = `O(2^n)`
- permutations = `O(n * n!)`
- valid parentheses, N-Queens, Sudoku, maze, combination sum, palindrome partitioning = exponential-style search problems

Exact complexity pruning aur constraints par depend karti hai.

## 15. Quick revision summary

- recursion me base case + recursive call + call stack understanding zaroori hai
- recursion tree repeated work ko expose karta hai
- Java me deep recursion stack overflow de sakti hai
- tail recursion concept useful hai, but Java tail call optimize nahi karta
- recursion vs iteration choice problem nature par depend karti hai
- backtracking = choose, explore, undo, prune
- memoization repeated recursive calls ko optimize karta hai

## 16. Final takeaway

Recursion aur backtracking DSA ke sabse important mindset topics me se hain.

Java interview ke liye most important practical points:

- base case sahi likho
- recursive function ka meaning clear rakho
- stack behavior samjho
- prune karna seekho
- undo step kabhi mat bhoolo
- result me mutable list ki copy store karo

Agar recursion strong ho gayi, to trees, graphs, DP, backtracking aur divide-and-conquer problems kaafi easy lagne lagti hain.

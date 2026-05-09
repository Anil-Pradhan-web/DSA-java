# Recursion and Backtracking Theory Notes

## 1. Recursion kya hota hai?

Recursion ek aisi technique hai jahan function apne aap ko hi call karta hai, lekin chhote ya simpler version ke saath. Idea ye hota hai ki badi problem ko same type ki chhoti problem me tod diya jaaye.

Core thinking:
- current step handle karo
- baaki problem recursive call par chhod do
- base case aane par recursion ruk jaati hai

## 1.1 Recursion ka Java syntax

Recursion me base case aur recursive call ka structure yeh hota hai:

```java
public static int factorial(int n) {
    if (n <= 1) {
        return 1; // base case
    }
    return n * factorial(n - 1); // recursive case
}

public static void printReverse(String s, int idx) {
    if (idx < 0) return;
    System.out.print(s.charAt(idx));
    printReverse(s, idx - 1);
}
```

Important syntax points:
- base case condition sabse pehle check karo
- recursive call ko smaller input ke saath do
- function call stack unwind hota hai jab base case milta hai

## 2. Recursion kyun important hai?

Recursion DSA me isliye important hai kyunki:
- trees naturally recursive hote hain
- divide and conquer recursion par based hota hai
- backtracking recursion ka advanced form hai
- combinations, permutations, partitions jaisi problems recursion-friendly hoti hain
- many DP problems recursion + memoization se start hote hain

## 3. Base Case kya hota hai?

Base case wo condition hoti hai jahan function bina aur recursive call kiye direct answer return karta hai.

Agar base case nahi hogi:
- recursion kabhi nahi rukegi
- stack overflow aa sakta hai

Achhi base case:
- reachable honi chahiye
- simplest input handle kare
- recursion ko truly stop kare

## 4. Recursive Case kya hota hai?

Recursive case me function problem ko chhota karta hai aur khud ko dobara call karta hai.

Important:
- problem har call me chhoti honi chahiye
- warna recursion loop me fas sakti hai

Examples of reduction:
- `n` ko `n - 1` kar dena
- index ko aage badha dena
- half problem solve karna
- tree me child node par jaana

## 5. Call Stack ka role

Jab recursive function call hota hai, har call ek stack frame banata hai.

Har stack frame me hota hai:
- parameters
- local variables
- return point

Execution flow:
- recursion deeper jaati hai
- base case hit hoti hai
- phir stack unwind hota hai
- answers upar return hote hain

## 6. Winding aur Unwinding

Recursion ko do phases me samajh sakte hain:

### Winding Phase

Jab recursive calls niche ja rahi hoti hain.

### Unwinding Phase

Jab base case ke baad calls wapas return hoti hain.

Ye concept especially useful hota hai:
- factorial
- reverse print
- tree traversals
- backtracking undo steps

## 7. Recursion ka mental model

Har recursion question ke liye ye 3 sawaal poochho:

1. Function exactly kya karta hai?
2. Base case kya hai?
3. Problem har step me chhoti kaise ho rahi hai?

Ye 3 sawaal clear ho gaye to recursion ka code likhna easy ho jaata hai.

## 8. Recursion tree kya hota hai?

Recursion tree recursive calls ka visual representation hota hai.

Isse samajh aata hai:
- branching factor kya hai
- depth kitni hai
- repeated subproblems aa rahe hain ya nahi
- time complexity kis type ki hogi

Example thinking:
- Fibonacci me branching 2 hoti hai
- Subsets me har element include/exclude hota hai
- Permutations me branching remaining choices ke according hoti hai

## 9. Recursion ke common types

### 9.1 Linear Recursion

Har call se sirf ek recursive call hoti hai.

Examples:
- factorial
- power
- reverse string
- palindrome check

### 9.2 Binary / Tree Recursion

Ek call se multiple recursive calls hoti hain.

Examples:
- Fibonacci
- subsets
- merge sort

### 9.3 Divide and Conquer Recursion

Problem ko parts me todkar recursively solve karte hain, phir combine karte hain.

Examples:
- merge sort
- quick sort
- binary search

### 9.4 Backtracking Recursion

Choices try karte hain, recurse karte hain, phir undo karke next option try karte hain.

Examples:
- subsets
- permutations
- word search
- N-Queens

## 10. Recursion vs Iteration

### Recursion ke pros

- clean and natural for trees and backtracking
- problem statement ke close lagta hai
- divide and conquer me elegant hota hai

### Recursion ke cons

- stack space use karta hai
- deep recursion me stack overflow risk hota hai
- kabhi-kabhi iterative approach zyada efficient hoti hai

### Iteration ke pros

- extra stack nahi lagta
- often faster hota hai
- large input sizes par safer hota hai

## 11. Recursion kab use karni chahiye?

Recursion use karo jab:
- problem naturally self-similar ho
- trees/graphs involve hon
- all possibilities generate karni ho
- divide and conquer apply ho raha ho
- choose/explore/undo pattern ho

Iteration prefer karo jab:
- simple loop enough ho
- recursion depth bahut large ho sakti ho
- space optimization important ho

## 12. Pure Recursion kya hoti hai?

Pure recursion se matlab basic recursion problems jahan major focus hota hai:
- function calling itself
- base case
- smaller subproblem

Yahan abhi state-space exploration ya backtracking nahi hota.

Examples:
- Fibonacci
- Power of Two
- Reverse String
- Climbing Stairs
- Pow(x, n)
- Reverse Linked List

## 13. Backtracking kya hota hai?

Backtracking recursion ka advanced form hai jahan:
- ek choice lo
- us path ko explore karo
- agar valid nahi hua to undo karo
- next choice try karo

Simple words me:
backtracking = recursion + choice + undo

## 14. Backtracking kyun powerful hai?

Backtracking tab useful hoti hai jab:
- saare valid answers chahiye
- multiple choices available hon
- constraints satisfy karni ho
- trial and error jaisa pattern ho

Examples:
- subsets
- permutations
- combinations
- generate parentheses
- sudoku
- word search

## 15. Universal Backtracking Template

Backtracking ka standard flow hota hai:

1. base case check karo
2. current answer record karo ya return karo
3. possible choices par loop chalao
4. choose karo
5. recurse karo
6. undo karo

Mental formula:
- choose
- explore
- unchoose

## 16. Choose / Explore / Undo

### Choose

Current state me ek option add karo.

### Explore

Recursive call ke through aage badho.

### Undo

Jo choice li thi use wapas hata do taaki next branch clean state se chale.

Agar undo skip kar diya:
- next recursive branches wrong state dekhenge
- answer galat ho jayega

## 17. Pruning kya hoti hai?

Pruning ka matlab:
- useless branches ko pehle hi cut kar dena
- aise path explore hi na karna jo valid answer tak nahi pahunch sakte

Examples:
- combination sum me sum target se bada ho gaya
- duplicates skip karna
- invalid parentheses count
- sudoku me illegal placement

Pruning backtracking ko practical banati hai.

## 18. Backtracking ke 4 core subtypes

## 18.1 Subsets / Power Set

Har element ke liye 2 choices hoti hain:
- include
- exclude

Time complexity usually `O(2^n)`

Examples:
- Subsets
- Subsets II
- non-decreasing subsequences

## 18.2 Permutations

Order matter karta hai.
Har step par remaining elements me se ek choose hota hai.

Time complexity roughly `O(n * n!)`

Examples:
- Permutations
- Permutations II

## 18.3 Combinations / Combination Sum

Order matter nahi karta.
Usually start index maintain hota hai taaki duplicate orderings na aayein.

Examples:
- Combinations
- Combination Sum
- Combination Sum II
- Combination Sum III

## 18.4 Constraint Satisfaction

Valid arrangement dhoondhna hota hai rules follow karte hue.

Examples:
- Generate Parentheses
- Word Search
- N-Queens
- Sudoku Solver
- Restore IP Addresses

## 19. Duplicate handling in backtracking

Input me duplicates ho to repeated answers aane ka risk hota hai.

Common strategy:
- input ko sort karo
- same level par duplicate choices skip karo

Important distinction:
- same branch me reuse allowed hai ya nahi
- same level duplicates skip karne hain ya globally

Ye especially important hai:
- Subsets II
- Permutations II
- Combination Sum II

## 20. Start index vs visited array

Backtracking problems me ye do tools bahut common hote hain:

### Start Index

Use when:
- order matter nahi karta
- combination/subset type problem hai

### Visited Array

Use when:
- permutation type problem hai
- ek element ko ek baar use karna hai

## 21. Backtracking decision tree

Problem dekhkar pehle ye decide karo:

### Kya order matter karta hai?

- Yes -> permutation type
- No -> combination/subset type

### Kya duplicates hain?

- Yes -> sort + skip duplicate logic
- No -> direct recursion possible

### Kya constraints satisfy karni hain?

- Yes -> state validation + pruning

### Kya grid/board diya hai?

- DFS/backtracking likely

## 22. Memoization kya hoti hai?

Memoization ka matlab:
- same subproblem ka answer cache kar lena
- next time same input aaye to directly stored answer use karna

Ye recursion ko optimize karti hai.

Common use:
- Fibonacci
- Climbing Stairs
- Decode Ways
- Word Break

## 23. Recursion + Memoization = Top Down DP

Jab recursive solution me overlapping subproblems hote hain,
tab memoization lagakar usse efficient banaya ja sakta hai.

Ye top-down dynamic programming hoti hai.

Difference:
- plain recursion repeated work karti hai
- memoized recursion repeated work avoid karti hai

## 24. Common recursion patterns

### n -> n - 1 reduction

Examples:
- factorial
- fibonacci
- reverse print

### left/right split

Examples:
- merge sort
- binary search

### index traversal

Examples:
- reverse string
- palindrome
- combinations

### choose / not choose

Examples:
- subsets
- subset sum

### path building

Examples:
- generate parentheses
- restore IP addresses

## 25. Common mistakes in recursion

- base case bhool jaana
- base case reachable na hona
- recursive call me input chhota na karna
- return value ka misuse
- stack overflow ka risk ignore karna
- dry run na karna

## 26. Common mistakes in backtracking

- undo step bhool jaana
- duplicate handling skip karna
- invalid branch ko prune na karna
- mutable list ko directly result me store kar dena without copy
- wrong start index use karna
- permutation me visited tracking bhool jaana

## 27. Time complexity intuition

### Pure recursion

- linear recursion often `O(n)`
- divide and conquer often `O(log n)` ya `O(n log n)`
- naive fibonacci `O(2^n)`

### Backtracking

- subsets -> `O(2^n)`
- permutations -> `O(n!)`
- combinations -> problem-dependent
- grid backtracking -> worst case exponential

Important:
- backtracking me exact complexity often branch factor aur depth par depend karti hai

## 28. Space complexity intuition

Recursion me extra space mostly call stack se aati hai.

### Linear recursion

`O(n)` stack depth

### Divide and conquer

Often `O(log n)` depth

### Backtracking

Usually recursion depth + current path storage

Note:
- answer storage ko often separate consider kiya jaata hai

## 29. Company-wise expectation

### Service-based companies

Mostly ask:
- Fibonacci
- factorial
- palindrome recursion
- power
- reverse string

### Mid-tier product companies

Ask:
- subsets
- permutations
- combination sum
- generate parentheses
- word search

### FAANG-style interviews

Ask:
- advanced backtracking
- pruning based questions
- N-Queens
- Sudoku
- Word Break II
- hard follow-ups

## 30. Must-do recursion/backtracking foundations

Sabse strong base ye problems banati hain:
- Subsets
- Permutations
- Combination Sum
- Generate Parentheses
- Word Search
- N-Queens

Ye 6 problems samajh aa gayin to baaki kaafi patterns easy lagte hain.

## 31. Problem identification cheat sheet

### "All subsets" ya "all possible choices" diya hai

-> subset/backtracking

### "Order matters"

-> permutation

### "Target sum" aur "choose numbers"

-> combination sum

### "Valid arrangement" ya "rules satisfy"

-> constraint satisfaction

### "Count ways"

-> recursion + DP/memoization likely

### "Partition string"

-> backtracking or DP

## 32. Recursion interview strategy

Interview me recursion solve karte waqt:

1. Function contract define karo
2. Base case bolo
3. Recursive reduction explain karo
4. Dry run karo small input par
5. Time and space complexity batao
6. Agar repeated work dikhe to memoization discuss karo

## 33. Backtracking interview strategy

Backtracking solve karte waqt:

1. State kya hai?
2. Choice kya hai?
3. Base case kya hai?
4. Pruning kya ho sakti hai?
5. Duplicate handling kaise hogi?
6. Undo step kaise hoga?

## 34. Pure recursion vs backtracking

### Pure recursion

- answer usually ek hota hai
- direct recurrence relation hoti hai
- choose/undo nahi hota

### Backtracking

- multiple answers explore hote hain
- decision tree banta hai
- choose/explore/undo hota hai

## 35. Final takeaway

Recursion ka core hai:
- base case
- smaller subproblem
- trust the recursive call

Backtracking ka core hai:
- choice
- exploration
- undo
- pruning

Agar tum problem dekhkar ye identify kar pao ki:
- ye pure recursion hai
- ye memoization wali recursion hai
- ye subsets/permutations/combinations/constraint backtracking hai

to recursion folder ka real purpose complete ho jaata hai.

## Recursion & Backtracking — Complete Interview Guide

### ⚠️ Basic distinction
- Recursion = function khud ko call karta hai.
- Backtracking = recursion + undo jab wrong path mile.

### Part 1 — Pure Recursion Problems (Service-based / Mid tier)
Common easy-medium recursion problems:
- Fibonacci Number (#509) — TCS, Wipro, All
- Power of Two (#231) — TCS, Infosys
- Reverse String (#344) — Wipro, Capgemini
- Palindrome Check (recursion) (#125) — TCS, Cognizant
- Climbing Stairs (#70) — Amazon, Google, Microsoft
- Pow(x, n) (#50) — Amazon, Adobe, Google
- Reverse Linked List (recursion) (#206) — Amazon, Microsoft
- Merge Two Sorted Lists (#21) — Amazon, Microsoft, Google

### Part 2 — Backtracking (FAANG core patterns)
Backtracking patterns ka samajh bahut zaroori hai:
- Subsets / Power Set
- Permutations
- Combinations / Combination Sum
- Constraint satisfaction problems

#### Subtype 1: Subsets / Power Set
- Har element ya to include hota hai ya exclude
- Time complexity typically `O(2^n)`
- Examples: Subsets (#78), Subsets II (#90), Non-decreasing Subsequences (#491)

#### Subtype 2: Permutations
- Order matters
- Time complexity roughly `O(n × n!)`
- Examples: Permutations (#46), Permutations II (#47), Next Permutation (#31), Permutation in String (#567)

#### Subtype 3: Combinations / Combination Sum
- Order nahi matter karta
- Start index ya reuse logic zaroori hoti hai
- Examples: Combinations (#77), Combination Sum (#39), Combination Sum II (#40), Combination Sum III (#216), Letter Combinations of Phone Number (#17)

#### Subtype 4: Constraint Satisfaction
- Rules ke saath valid arrangement dhoondhna hota hai
- Examples: Generate Parentheses (#22), Word Search (#79), Palindrome Partitioning (#131), Restore IP Addresses (#93), N-Queens (#51), Sudoku Solver (#37), Word Break II (#140)

### Universal Backtracking Template — Java
```java
List<List<Integer>> result = new ArrayList<>();

void backtrack(int[] nums, int start, List<Integer> current) {
    result.add(new ArrayList<>(current));
    // if (current.size() == target) return; // for fixed-size answers

    for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i] == nums[i - 1]) continue; // duplicate pruning

        current.add(nums[i]);
        backtrack(nums, i + 1, current); // for subsets/combinations
        // backtrack(nums, i, current); // for combination sum allowing reuse
        current.remove(current.size() - 1);
    }
}
```

### Decision tree — pattern identify karo
- Sabhi possible arrangements chahiye?
  - YES → order matters? → permutation
  - NO → combination/subset
- Constraints follow karne hain?
  - grid/matrix → word search, sudoku
  - valid string structure → parentheses, palindrome partitioning
  - placement problem → N-Queens, restore IP
- Duplicates hain input mein?
  - YES → sort + skip duplicates
  - NO → direct backtracking

### Company-wise guide
- TCS / Wipro / Infosys: basic recursion, reverse string, palindrome recursion
- Cognizant / Capgemini: string recursion, simple backtracking
- Amazon: Letter Combinations, Subsets, Word Search, Generate Parentheses
- Microsoft: Permutations, Palindrome Partitioning, N-Queens
- Google: N-Queens, Sudoku Solver, Word Break II, hard backtracking variants
- Meta: Subsets, Permutations, progressive follow-ups

### Must-do problems
- #78 Subsets
- #46 Permutations
- #39 Combination Sum
- #22 Generate Parentheses
- #79 Word Search
- #51 N-Queens

### Key complexity rules
- Subsets: `O(2^n)`
- Permutations: `O(n × n!)`
- Combinations: `O(n choose k)`
- Constraint grid search: worst `O(4^n)`

### Final recursion-backtracking tip
Recursion strong ho tab tum problem ko call stack aur base case se turant solve kar sakte ho.
Backtracking strong ho tab tum choice, explore, undo ka pattern carry karke FAANG-style hard problems bhi handle kar sakte ho.

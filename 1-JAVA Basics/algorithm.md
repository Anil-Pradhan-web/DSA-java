# Analysis of Algorithms in Hinglish

Ye file algorithm analysis ke basics ko simple Hinglish me explain karti hai. Focus ye samajhne par hai ki code kitna time aur memory use karega, especially input size badhne par.

---

## 1. Analysis of Algorithms kya hota hai?

Jab hum koi program ya algorithm likhte hain, to do important cheezein dekhte hain:

- Kitna **time** lagega?
- Kitni **memory/space** lagegi?

Algorithm analysis ka matlab hota hai in dono cheezon ko measure karna in terms of input size `n`.

Example:

- Agar array me `10` elements hain to kaam kam hoga
- Agar array me `10,00,000` elements hain to same logic bahut zyada time le sakta hai

Isliye hum exact seconds count nahi karte, balki growth dekhte hain.

---

## 2. Time Complexity

Time complexity batati hai ki input size `n` ke according algorithm kitni fast ya slow grow karega.

Important:

- Ye actual stopwatch time nahi hota
- Ye number of operations ka growth batata hai

Example:

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Yahan loop `n` baar chal raha hai, isliye time complexity `O(n)` hai.

---

## 3. Big O, Omega, Theta

Ye teen notations complexity ko describe karne ke liye use hote hain.

### Big O Notation - Upper Bound

Big O batata hai maximum growth ya upper bound.

Simple language me:
"Worst side se algorithm kitna grow kar sakta hai?"

Example:

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Iska Big O hai `O(n)`.

### Omega Notation - Lower Bound

Omega batata hai minimum growth ya lower bound.

Simple language me:
"At least itna kaam to hoga hi."

Example:

Agar loop hamesha `n` baar chalta hai, to uska Omega bhi `O(n)` type growth ka hi hoga, proper notation me `Omega(n)`.

### Theta Notation - Tight Bound

Theta tab use hota hai jab upper bound aur lower bound same order ke ho.

Simple language me:
"Actual growth isi range ke around fix hai."

Example:

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Yahan:

- Big O = `O(n)`
- Omega = `Omega(n)`
- Theta = `Theta(n)`

Matlab algorithm exactly linear grow kar raha hai.

---

## 4. Common Time Complexities

| Complexity | Name | Intuition |
|---|---|---|
| `O(1)` | Constant | input badhe, kaam almost same |
| `O(log n)` | Logarithmic | har step me problem half hoti hai |
| `O(n)` | Linear | input ke saath directly grow |
| `O(n log n)` | Linearithmic | sorting algorithms me common |
| `O(n^2)` | Quadratic | nested loops |
| `O(n^3)` | Cubic | 3 nested loops |
| `O(2^n)` | Exponential | recursion me bahut fast grow |
| `O(n!)` | Factorial | very expensive |

### Example of `O(1)`

```java
int first = arr[0];
System.out.println(first);
```

Chahe array chhota ho ya bada, first element access karne me same time lagta hai.

### Example of `O(log n)`

Binary search me har step me search space half hoti hai.

### Example of `O(n^2)`

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```

Outer loop `n` times aur inner loop bhi `n` times.
Total operations `n * n = n^2`.

---

## 5. Space Complexity

Space complexity batati hai algorithm kitni memory use karega.

Isme do cheezein hoti hain:

- Input space
- Auxiliary space

### Input Space
Jo memory input ko store karne ke liye lagti hai.

Example:
Agar `n` size ka array input me diya gaya hai, to us array ki memory input space hai.

### Auxiliary Space
Extra memory jo algorithm input ke alawa use karta hai.

Example:

```java
int sum = 0;
for (int i = 0; i < n; i++) {
    sum += arr[i];
}
```

Yahan:

- Input array ki memory = input space
- `sum`, `i` jaise variables = auxiliary space

Auxiliary space `O(1)` hai.

### Example with extra array

```java
int[] copy = new int[n];
for (int i = 0; i < n; i++) {
    copy[i] = arr[i];
}
```

Yahan extra `copy` array ban raha hai, to auxiliary space `O(n)` hai.

---

## 6. Calculating Complexity in Loops

Loop analysis complexity nikalne ka sabse common part hai.

### Case 1: Single loop

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Loop `n` baar chala.
Time complexity = `O(n)`

### Case 2: Two separate loops

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}

for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Pehla loop `n`, dusra loop bhi `n`.
Total = `n + n = 2n`

Big O me constants ignore karte hain, so result = `O(n)`

### Case 3: Nested loop

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```

Time complexity = `O(n^2)`

### Case 4: Dependent inner loop

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j <= i; j++) {
        System.out.println(i + " " + j);
    }
}
```

Yahan iterations:

- 1
- 2
- 3
- ...
- n

Total = `1 + 2 + 3 + ... + n = n(n + 1)/2`

Big O = `O(n^2)`

### Case 5: Loop halving or doubling

```java
for (int i = 1; i < n; i = i * 2) {
    System.out.println(i);
}
```

Values of `i`:
`1, 2, 4, 8, 16...`

Ye powers of 2 me badh raha hai, isliye complexity = `O(log n)`

### Case 6: Loop dividing by 2

```java
for (int i = n; i >= 1; i = i / 2) {
    System.out.println(i);
}
```

Har step me value half ho rahi hai.
Complexity = `O(log n)`

---

## 7. Calculating Complexity in Recursion

Recursion me function khud ko call karta hai, to complexity nikalte waqt dekhna hota hai:

- Har call me kitna kaam ho raha hai?
- Total kitni recursive calls ho rahi hain?

### Example 1: Simple recursion

```java
int fun(int n) {
    if (n == 0) {
        return 0;
    }
    return fun(n - 1);
}
```

Yahan recursion `n` times call ho rahi hai.
Har call me constant work hai.

Time complexity = `O(n)`
Auxiliary space = `O(n)` because recursion call stack use ho raha hai.

### Example 2: Recursion with extra work

```java
int fun(int n) {
    if (n == 0) {
        return 0;
    }
    return n + fun(n - 1);
}
```

Har call me constant kaam aur total `n` calls.
Time complexity = `O(n)`

### Example 3: Binary recursion

```java
int fib(int n) {
    if (n <= 1) {
        return n;
    }
    return fib(n - 1) + fib(n - 2);
}
```

Yahan har call 2 aur calls kar rahi hai.
Isliye growth bahut fast hai.

Time complexity approximately `O(2^n)` hoti hai.

### Example 4: Recursion halving the problem

```java
int fun(int n) {
    if (n <= 1) {
        return 1;
    }
    return fun(n / 2);
}
```

Har call me problem half ho rahi hai.
Time complexity = `O(log n)`

---

## 8. Best, Worst, Average Cases

Same algorithm ka performance input par depend kar sakta hai.

### Best Case
Sabse favorable situation.

### Worst Case
Sabse kharab situation.

### Average Case
Normal ya expected situation.

### Example: Linear Search

```java
int linearSearch(int[] arr, int key) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == key) {
            return i;
        }
    }
    return -1;
}
```

#### Best Case
Key first index par mil gaya.
Complexity = `O(1)`

#### Worst Case
Key last me hai ya hai hi nahi.
Complexity = `O(n)`

#### Average Case
Generally around middle ke aas-paas milta hai.
Complexity = `O(n)`

### Example: Binary Search

Sorted array me kaam karta hai.

- Best case = `O(1)` when middle element hi answer ho
- Worst case = `O(log n)`
- Average case = `O(log n)`

---

## 9. Rules to Remember While Finding Complexity

### Rule 1: Constants ignore karo

`O(2n)` ko `O(n)` likhte hain

### Rule 2: Lower-order terms ignore karo

`O(n^2 + n + 10)` ko `O(n^2)` likhte hain

### Rule 3: Nested loops multiply hote hain

`n * n = n^2`

### Rule 4: Separate blocks add hote hain

`O(n) + O(log n) = O(n)`

Bigger term dominate karega.

### Rule 5: Recursive call stack space mat bhoolo

Time ke saath space bhi dekhna hai.

---

## 10. Solved Code Snippet Practice

Ye section GeeksforGeeks type questions ke liye useful hai.

### Snippet 1

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Answer:
- Time = `O(n)`
- Space = `O(1)`

### Snippet 2

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

Answer:
- Time = `O(n^2)`
- Space = `O(1)`

### Snippet 3

```java
for (int i = 1; i < n; i *= 2) {
    System.out.println(i);
}
```

Answer:
- Time = `O(log n)`
- Space = `O(1)`

### Snippet 4

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {
        System.out.println(i + " " + j);
    }
}
```

Answer:
- Time = `O(n^2)`
- Space = `O(1)`

### Snippet 5

```java
int fun(int n) {
    if (n == 0) {
        return 0;
    }
    return fun(n - 1);
}
```

Answer:
- Time = `O(n)`
- Auxiliary space = `O(n)`

### Snippet 6

```java
int fun(int n) {
    if (n <= 1) {
        return 1;
    }
    return fun(n / 2);
}
```

Answer:
- Time = `O(log n)`
- Auxiliary space = `O(log n)`

---

## 11. Kaise Socho Complexity Nikalte Time

Jab bhi koi code snippet mile, ye steps follow karo:

1. Dekho loop kitni baar chalega
2. Agar nested loop hai to multiplication socho
3. Agar alag blocks hain to addition socho
4. Agar `i *= 2` ya `i /= 2` ho raha hai to `log n` socho
5. Agar recursion hai to total calls aur har call ka work count karo
6. Space complexity ke liye extra arrays, variables, stack usage dekhna mat bhoolo

---

## 12. Quiz on Complexity Analysis

### Q1. Ek single loop `n` times chalta hai. Complexity?
Answer: `O(n)`

### Q2. Two nested loops each from `0` to `n-1`. Complexity?
Answer: `O(n^2)`

### Q3. Loop me `i = i * 2` ho raha hai. Complexity?
Answer: `O(log n)`

### Q4. `O(n^2 + n + 100)` ko simplify karo
Answer: `O(n^2)`

### Q5. Linear search ka best case kya hota hai?
Answer: `O(1)`

### Q6. Linear search ka worst case kya hota hai?
Answer: `O(n)`

### Q7. Binary search ka worst case kya hota hai?
Answer: `O(log n)`

### Q8. Extra array of size `n` banaya. Auxiliary space?
Answer: `O(n)`

### Q9. Recursive function `fun(n-1)` call karta hai till `0`. Time?
Answer: `O(n)`

### Q10. Fibonacci recursive version ki time complexity?
Answer: approximately `O(2^n)`

---

## 13. Quick Comparison Table

| Situation | Time Complexity |
|---|---|
| single statement | `O(1)` |
| single loop | `O(n)` |
| nested loop | `O(n^2)` |
| loop doubling/halving | `O(log n)` |
| divide and conquer | often `O(log n)` or `O(n log n)` |
| simple recursion `fun(n-1)` | `O(n)` |
| binary recursion like naive Fibonacci | `O(2^n)` |

---

## 14. Common Mistakes

### Mistake 1
Actual seconds ko complexity samajh lena.

Complexity growth hoti hai, actual runtime machine par depend karta hai.

### Mistake 2
Constants ko include rakhna.

`O(3n)` ko `O(n)` likhna chahiye.

### Mistake 3
Space complexity me recursion stack bhool jana.

### Mistake 4
Best case aur worst case ko mix kar dena.

### Mistake 5
Input space aur auxiliary space ko same samajhna.

---

## 15. Practice Problems

In topics par khud se practice karo:

1. Different loop patterns ka time complexity find karo
2. Recursion wale small functions ka time and auxiliary space nikalo
3. Linear search aur binary search ke best, worst, average case compare karo
4. Ek code snippet me extra memory use ho rahi ho to auxiliary space identify karo
5. `O(1), O(log n), O(n), O(n^2)` examples khud likho

Practice source idea:
- GeeksforGeeks par "time complexity of loops"
- GeeksforGeeks par "analysis of algorithms practice"
- Quiz style MCQs on complexity analysis

---

## 16. Final Summary

- Time complexity batati hai algorithm kitna time grow karega
- Space complexity batati hai kitni memory use hogi
- Big O upper bound hai
- Omega lower bound hai
- Theta tight bound hai
- Single loop usually `O(n)`
- Nested loop often `O(n^2)`
- Halving/doubling pattern `O(log n)`
- Recursive stack auxiliary space ko affect karta hai
- Best, worst, average case alag ho sakte hain

Agar ye chapter strong ho gaya, to DSA ka base kaafi solid ho jata hai, kyunki almost har problem me complexity analysis ka role hota hai.

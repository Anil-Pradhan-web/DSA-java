# Stack in Java for DSA

## 1. Stack kya hota hai?

Stack ek linear data structure hota hai jo **LIFO** principle follow karta hai.

LIFO ka full form:
- Last In First Out

Matlab jo element sabse last me aaya hoga, wahi sabse pehle bahar niklega.

Simple example:

```text
Push 10
Push 20
Push 30

Top = 30
Pop -> 30
Pop -> 20
Pop -> 10
```

## 2. Stack interview me kyun important hai?

Stack topic isliye important hai kyunki:
- parentheses validation me directly use hota hai
- expression evaluation aur conversion me aata hai
- undo/redo type logic me use hota hai
- DFS implementation me kaam aata hai
- monotonic stack 2025 ka FAANG-favorite pattern hai

## 3. Stack ke 4 major interview types

Interview me stack broadly 4 forms me aata hai:

### Type 1: Basic Stack Operations

Push, pop, peek, implementation, stack using queues, queue using stacks.

### Type 2: Expression / Parentheses

Valid parentheses, calculator, postfix, decode string.

### Type 3: Design Problems

Min Stack, LRU style support structures, custom stack behavior.

### Type 4: Monotonic Stack

Next greater/smaller, histogram, stock span, daily temperatures, rain water.

## 4. Basic stack operations

Core operations:
- `push(x)` -> element insert karo
- `pop()` -> top element hatao
- `peek()` -> top element dekho
- `isEmpty()` -> stack empty hai ya nahi
- `size()` -> current element count

In sabka ideal complexity:
- `O(1)`

## 5. Stack ka basic visualization

```text
Top
 |
30
20
10
```

Push hamesha top par hota hai.
Pop bhi hamesha top se hota hai.

## 6. Stack using Array

Array based stack me usually `top` index maintain karte hain.

### Java syntax

```java
static class ArrayStack {
    int[] arr;
    int top;

    ArrayStack(int size) {
        arr = new int[size];
        top = -1;
    }

    void push(int value) {
        if (top == arr.length - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = value;
    }

    int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Empty");
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}
```

### Pros

- simple
- fast
- `O(1)` operations

### Cons

- fixed size issue

## 7. Stack using Linked List

Linked list based stack me head/top par insertion aur deletion hoti hai.

### Java syntax

```java
static class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

static class LinkedListStack {
    Node top;

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Empty");
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }
}
```

### Pros

- dynamic size
- fixed capacity issue nahi hota

### Cons

- extra pointer memory lagti hai

## 8. Java me `Stack` class vs `Deque`

Java me traditional `Stack` class available hai, but interview aur production dono me `Deque` zyada preferred hota hai.

### Old style

```java
Stack<Integer> stack = new Stack<>();
```

### Preferred modern style

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
int top = stack.peek();
int removed = stack.pop();
boolean empty = stack.isEmpty();
```

## 9. `Deque` kyun preferred hai?

- modern interface
- practical performance better
- `Stack` legacy class hai
- interview me `ArrayDeque` use karna better impression deta hai

## 10. Practical Java stack template

Ye template interview me directly use kar sakte ho:

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(x);
stack.pop();
stack.peek();
stack.isEmpty();
```

Character stack:

```java
Deque<Character> stack = new ArrayDeque<>();
```

Index stack:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

## 11. Stack ke common applications

- valid parentheses
- expression evaluation
- infix to postfix/prefix conversion
- recursion call stack concept
- browser backtracking
- undo/redo
- DFS traversal
- monotonic stack problems

## 12. Parentheses / Bracket matching

Ye stack ka sabse basic aur most common pattern hai.

Idea:
- opening bracket stack me push karo
- closing bracket aaye to top se match karo
- mismatch ho to invalid

### Java template

```java
Deque<Character> stack = new ArrayDeque<>();

for (char c : s.toCharArray()) {
    if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
    } else {
        if (stack.isEmpty()) return false;
        char top = stack.pop();
        if (c == ')' && top != '(') return false;
        if (c == '}' && top != '{') return false;
        if (c == ']' && top != '[') return false;
    }
}

return stack.isEmpty();
```

## 13. Expressions: Infix, Prefix, Postfix

### Infix

Operator operands ke beech hota hai.

Example:

```text
a + b
```

### Prefix

Operator pehle hota hai.

Example:

```text
+ a b
```

### Postfix

Operator end me hota hai.

Example:

```text
a b +
```

## 14. Expression problems me stack ka role

Stack useful hota hai:
- postfix evaluate karne me
- infix ko postfix me convert karne me
- calculator problems me
- nested expression parsing me

## 15. Monotonic Stack kya hota hai?

Monotonic stack aisa stack hota hai jo elements ko ek monotonic order me maintain karta hai.

Do major types:
- monotonic increasing stack
- monotonic decreasing stack

## 16. Monotonic stack ka main idea

Jab tak current element stack ke monotonic rule ko break kare,
tab tak stack pop karte jao.

Phir current element ko stack me push karo.

Is idea se:
- brute force `O(n^2)` ko often `O(n)` me convert kar sakte ho

## 17. Monotonic Increasing vs Decreasing

### Monotonic Increasing Stack

Stack me top se niche tak values increasing order maintain hoti hain.

Use:
- next smaller
- previous smaller
- histogram type boundaries

### Monotonic Decreasing Stack

Stack me top se niche tak values decreasing order maintain hoti hain.

Use:
- next greater
- previous greater
- stock span
- daily temperatures

## 18. Monotonic stack ke 4 classic outcomes

- Next Greater Element
- Next Smaller Element
- Previous Greater Element
- Previous Smaller Element

Ye 4 patterns samajh gaye to kaafi stack problems crack ho jaati hain.

## 19. Monotonic stack me value store karein ya index?

Bahut important rule:

### Value store karo

Jab sirf next greater/smaller ki value chahiye.

### Index store karo

Jab distance, width, span, ya boundary calculate karni ho.

Examples:
- Daily Temperatures -> index store karna better
- Largest Rectangle -> index mandatory
- Stock Span -> index helpful

## 20. Daily Temperatures pattern

Ye monotonic decreasing stack ka classic entry-point problem hai.

Idea:
- current temperature greater hai to pichhle colder days resolve ho jaate hain
- unresolved indices stack me rehte hain

### Template

```java
int[] result = new int[n];
Deque<Integer> stack = new ArrayDeque<>();

for (int i = 0; i < n; i++) {
    while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
        int idx = stack.pop();
        result[idx] = i - idx;
    }
    stack.push(i);
}
```

## 21. Largest Rectangle in Histogram pattern

Ye monotonic increasing stack ka iconic hard problem hai.

Idea:
- jab current height chhoti ho jaye,
- to stack top bar ka rectangle ab end ho gaya
- uska width boundary ke through calculate hota hai

### Template

```java
Deque<Integer> stack = new ArrayDeque<>();
int maxArea = 0;

for (int i = 0; i <= heights.length; i++) {
    int h = (i == heights.length) ? 0 : heights[i];

    while (!stack.isEmpty() && h < heights[stack.peek()]) {
        int height = heights[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        maxArea = Math.max(maxArea, height * width);
    }

    stack.push(i);
}
```

## 22. Trapping Rain Water and Stack

Trapping Rain Water two pointers se bhi hota hai, stack se bhi.

Stack version me:
- boundaries detect karte hain
- valley bars ke beech trapped water calculate hota hai

Ye boundary-based monotonic pattern hai.

## 23. Stock Span pattern

Stock span me previous greater ya equal boundary ka role hota hai.

Idea:
- jab current price bada hai, weaker previous elements pop ho jaate hain
- bacha hua top nearest stronger left boundary batata hai

## 24. String manipulation me stack

Stack sirf numbers ke liye nahi hota.

String problems me use hota hai:
- adjacent duplicates remove karna
- backspace compare
- decode string
- remove k digits

Kabhi actual stack use hota hai, kabhi `StringBuilder` stack jaisa behave karta hai.

## 25. Design problems in stack

Important design style stack questions:
- Min Stack
- Implement Stack using Queues
- Implement Queue using Stacks

Ye basic operations ko alternate DS se simulate karne par based hote hain.

## 26. Min Stack concept

Min Stack me normal stack ke saath minimum value bhi `O(1)` me return karni hoti hai.

Typical idea:
- ek main stack
- ek min stack

Jab new value current min se chhoti ya equal ho, min stack me bhi push karo.

## 27. Stack using Queue

Queue FIFO hoti hai, stack LIFO hoti hai.

Is mismatch ko handle karne ke liye:
- push expensive approach
ya
- pop expensive approach

use kar sakte ho.

Interview me concept samajhna zyada important hota hai.

## 28. Queue using Stack

Queue simulate karne ke liye 2 stacks ka classic approach hota hai:
- input stack
- output stack

Ye amortized efficient design hota hai.

## 29. Calculator problems me stack

Basic Calculator type problems me stack use hota hai:
- sign handling
- nested parentheses
- current number build karna
- previous context save karna

Ye parsing + stack combo hota hai.

## 30. Decode String pattern

Pattern:
- counts stack
- partial strings stack
- nested brackets parse karna

Ye Amazon/Google style common string-stack hybrid question hai.

## 31. Asteroid Collision pattern

Ye simulation problem hai.

Stack current surviving asteroids ko represent karti hai.
Jab opposite direction conflict aata hai, collision resolve hoti hai.

Ye batata hai ki stack sirf brackets ke liye nahi, simulation ke liye bhi useful hai.

## 32. Remove K Digits pattern

Ye monotonic stack flavor ka problem hai.

Idea:
- number ko as small as possible banana hai
- bada previous digit jab current smaller digit mile to remove karna beneficial ho sakta hai

Greedy + stack combination hota hai.

## 33. 132 Pattern

Ye advanced stack pattern problem hai.

Yahan stack future candidates ko maintain karti hai aur ek valid ordering detect karni hoti hai.

Is type ke problems interview me monotonic stack depth test karte hain.

## 34. Car Fleet pattern

Car fleet directly stack ka feel deta hai because:
- cars ko sort karte hain
- arrival time compare karte hain
- future merge/fleet effect maintain karte hain

Kabhi explicit stack, kabhi stack-like greedy reasoning use hoti hai.

## 35. Online Stock Span

Ye previous greater element type monotonic stack problem hai.

Important:
- index ya pair `(price, span)` store karke optimized answer nikal sakte ho
- design + monotonic dono flavor ka question hai

## 36. Basic stack syntax recap

### Integer stack

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
int x = stack.pop();
int top = stack.peek();
boolean empty = stack.isEmpty();
```

### Character stack

```java
Deque<Character> stack = new ArrayDeque<>();
```

### Pair-like storage

```java
Deque<int[]> stack = new ArrayDeque<>();
stack.push(new int[]{value, index});
```

## 37. TIER 1 — Service Based expectation

Service-based companies usually puchte hain:
- Valid Parentheses
- Stack using Queues
- Queue using Stacks
- Min Stack
- Baseball Game
- Backspace String Compare
- Remove Adjacent Duplicates

Yahan focus hota hai:
- stack basics
- implementation understanding
- clean Java syntax

## 38. TIER 2 — Mid Product Based expectation

Mid-tier product companies zyada puchte hain:
- Evaluate Reverse Polish Notation
- Basic Calculator II
- Decode String
- Asteroid Collision
- Score of Parentheses
- Remove K Digits
- 132 Pattern

Yahan focus hota hai:
- simulation
- parsing
- stack with strings/numbers
- tricky state handling

## 39. TIER 3 — FAANG expectation

FAANG level stack questions:
- Daily Temperatures
- Next Greater Element I / II
- Largest Rectangle in Histogram
- Maximal Rectangle
- Trapping Rain Water
- Online Stock Span
- Car Fleet
- Basic Calculator

Yahan focus hota hai:
- monotonic stack
- hard boundary logic
- stack + greedy combo
- stack + parsing combo

## 40. Special Pattern — Monotonic Stack

Ye pattern ab interview prep me must-know hai.

Core mapping:

- Monotonic increasing -> smaller element related
- Monotonic decreasing -> greater element related

Must know problems:
- Daily Temperatures
- Next Greater Element I
- Next Greater Element II
- Largest Rectangle in Histogram
- Trapping Rain Water
- Online Stock Span

## 41. Decision tree — kaunsa pattern use karein?

### Brackets / parentheses valid hain?

-> basic stack

### Expression evaluate ya parse karna hai?

-> stack-based calculator / postfix / decode

### Adjacent remove / rollback / undo type string hai?

-> stack as character builder

### Next greater / smaller / previous greater / smaller chahiye?

-> monotonic stack

### Width / span / distance nikalna hai?

-> indices stack me store karo

### Design question hai?

-> custom structure + stack/queue combo

## 42. Pattern to problem mapping

- Fast bracket matching -> `#20`
- Stack design -> `#155`, `#225`, `#232`
- Expression evaluation -> `#150`, `#227`, `#224`
- String stack simulation -> `#394`, `#1047`, `#402`
- Monotonic decreasing -> `#739`, `#496`, `#901`
- Monotonic increasing -> `#84`, `#85`
- Boundary + stack -> `#42`

## 43. Company-wise expectation

### TCS / Wipro

- Valid Parentheses
- Min Stack basics
- Stack / Queue implementation

### Infosys / Cognizant

- Backspace Compare
- Remove Duplicates
- Queue using Stacks

### Adobe / Bloomberg

- Evaluate RPN
- Asteroid Collision
- Remove K Digits
- 132 Pattern

### Amazon

- Daily Temperatures
- Decode String
- Histogram
- Trapping Rain Water
- Min Stack

### Microsoft

- Next Greater Element
- Histogram
- design + parser mix

### Google

- monotonic stack hard variants
- calculator problems
- car fleet type greedy-stack

### Meta

- Daily Temperatures
- Trapping Rain Water
- Decode String

## 44. Common mistakes in stack problems

- pop se pehle empty check bhool jaana
- `Stack` class use kar dena instead of `ArrayDeque`
- values aur indices confuse kar dena
- monotonic comparison wrong choose karna
- final stack-empty validation bhool jaana
- histogram me width formula galat kar dena
- decode/calculator me current number reset bhool jaana

## 45. Java-specific mistakes

Wrong:

```java
Stack<Integer> stack = new Stack<>();
```

Preferred:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

Monotonic stack me:
- mostly index store karo
- direct value store karne se width/span calculations impossible ho sakti hain

## 46. Edge cases hamesha check karo

- empty input
- single element
- all same values
- strictly increasing
- strictly decreasing
- unmatched brackets
- leading zero issues in string problems
- nested brackets / nested expressions
- no greater element found

## 47. Complexity intuition

Basic stack operations:
- push = `O(1)`
- pop = `O(1)`
- peek = `O(1)`

Most stack traversals:
- `O(n)`

Monotonic stack often `O(n)` hoti hai because:
- har element maximum ek baar push aur ek baar pop hota hai

## 48. Kitne problems karne chahiye?

Balanced prep ke liye:
- 5–6 basic stack easy
- 5–6 expression/string medium
- 6–7 monotonic stack medium-hard
- 2–3 hard FAANG-style

Total:
- around 18–22 problems strong coverage ke liye enough hote hain

## 49. Must-do top stack problems

1. `#20 Valid Parentheses`
2. `#155 Min Stack`
3. `#739 Daily Temperatures`
4. `#84 Largest Rectangle in Histogram`
5. `#42 Trapping Rain Water`
6. `#394 Decode String`

Ye 6 problems stack ka base + monotonic pattern + hybrid usage sab cover kar dete hain.

## 50. Final takeaway

Stack mastery ka matlab sirf push/pop samajhna nahi hai. Real mastery tab hoti hai jab tum problem dekhkar identify kar pao:

- simple stack enough hai
- parentheses validation lag raha hai
- expression parsing chahiye
- string simulation hai
- ya monotonic stack lagni chahiye

Aur jab tum ye samajh jao ki:
- value store karni hai ya index
- increasing stack chahiye ya decreasing
- stack + greedy combo ban raha hai ya nahi

tab stack problems kaafi manageable ho jaati hain.

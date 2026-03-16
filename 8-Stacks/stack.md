# Stacks in Java for DSA

## 1. Stack kya hota hai?

Stack ek linear data structure hota hai jo **LIFO** principle follow karta hai.

LIFO ka full form:

- Last In First Out

Matlab jo element sabse last me insert hua hai, wahi sabse pehle bahar aayega.

Example:

```text
Push 10
Push 20
Push 30

Stack top -> 30
Pop -> 30
Pop -> 20
Pop -> 10
```

## 2. Basic stack operations

- `push(x)` -> element insert karo
- `pop()` -> top element hatao
- `peek()` / `top()` -> top element dekho
- `isEmpty()` -> stack empty hai ya nahi
- `size()` -> kitne elements hain

## 3. Stack using arrays

Array based stack me ek `top` index maintain karte hain.

### Java code

```java
static class ArrayStack {
    int[] arr;
    int top;

    ArrayStack(int size) {
        arr = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == arr.length - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
```

### Complexity

- push = `O(1)`
- pop = `O(1)`
- peek = `O(1)`

## 4. Stack using linked list

Linked list based stack me insertion aur deletion head par hoti hai.

### Java code

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

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
```

### Advantage

- fixed size ka issue nahi hota

## 5. In-built Stack class in Java

Java me traditional stack ke liye `Stack` class milti hai.

```java
java.util.Stack<Integer> stack = new java.util.Stack<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop());  // 20
System.out.println(stack.peek()); // 10
```

### Note

- `Stack` old class hai
- modern Java me stack use case ke liye `Deque` zyada preferred hota hai

## 6. Stack using `Deque`

`Deque` stack ki tarah use karna best practice mana jata hai.

```java
java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop());  // 20
System.out.println(stack.peek()); // 10
```

### Why `Deque` better hai?

- faster practical implementation
- modern interface
- `Stack` se zyada preferred in interviews and production Java

## 7. Monotonic Stack concept

Monotonic stack aisa stack hota hai jisme elements ek monotonic order maintain karte hain.

Types:

- increasing monotonic stack
- decreasing monotonic stack

Use cases:

- next greater element
- next smaller element
- stock span
- largest rectangle in histogram

### Idea

Jab tak current element stack top ke monotonic rule ko break kare, tab tak pop karte ho.

## 8. Applications of stack

- expression evaluation
- undo/redo
- browser history
- function call stack
- parenthesis matching
- DFS implementation
- monotonic stack problems

## 9. Parenthesis matching using stack

Idea:

- opening brackets stack me push karo
- closing bracket aaye to top se match karo

### Java code

```java
public static boolean isValidParentheses(String s) {
    java.util.Deque<Character> stack = new java.util.ArrayDeque<>();

    for (char ch : s.toCharArray()) {
        if (ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
        } else {
            if (stack.isEmpty()) {
                return false;
            }

            char top = stack.pop();
            if ((ch == ')' && top != '(') ||
                (ch == '}' && top != '{') ||
                (ch == ']' && top != '[')) {
                return false;
            }
        }
    }

    return stack.isEmpty();
}
```

## 10. Infix, Prefix, Postfix expressions

### Infix

Operator operands ke beech me hota hai.

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

### Kyu important hai?

- expression conversion
- expression evaluation
- compilers and parsers

## 11. Practice Problems

## 11.1 Implement stack using queues

Single queue based approach.

```java
static class MyStack {
    java.util.Queue<Integer> queue = new java.util.LinkedList<>();

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
```

## 11.2 Valid parentheses

```java
public static boolean validParentheses(String s) {
    return isValidParentheses(s);
}
```

## 11.3 Next greater element

### Java code

```java
public static int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    java.util.Arrays.fill(result, -1);
    java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();

    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= nums[i]) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            result[i] = stack.peek();
        }

        stack.push(nums[i]);
    }

    return result;
}
```

## 11.4 Next smaller element

```java
public static int[] nextSmallerElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    java.util.Arrays.fill(result, -1);
    java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();

    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() >= nums[i]) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            result[i] = stack.peek();
        }

        stack.push(nums[i]);
    }

    return result;
}
```

## 11.5 Stock span problem

```java
public static int[] stockSpan(int[] prices) {
    int n = prices.length;
    int[] span = new int[n];
    java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();

    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
            stack.pop();
        }

        span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
        stack.push(i);
    }

    return span;
}
```

## 11.6 Largest rectangle in histogram

```java
public static int largestRectangleArea(int[] heights) {
    java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i <= n; i++) {
        int currentHeight = (i == n) ? 0 : heights[i];

        while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        stack.push(i);
    }

    return maxArea;
}
```

## 11.7 Infix to Postfix conversion

```java
public static String infixToPostfix(String expression) {
    StringBuilder result = new StringBuilder();
    java.util.Deque<Character> stack = new java.util.ArrayDeque<>();

    for (char ch : expression.toCharArray()) {
        if (Character.isLetterOrDigit(ch)) {
            result.append(ch);
        } else if (ch == '(') {
            stack.push(ch);
        } else if (ch == ')') {
            while (!stack.isEmpty() && stack.peek() != '(') {
                result.append(stack.pop());
            }
            stack.pop();
        } else {
            while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                result.append(stack.pop());
            }
            stack.push(ch);
        }
    }

    while (!stack.isEmpty()) {
        result.append(stack.pop());
    }

    return result.toString();
}

public static int precedence(char ch) {
    if (ch == '^') {
        return 3;
    }
    if (ch == '*' || ch == '/') {
        return 2;
    }
    if (ch == '+' || ch == '-') {
        return 1;
    }
    return -1;
}
```

## 11.8 Evaluate postfix expression

```java
public static int evaluatePostfix(String expression) {
    java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();

    for (char ch : expression.toCharArray()) {
        if (Character.isDigit(ch)) {
            stack.push(ch - '0');
        } else {
            int b = stack.pop();
            int a = stack.pop();

            switch (ch) {
                case '+': stack.push(a + b); break;
                case '-': stack.push(a - b); break;
                case '*': stack.push(a * b); break;
                case '/': stack.push(a / b); break;
            }
        }
    }

    return stack.pop();
}
```

## 11.9 Min stack - getMin in `O(1)`

```java
static class MinStack {
    java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
    java.util.Deque<Integer> minStack = new java.util.ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
```

## 11.10 Celebrity problem

Problem:

- party me `n` log hain
- celebrity sabko unknown nahi hota; celebrity sabko known hota hai but celebrity kisi ko nahi jaanta

Stack approach:

- sabko stack me dalo
- do do compare karo
- one possible celebrity bacha lo
- final verification karo

```java
public static int findCelebrity(int[][] knows) {
    java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
    int n = knows.length;

    for (int i = 0; i < n; i++) {
        stack.push(i);
    }

    while (stack.size() > 1) {
        int a = stack.pop();
        int b = stack.pop();

        if (knows[a][b] == 1) {
            stack.push(b);
        } else {
            stack.push(a);
        }
    }

    int candidate = stack.pop();

    for (int i = 0; i < n; i++) {
        if (i != candidate) {
            if (knows[candidate][i] == 1 || knows[i][candidate] == 0) {
                return -1;
            }
        }
    }

    return candidate;
}
```

## 12. Common mistakes in stack problems

- pop karne se pehle empty check bhool jana
- monotonic stack me wrong comparison use kar dena
- indices aur values confuse kar dena
- parenthesis problems me final stack empty check bhool jana
- infix conversion me precedence handling galat kar dena

## 13. Time complexity summary

- push/pop/peek = `O(1)`
- valid parentheses = `O(n)`
- next greater/smaller = `O(n)`
- stock span = `O(n)`
- largest rectangle in histogram = `O(n)`
- infix to postfix = `O(n)`
- evaluate postfix = `O(n)`
- min stack = `O(1)` for `getMin()`
- celebrity problem = `O(n)` verification after elimination

## 14. Quick revision summary

- stack LIFO principle follow karta hai
- array, linked list, `Stack`, aur `Deque` se implement kar sakte ho
- Java me `Deque` preferred hota hai over `Stack`
- monotonic stack next greater/smaller type questions me useful hota hai
- expression conversion and evaluation me stack bohot important hai
- parenthesis matching classic stack question hai

## 15. Final takeaway

Stack DSA ka bohot important topic hai because ye order, reversal, parsing, aur monotonic patterns samajhne me help karta hai.

Java interview ke liye most important practical points:

- LIFO principle
- `Deque` as stack
- monotonic stack pattern
- parenthesis matching
- postfix evaluation
- min stack
- histogram and stock span type problems

Agar stack strong ho gaya, to queues, trees, parsing aur greedy-style many interview problems easy lagne lagte hain.

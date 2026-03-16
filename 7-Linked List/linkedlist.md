# Linked List in Java for DSA

## 1. Linked List kya hota hai?

Linked List ek linear data structure hota hai jahan elements contiguous memory me store nahi hote. Har element ek node hota hai.

Singly linked list node me usually hota hai:

- data
- next reference

Example:

```text
10 -> 20 -> 30 -> 40 -> null
```

## 2. Array vs Linked List

### Array

- contiguous memory
- random access fast hota hai
- insert/delete expensive ho sakta hai

### Linked List

- dynamic size
- insert/delete easier ho sakta hai if pointer mil jaye
- random access slow hota hai

## 3. Singly Linked List

Singly linked list me har node ke paas sirf `next` pointer hota hai.

### Java node structure

```java
static class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}
```

## 4. Traversal in Singly Linked List

```java
public static void printList(ListNode head) {
    ListNode current = head;

    while (current != null) {
        System.out.print(current.data + " -> ");
        current = current.next;
    }

    System.out.println("null");
}
```

### Complexity

- time = `O(n)`

## 5. Insertion in Singly Linked List

## 5.1 Insert at head

```java
public static ListNode insertAtHead(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    newNode.next = head;
    return newNode;
}
```

## 5.2 Insert at tail

```java
public static ListNode insertAtTail(ListNode head, int value) {
    ListNode newNode = new ListNode(value);

    if (head == null) {
        return newNode;
    }

    ListNode current = head;
    while (current.next != null) {
        current = current.next;
    }

    current.next = newNode;
    return head;
}
```

## 5.3 Insert at middle / position

```java
public static ListNode insertAtPosition(ListNode head, int position, int value) {
    if (position == 0) {
        return insertAtHead(head, value);
    }

    ListNode current = head;
    for (int i = 0; i < position - 1 && current != null; i++) {
        current = current.next;
    }

    if (current == null) {
        return head;
    }

    ListNode newNode = new ListNode(value);
    newNode.next = current.next;
    current.next = newNode;
    return head;
}
```

## 6. Deletion in Singly Linked List

## 6.1 Delete at head

```java
public static ListNode deleteAtHead(ListNode head) {
    if (head == null) {
        return null;
    }
    return head.next;
}
```

## 6.2 Delete at tail

```java
public static ListNode deleteAtTail(ListNode head) {
    if (head == null || head.next == null) {
        return null;
    }

    ListNode current = head;
    while (current.next.next != null) {
        current = current.next;
    }

    current.next = null;
    return head;
}
```

## 6.3 Delete by value

```java
public static ListNode deleteByValue(ListNode head, int value) {
    if (head == null) {
        return null;
    }

    if (head.data == value) {
        return head.next;
    }

    ListNode current = head;
    while (current.next != null && current.next.data != value) {
        current = current.next;
    }

    if (current.next != null) {
        current.next = current.next.next;
    }

    return head;
}
```

## 7. Doubly Linked List

Doubly linked list me har node ke paas do pointers hote hain:

- `prev`
- `next`

### Java node structure

```java
static class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int data) {
        this.data = data;
    }
}
```

### Example

```text
null <- 10 <-> 20 <-> 30 -> null
```

## 7.1 Insert at head in doubly list

```java
public static DoublyNode insertDoublyHead(DoublyNode head, int value) {
    DoublyNode newNode = new DoublyNode(value);
    newNode.next = head;

    if (head != null) {
        head.prev = newNode;
    }

    return newNode;
}
```

## 7.2 Insert at tail in doubly list

```java
public static DoublyNode insertDoublyTail(DoublyNode head, int value) {
    DoublyNode newNode = new DoublyNode(value);

    if (head == null) {
        return newNode;
    }

    DoublyNode current = head;
    while (current.next != null) {
        current = current.next;
    }

    current.next = newNode;
    newNode.prev = current;
    return head;
}
```

## 7.3 Delete a node in doubly list

```java
public static DoublyNode deleteDoublyNode(DoublyNode head, int value) {
    DoublyNode current = head;

    while (current != null && current.data != value) {
        current = current.next;
    }

    if (current == null) {
        return head;
    }

    if (current.prev != null) {
        current.prev.next = current.next;
    } else {
        head = current.next;
    }

    if (current.next != null) {
        current.next.prev = current.prev;
    }

    return head;
}
```

## 8. Circular Linked List

Circular linked list me last node first node ko point karta hai.

## 8.1 Circular singly linked list

```text
10 -> 20 -> 30
^           |
|___________|
```

### Basic insertion at end

```java
public static ListNode insertCircularTail(ListNode head, int value) {
    ListNode newNode = new ListNode(value);

    if (head == null) {
        newNode.next = newNode;
        return newNode;
    }

    ListNode current = head;
    while (current.next != head) {
        current = current.next;
    }

    current.next = newNode;
    newNode.next = head;
    return head;
}
```

## 8.2 Circular doubly linked list

Isme:

- `tail.next = head`
- `head.prev = tail`

Ye traversal ko circular bana deta hai in both directions.

## 9. Fast and slow pointer technique

Ye linked list ka bohot important pattern hai.

### Idea

- slow pointer 1 step move karta hai
- fast pointer 2 steps move karta hai

Use cases:

- middle node find karna
- cycle detect karna
- cycle start find karna

## 10. Reversal of linked list

## 10.1 Iterative reverse

```java
public static ListNode reverseIterative(ListNode head) {
    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
        ListNode nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
    }

    return prev;
}
```

## 10.2 Recursive reverse

```java
public static ListNode reverseRecursive(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode newHead = reverseRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}
```

## 11. Detect loop in linked list using Floyd's algorithm

```java
public static boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            return true;
        }
    }

    return false;
}
```

## 12. Find start of loop in linked list

Floyd cycle detect ke baad cycle start bhi nikal sakte hain.

```java
public static ListNode findCycleStart(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            ListNode entry = head;
            while (entry != slow) {
                entry = entry.next;
                slow = slow.next;
            }
            return entry;
        }
    }

    return null;
}
```

## 13. Find middle of linked list

```java
public static ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}
```

## 14. Merge two sorted linked lists

```java
public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;

    while (l1 != null && l2 != null) {
        if (l1.data <= l2.data) {
            tail.next = l1;
            l1 = l1.next;
        } else {
            tail.next = l2;
            l2 = l2.next;
        }
        tail = tail.next;
    }

    tail.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}
```

## 15. Finding intersection point of two lists

### Length alignment method

```java
public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = getLength(headA);
    int lenB = getLength(headB);

    while (lenA > lenB) {
        headA = headA.next;
        lenA--;
    }

    while (lenB > lenA) {
        headB = headB.next;
        lenB--;
    }

    while (headA != null && headB != null) {
        if (headA == headB) {
            return headA;
        }
        headA = headA.next;
        headB = headB.next;
    }

    return null;
}

public static int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
        length++;
        head = head.next;
    }
    return length;
}
```

## 16. In-place operations on linked lists

In-place ka matlab extra list banaye bina pointers ko rearrange karna.

Examples:

- reverse linked list
- merge lists by relinking nodes
- remove node
- reorder list

Important idea:

- pointer updates carefully karo
- next reference lose na ho isliye pehle save karo

## 17. Practice Problems

## 17.1 Reverse a linked list iterative

```java
public static ListNode reverseListIterative(ListNode head) {
    return reverseIterative(head);
}
```

## 17.2 Reverse a linked list recursive

```java
public static ListNode reverseListRecursive(ListNode head) {
    return reverseRecursive(head);
}
```

## 17.3 Detect loop in linked list

```java
public static boolean detectLoop(ListNode head) {
    return hasCycle(head);
}
```

## 17.4 Find start of loop in linked list

```java
public static ListNode startOfLoop(ListNode head) {
    return findCycleStart(head);
}
```

## 17.5 Find middle of linked list

```java
public static ListNode middleNode(ListNode head) {
    return findMiddle(head);
}
```

## 17.6 Merge two sorted lists

```java
public static ListNode mergeSortedLists(ListNode a, ListNode b) {
    return mergeTwoLists(a, b);
}
```

## 17.7 Remove nth node from end of list

```java
public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 0; i < n; i++) {
        if (fast.next == null) {
            return head;
        }
        fast = fast.next;
    }

    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
}
```

## 17.8 Intersection point of two linked lists

```java
public static ListNode intersectionPoint(ListNode headA, ListNode headB) {
    return getIntersectionNode(headA, headB);
}
```

## 17.9 Add two numbers represented by linked lists

Assume digits reverse order me stored hain.

```java
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
        int sum = carry;

        if (l1 != null) {
            sum += l1.data;
            l1 = l1.next;
        }

        if (l2 != null) {
            sum += l2.data;
            l2 = l2.next;
        }

        current.next = new ListNode(sum % 10);
        carry = sum / 10;
        current = current.next;
    }

    return dummy.next;
}
```

## 17.10 Flatten a multilevel linked list

Assume node has `next` and `child`.

```java
static class MultiLevelNode {
    int data;
    MultiLevelNode next;
    MultiLevelNode child;

    MultiLevelNode(int data) {
        this.data = data;
    }
}

public static MultiLevelNode flatten(MultiLevelNode head) {
    if (head == null) {
        return null;
    }

    MultiLevelNode current = head;
    while (current != null) {
        if (current.child != null) {
            MultiLevelNode nextNode = current.next;
            current.next = flatten(current.child);
            current.child = null;

            MultiLevelNode tail = current.next;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = nextNode;
        }
        current = current.next;
    }

    return head;
}
```

## 17.11 Copy list with random pointer

```java
static class RandomNode {
    int data;
    RandomNode next;
    RandomNode random;

    RandomNode(int data) {
        this.data = data;
    }
}

public static RandomNode copyRandomList(RandomNode head) {
    if (head == null) {
        return null;
    }

    java.util.HashMap<RandomNode, RandomNode> map = new java.util.HashMap<>();
    RandomNode current = head;

    while (current != null) {
        map.put(current, new RandomNode(current.data));
        current = current.next;
    }

    current = head;
    while (current != null) {
        map.get(current).next = map.get(current.next);
        map.get(current).random = map.get(current.random);
        current = current.next;
    }

    return map.get(head);
}
```

## 18. Common linked list patterns

- dummy node
- fast and slow pointers
- reversal using three pointers
- merge using tail pointer
- cycle detection using Floyd algorithm
- length alignment for intersection

## 19. Common mistakes in linked list

- head lose kar dena
- null checks bhool jana
- pointer update order galat kar dena
- circular list me infinite loop laga dena
- in-place operation me `next` save na karna

## 20. Time complexity summary

- traversal = `O(n)`
- insert at head = `O(1)`
- insert at tail = `O(n)` without tail pointer
- delete at head = `O(1)`
- search = `O(n)`
- reverse = `O(n)`
- middle find = `O(n)`
- cycle detect = `O(n)`
- merge two sorted lists = `O(n + m)`
- intersection find = `O(n + m)`

## 21. Quick revision summary

- singly linked list me `data` aur `next` hota hai
- doubly linked list me `prev` aur `next` dono hote hain
- circular linked list me last node first ko point karta hai
- fast and slow pointer linked list ka core interview pattern hai
- reversal, cycle detection, middle, merge, intersection classic problems hain
- dummy node many edge cases simplify karta hai

## 22. Final takeaway

Linked list DSA ka bohot important topic hai because ye references aur pointer-style thinking strong karta hai.

Java interview ke liye sabse important practical points:

- `ListNode` structure
- traversal and null checks
- iterative and recursive reverse
- Floyd cycle detection
- merge and intersection logic
- dummy node pattern
- in-place pointer manipulation

Agar linked list strong ho gayi, to trees, graphs aur pointer-based problems kaafi easy lagne lagte hain.

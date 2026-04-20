# Linked List Theory Notes

## 1. Linked List kya hota hai?

Linked List ek linear data structure hota hai jahan elements contiguous memory me store nahi hote. Har element ko node kehte hain, aur har node kisi next node ka reference hold karta hai.

Simple intuition:
- array me items side by side memory me hote hain
- linked list me nodes logically connected hote hain pointers ke through

## 2. Node kya hota hai?

Linked list ka basic unit node hota hai.

Singly linked list node ke paas usually hota hai:
- data
- next reference

Doubly linked list node ke paas hota hai:
- data
- next reference
- prev reference

## 3. Head kya hota hai?

Head linked list ka starting node reference hota hai.

Important:
- agar head `null` hai to list empty hai
- saari traversal usually head se start hoti hai

## 4. Tail kya hota hai?

Tail list ka last node hota hai.

Singly linked list me:
- tail ka `next = null`

Circular list me:
- tail ka `next` head ko point karta hai

## 5. Linked List kyun important hai?

Linked list DSA me important hai because:
- dynamic size natural hota hai
- pointer/reference handling strong hoti hai
- many interview patterns isi se build hote hain
- stacks, queues, hash chaining, adjacency lists me use hoti hai

## 6. Array vs Linked List

### Array

- contiguous memory
- random access fast
- size fixed ya resize costly
- middle insertion/deletion expensive

### Linked List

- non-contiguous nodes
- dynamic size
- random access slow
- pointer known ho to insertion/deletion easy

## 7. Linked List ka biggest trade-off

Linked list ki strength:
- insertion/deletion flexibility

Linked list ki weakness:
- direct indexing nahi hoti
- traversal sequential hoti hai

Yahi main trade-off hai arrays aur linked lists ke beech.

## 8. Types of Linked Lists

Main types:
- Singly Linked List
- Doubly Linked List
- Circular Singly Linked List
- Circular Doubly Linked List

## 9. Singly Linked List

Singly linked list me har node sirf next node ko point karti hai.

Direction:
- sirf aage move kar sakte ho

Use when:
- memory kam chahiye
- reverse traversal ki zarurat nahi
- simple sequential structure enough hai

## 10. Doubly Linked List

Doubly linked list me har node ke paas `prev` aur `next` dono pointers hote hain.

Benefits:
- dono directions me traversal possible
- deletion easier ho sakti hai when node available ho

Trade-off:
- extra memory lagti hai
- pointer updates zyada careful karne padte hain

## 11. Circular Linked List

Circular linked list me last node ka next first node ko point karta hai.

Use cases:
- round-robin scheduling
- cyclic traversal
- queue-like circular logic

Risk:
- traversal me stopping condition galat hui to infinite loop lag sakta hai

## 12. Circular Doubly Linked List

Isme:
- tail.next = head
- head.prev = tail

Ye full circular traversal allow karta hai both directions me.

## 13. Linked List me traversal

Traversal ka matlab hota hai:
- head se start karke node by node aage badhna
- jab tak `null` ya stopping condition na mil jaye

Traversal linked list ka most basic operation hai.

Important:
- random access nahi hoti
- kth node tak pahunchne ke liye k steps lagte hain

## 14. Time complexity intuition

Linked list me:
- head access = `O(1)`
- traversal = `O(n)`
- search = `O(n)`
- insert at head = `O(1)`
- delete at head = `O(1)`

Tail pointer ho ya na ho, uske basis par tail operations change hote hain.

## 15. Insert operations ka theory

Linked list me insertion 3 major places par hoti hai:
- head par
- tail par
- middle ya given position par

### Insert at head

Sabse simple hota hai.
New node ka next current head ban jata hai.
Phir head update hota hai.

### Insert at tail

Agar tail pointer nahi hai to end tak traverse karna padta hai.

### Insert in middle

Previous node tak pahunchna padta hai.
Pointer order bahut important hota hai.

## 16. Delete operations ka theory

Delete operations bhi generally:
- head deletion
- tail deletion
- middle/value deletion

Important:
- node ka link todna hota hai
- previous aur next relation carefully update karna padta hai

Deletion me null checks bahut important hote hain.

## 17. Head deletion simple kyun hoti hai?

Kyuki head ko bas next node par shift karna hota hai.

No traversal needed.
Isliye head insertion aur head deletion linked lists me bahut efficient hote hain.

## 18. Tail deletion tricky kyun hoti hai?

Singly linked list me:
- last node ko directly access karna enough nahi hota
- uske previous node ki bhi zarurat hoti hai

Isliye traversal lag sakta hai.

## 19. Middle insertion/deletion me kya dikkat hoti hai?

Main challenge pointer handling hai.

Wrong pointer order se:
- list ka part lose ho sakta hai
- cycle accidentally ban sakti hai
- null pointer issue aa sakta hai

## 20. Dummy node pattern

Dummy node linked list interviews ka super useful pattern hai.

Dummy node ka benefit:
- head special case simplify hota hai
- insert/delete near head easy ho jaata hai
- code cleaner ho jaata hai

Use cases:
- merge lists
- remove nth from end
- partition list
- add two numbers

## 21. Fast and Slow Pointer pattern

Ye linked list ka sabse important interview pattern hai.

Idea:
- slow pointer 1 step move karta hai
- fast pointer 2 steps move karta hai

Use cases:
- middle node find karna
- cycle detect karna
- cycle start find karna
- palindrome linked list
- split list for merge sort

## 22. Floyd Cycle Detection

Isse tortoise and hare algorithm bhi kehte hain.

Intuition:
- agar cycle hai to fast aur slow pointer eventually milenge
- agar cycle nahi hai to fast pointer null par pahunch jayega

Yeh cycle detection ka classic pattern hai.

## 23. Cycle start kaise milta hai?

Floyd detection ke baad:
- ek pointer head par reset karo
- doosra meeting point par rakho
- dono ko 1 step se move karo
- jahan milenge wahi cycle ka start hoga

Ye linked list interview me classic conceptual question hai.

## 24. Middle of Linked List

Middle find karne ka best pattern:
- fast and slow pointers

Reason:
- slow half speed se move karta hai
- jab fast end tak pahunchta hai, slow middle par hota hai

Ye pattern merge sort on linked list me bhi use hota hai.

## 25. Reverse Linked List

Linked list reversal ek must-know pattern hai.

Do main approaches:
- iterative
- recursive

Iterative me usually 3 pointers hote hain:
- prev
- current
- next

Recursive me:
- chhoti list ko reverse karte hain
- phir current link flip karte hain

## 26. Reverse karte waqt sabse bada risk

Sabse common bug:
- current node ka next reference lose ho jaana

Isliye pointer update order carefully samajhna zaroori hai.

## 27. Merge Two Sorted Lists

Ye linked list ka classic interview problem hai.

Idea:
- do sorted lists ko ek sorted list me merge karo
- smaller current node choose karo
- tail pointer se answer build karo

Dummy node yahan bahut useful hota hai.

## 28. Linked List Intersection

Question:
- do linked lists kahaan intersect karti hain?

Typical approaches:
- length alignment
- two pointer switching technique

Core observation:
- intersection value-based nahi, node reference-based hoti hai

## 29. Remove Nth Node from End

Ye problem mostly two-pointer gap technique se solve hoti hai.

Idea:
- fast pointer ko pehle n steps aage le jao
- phir fast aur slow ko saath move karo
- jab fast end par ho, slow delete-position se pehle hoga

Dummy node is problem me edge cases simplify karti hai.

## 30. Add Two Numbers as Linked Lists

Ye digit-by-digit addition jaisa hota hai.

Important concepts:
- carry
- different lengths
- final carry handling
- dummy node usage

## 31. Merge Sort on Linked List

Linked list ko sort karne ke liye Merge Sort natural choice hoti hai.

Reason:
- linked list me random access nahi hota
- midpoint slow-fast se mil jaata hai
- merge operation pointer-based naturally possible hai

Isliye interview me "sort list" ke liye Merge Sort strong answer hota hai.

## 32. Reverse in Groups

K-group reversal type problems me:
- group boundaries important hoti hain
- local reversal + reconnect logic samajhna padta hai

Ye advanced pointer manipulation problem category me aata hai.

## 33. Palindrome Linked List

Typical pattern:
- middle find karo
- second half reverse karo
- dono halves compare karo

Yahan fast-slow + reverse dono patterns combine hote hain.

## 34. Flatten Linked List

Flatten type problems me linked structure multi-level ho sakta hai.

Yahan key challenge hota hai:
- child ya bottom pointers handle karna
- correct merging order maintain karna
- original next chain lose na karna

## 35. Copy List with Random Pointer

Yeh advanced linked list problem hai.

Challenges:
- next ke saath random pointer bhi copy karna hota hai
- deep copy banana hota hai, shallow nahi

Common approaches:
- HashMap based
- interleaving nodes based optimized approach

## 36. Linked List patterns ka summary

Most important linked list patterns:
- dummy node
- fast and slow pointers
- reversal
- merge using tail
- cycle detection
- length alignment
- recursion on next nodes

## 37. Singly vs Doubly Linked List comparison

### Singly

- less memory
- simple structure
- reverse traversal nahi

### Doubly

- forward + backward traversal
- deletion easier in some cases
- extra memory
- pointer maintenance harder

## 38. Linked List me random access kyun slow hota hai?

Kyuki linked list me direct indexing support nahi hoti.

Agar kth node chahiye:
- head se start karke sequentially k steps jaana padta hai

Isliye:
- arrays searching/indexing me strong hoti hain
- linked list structural modifications me strong hoti hai

## 39. Linked List ka memory behavior

Linked list nodes alag-alag memory locations par ho sakte hain.

Iska impact:
- cache locality arrays se weak hoti hai
- pointer chasing hoti hai
- random access slow hota hai

## 40. Linked List kab use karna chahiye?

Use when:
- frequent insert/delete near known nodes ho
- dynamic sequence chahiye
- head operations common ho
- queue/stack via nodes build karna ho

Avoid when:
- frequent indexing chahiye
- random access important ho
- cache-friendly performance chahiye

## 41. Common linked list mistakes

- head lose kar dena
- `next` save na karna before pointer update
- null checks bhool jaana
- tail/head edge cases ignore karna
- single node list handle na karna
- empty list case miss karna
- circular list me infinite loop laga dena
- node value aur node reference me confusion

## 42. Edge cases hamesha check karo

Linked list questions me ye cases zaroor socho:
- empty list
- single node
- two nodes
- head deletion
- tail deletion
- all nodes same
- cycle present
- no cycle
- lists different lengths

## 43. Linked List interview strategy

Kisi bhi linked list problem me:

1. Dry run chhote example par karo
2. Draw the nodes and arrows
3. Decide current, previous, next roles
4. Head change hoga ya nahi, ye clear karo
5. Dummy node helpful hai ya nahi, socho
6. Null edge cases pehle socho

## 44. Pointer update order ka rule

Golden rule:
- pointer update karne se pehle socho ki kis reference ko preserve karna hai

Example intuition:
- current ko move karne se pehle current.next safe jagah store karna pad sakta hai

Pointer order galat hua to list break ho sakti hai.

## 45. Time complexity cheat sheet

- traversal = `O(n)`
- search = `O(n)`
- insert at head = `O(1)`
- delete at head = `O(1)`
- insert at tail = `O(1)` only if tail pointer ho, warna `O(n)`
- delete at tail in singly list = `O(n)`
- reverse = `O(n)`
- middle find = `O(n)`
- cycle detect = `O(n)`
- merge sorted lists = `O(n + m)`

## 46. Space complexity intuition

Most basic pointer manipulations me extra space:
- `O(1)`

Recursive linked list operations me:
- recursion stack extra space hoti hai

HashMap based advanced problems me:
- extra auxiliary memory lag sakti hai

## 47. Quick revision sheet

- Linked list nodes ke references se banti hai, indices se nahi
- head sabse important reference hota hai
- singly me next hota hai, doubly me prev + next
- circular list me end wapas start se connect hota hai
- fast-slow pointer linked list ka core pattern hai
- reversal, merge, cycle detection, middle, intersection must-know topics hain
- dummy node edge cases simplify karti hai

## 48. Final takeaway

Linked list mastery ka matlab sirf `ListNode` class ya traversal yaad karna nahi hai. Real mastery tab hoti hai jab tum arrows aur references ko mentally track kar pao aur samajh pao:

- kaunsa pointer kahan point kar raha hai
- kaunsa link break hone wala hai
- head kab update karna hai
- dummy node helpful hogi ya nahi
- fast-slow pattern lag sakta hai ya nahi

Linked list strong ho gayi to trees, graphs, recursion on nodes, aur pointer-heavy interview questions kaafi easy lagne lagte hain.

## 49. Problems by Tier and Company Expectation

### 🏢 TIER 1 — Service Based (TCS, Wipro, Infosys, Cognizant)
Basic LL operations — yahan implementation samajhni chahiye.

| # | Problem | LC # | Company | Level |
|---|---|---|---|---|
| 1 | Reverse Linked List | #206 | TCS, Wipro, Har jagah | 🟢 Easy |
| 2 | Merge Two Sorted Lists | #21 | TCS, Infosys, Amazon | 🟢 Easy |
| 3 | Linked List Cycle | #141 | TCS, Wipro, Cognizant | 🟢 Easy |
| 4 | Middle of Linked List | #876 | Infosys, Capgemini | 🟢 Easy |
| 5 | Delete Node in Linked List | #237 | TCS, HCL | 🟢 Easy |
| 6 | Remove Duplicates from Sorted List | #83 | Wipro, Cognizant | 🟢 Easy |
| 7 | Palindrome Linked List | #234 | TCS, Infosys | 🟢 Easy |
| 8 | Intersection of Two Linked Lists | #160 | Cognizant, Amazon | 🟢 Easy |

### 🏢 TIER 2 — Mid Product Based (Adobe, Flipkart, Paytm, Bloomberg)

| # | Problem | LC # | Company | Level |
|---|---|---|---|---|
| 9 | Remove Nth Node from End | #19 | Amazon, Microsoft, Adobe | 🟡 Medium |
| 10 | Linked List Cycle II (find start) | #142 | Amazon, Adobe | 🟡 Medium |
| 11 | Reorder List | #143 | Amazon, Bloomberg | 🟡 Medium |
| 12 | Swap Nodes in Pairs | #24 | Amazon, Microsoft | 🟡 Medium |
| 13 | Add Two Numbers | #2 | Amazon, Microsoft, Meta | 🟡 Medium |
| 14 | Odd Even Linked List | #328 | Flipkart, Amazon | 🟡 Medium |
| 15 | Sort List | #148 | Amazon, Microsoft | 🟡 Medium |
| 16 | Remove Linked List Elements | #203 | Adobe, Paytm | 🟢 Easy |

### 🏢 TIER 3 — FAANG (Amazon, Google, Microsoft, Meta)

| # | Problem | LC # | Company | Level |
|---|---|---|---|---|
| 17 | Reverse Nodes in k-Group | #25 | Amazon, Google, Microsoft | 🔴 Hard |
| 18 | Merge k Sorted Lists | #23 | Amazon, Google, Microsoft | 🔴 Hard |
| 19 | Copy List with Random Pointer | #138 | Amazon, Microsoft, Meta | 🟡 Medium |
| 20 | LRU Cache | #146 | Amazon, Google, Meta, Microsoft | 🟡 Medium |
| 21 | Add Two Numbers II | #445 | Amazon, Meta | 🟡 Medium |
| 22 | Flatten a Multilevel Doubly LL | #430 | Amazon, Microsoft | 🟡 Medium |
| 23 | Rotate List | #61 | Amazon, Microsoft | 🟡 Medium |
| 24 | Design Linked List | #707 | Microsoft, Google | 🟡 Medium |
| 25 | LFU Cache | #460 | Google, Amazon | 🔴 Hard |

LRU Cache aur LFU Cache design problems FAANG interviews mein Design Data Structures category ke under bahut frequently poochhe jaate hain.

## 50. 🔥 Special Pattern — Fast & Slow Pointer (Floyd's Algorithm)
Fast-Slow pointer technique mein slow pointer ek node aage badhta hai aur fast pointer do nodes — agar cycle hai toh dono zaroor milenge.
Slow → 1 step at a time
Fast → 2 steps at a time

Applications:
✅ Cycle detect karo          → #141
✅ Cycle start dhundho        → #142
✅ Middle dhundho             → #876
✅ Nth from end dhundho       → #19
✅ Palindrome check karo      → #234

## 51. 🧩 Java Templates — Interview Mein Kaam Aayenge

### Template 1: Reverse a Linked List
`java
ListNode reverse(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
        ListNode next = curr.next;  // save next
        curr.next = prev;           // reverse link
        prev = curr;                // move prev
        curr = next;                // move curr
    }
    return prev;
}
`

### Template 2: Fast-Slow Pointer
`java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;        // 1 step
    fast = fast.next.next;   // 2 steps
}
// slow ab middle pe hai
`

### Template 3: LRU Cache (HashMap + Doubly LL)
`java
class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    DoublyLinkedList dll = new DoublyLinkedList();
    int capacity;

    // get → O(1), put → O(1)
    // Least recently used → tail ke paas
    // Most recently used → head ke paas
}
`

## 52. 📊 Pattern → Problem Mapping

| Pattern | Problems |
|---|---|
| Fast-Slow pointer | Cycle (#141, #142), Middle (#876), Palindrome (#234) |
| Reversal | Reverse LL (#206), k-Group (#25), Reorder (#143) |
| Two pointer | Nth from end (#19), Intersection (#160) |
| Merge | Merge 2 sorted (#21), Merge k sorted (#23) |
| HashMap + LL | LRU Cache (#146), Copy Random (#138) |
| Recursion on LL | Reverse (#206), Merge sorted (#21) |

## 53. 📊 Company-Wise Expectation

| Company | Kya Expect Karein |
|---|---|
| TCS / Wipro / Capgemini | Reverse LL, Cycle detect, Palindrome LL, Middle |
| Infosys / Cognizant | Merge sorted, Delete node, Duplicates remove |
| Adobe / Flipkart | Add Two Numbers, Odd-Even LL, Reorder List |
| Amazon | Reverse k-Group, Merge k Lists, LRU Cache, Copy Random |
| Microsoft | Swap Pairs, Flatten LL, Rotate List, Sort List |
| Google | LRU/LFU Cache, Merge k Lists, Reverse k-Group |
| Meta | Add Two Numbers, Copy Random, LRU Cache variants |

## 54. ⚡ Edge Cases — Interview Mein Galti Mat Karna

`java
// Ye cases hamesha check karo:
if (head == null) return null;          // Empty list
if (head.next == null) return head;     // Single node
// Even vs Odd length list
// Cycle hai toh null check karte waqt infinite loop
`

## 55. 🎯 Kitne Problems Karne Chahiye

| Level | Count |
|---|---|
| 🟢 Easy (foundation) | 6–7 |
| 🟡 Medium (core patterns) | 10–12 |
| 🔴 Hard (FAANG specific) | 2–3 |
| **Total** | **~20 problems** |

## 56. 🏆 MUST DO — Top 6 Linked List Problems

1. **#206 Reverse Linked List** — har company poochhti hai, foundation
2. **#141 Linked List Cycle** — Fast-Slow pointer ka intro
3. **#21 Merge Two Sorted Lists** — pointer manipulation basics
4. **#19 Remove Nth Node from End** — two-pointer + dummy node
5. **#146 LRU Cache** — FAANG ka design favorite
6. **#25 Reverse Nodes in k-Group** — Amazon ka hard question.

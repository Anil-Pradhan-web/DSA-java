# Binary Search Tree Complete Notes

## 1. BST Kya Hota Hai?

Binary Search Tree ek special Binary Tree hai jisme har node ke liye:

```text
Left subtree ke saare values < root.val
Right subtree ke saare values > root.val
```

Yahi property search, insert, delete ko average case mein O(log n) banati hai.

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
```

## 2. BST vs Binary Tree

| Binary Tree | Binary Search Tree |
|---|---|
| Koi ordering rule nahi hota | Left < Root < Right rule hota hai |
| Search usually O(n) | Search average O(log n) |
| Inorder random order de sakta hai | Inorder sorted order deta hai |
| LCA mein dono side search karte hain | LCA mein value compare karke direction choose karte hain |

## 3. Most Important BST Property

BST ka inorder traversal sorted order deta hai.

```java
void inorder(TreeNode root) {
    if (root == null) return;

    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

Is property se ye problems solve hoti hain:
- Validate BST
- Kth Smallest Element
- BST Iterator
- Recover BST
- Two Sum in BST

## 4. Search in BST

Recursive:

```java
TreeNode searchBST(TreeNode root, int val) {
    if (root == null || root.val == val) {
        return root;
    }

    if (val < root.val) {
        return searchBST(root.left, val);
    }

    return searchBST(root.right, val);
}
```

Iterative:

```java
TreeNode searchBST(TreeNode root, int val) {
    while (root != null && root.val != val) {
        if (val < root.val) {
            root = root.left;
        } else {
            root = root.right;
        }
    }

    return root;
}
```

Complexity:
- Balanced BST: O(log n)
- Skewed BST: O(n)

## 5. Insert in BST

```java
TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }

    if (val < root.val) {
        root.left = insertIntoBST(root.left, val);
    } else if (val > root.val) {
        root.right = insertIntoBST(root.right, val);
    }

    return root;
}
```

Note: LeetCode usually unique values assume karta hai. Agar duplicates allowed hon to pehle rule define karo: duplicate left mein jayega ya right mein.

## 6. Delete in BST

Delete ke 3 cases:

1. Node leaf hai: null return karo.
2. Node ka one child hai: wahi child return karo.
3. Node ke two children hain: inorder successor se replace karo.

Inorder successor = right subtree ka minimum node.

```java
TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    if (key < root.val) {
        root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
        root.right = deleteNode(root.right, key);
    } else {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        TreeNode successor = findMin(root.right);
        root.val = successor.val;
        root.right = deleteNode(root.right, successor.val);
    }

    return root;
}

TreeNode findMin(TreeNode root) {
    while (root.left != null) {
        root = root.left;
    }
    return root;
}
```

## 7. Validate BST

Common mistake: sirf immediate child compare karna enough nahi hota.

Wrong thinking:

```text
root.left.val < root.val && root.right.val > root.val
```

Correct thinking:
Har node ke liye valid range maintain karo.

```java
boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

boolean validate(TreeNode root, long low, long high) {
    if (root == null) return true;

    if (root.val <= low || root.val >= high) {
        return false;
    }

    return validate(root.left, low, root.val)
        && validate(root.right, root.val, high);
}
```

`long` use karo kyunki node value `Integer.MIN_VALUE` ya `Integer.MAX_VALUE` ho sakti hai.

## 8. Lowest Common Ancestor in BST

BST property se direction decide hoti hai.

```java
TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
        if (p.val < root.val && q.val < root.val) {
            root = root.left;
        } else if (p.val > root.val && q.val > root.val) {
            root = root.right;
        } else {
            return root;
        }
    }

    return null;
}
```

Agar p aur q split ho rahe hain, current root hi LCA hai.

## 9. Kth Smallest in BST

Inorder sorted order deta hai, to kth smallest = inorder ka kth element.

```java
int count = 0;
int answer = -1;

int kthSmallest(TreeNode root, int k) {
    inorderKth(root, k);
    return answer;
}

void inorderKth(TreeNode root, int k) {
    if (root == null) return;

    inorderKth(root.left, k);

    count++;
    if (count == k) {
        answer = root.val;
        return;
    }

    inorderKth(root.right, k);
}
```

## 10. BST Iterator

Goal:
- `next()` average O(1)
- `hasNext()` O(1)
- Space O(h)

```java
class BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
```

## 11. Convert Sorted Array to BST

Balanced BST banane ke liye middle element root banao.

```java
TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length - 1);
}

TreeNode build(int[] nums, int left, int right) {
    if (left > right) return null;

    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(nums[mid]);

    root.left = build(nums, left, mid - 1);
    root.right = build(nums, mid + 1, right);

    return root;
}
```

## 12. Two Sum IV in BST

Approach 1: DFS + HashSet.

```java
boolean findTarget(TreeNode root, int k) {
    Set<Integer> seen = new HashSet<>();
    return dfs(root, k, seen);
}

boolean dfs(TreeNode root, int k, Set<Integer> seen) {
    if (root == null) return false;

    if (seen.contains(k - root.val)) {
        return true;
    }

    seen.add(root.val);

    return dfs(root.left, k, seen) || dfs(root.right, k, seen);
}
```

Approach 2: Inorder sorted list + two pointers.

## 13. Range Sum of BST

BST property se unnecessary branches skip kar sakte hain.

```java
int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) return 0;

    if (root.val < low) {
        return rangeSumBST(root.right, low, high);
    }

    if (root.val > high) {
        return rangeSumBST(root.left, low, high);
    }

    return root.val
        + rangeSumBST(root.left, low, high)
        + rangeSumBST(root.right, low, high);
}
```

## 14. Inorder Successor

Inorder successor = next greater node.

```java
TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode successor = null;

    while (root != null) {
        if (p.val < root.val) {
            successor = root;
            root = root.left;
        } else {
            root = root.right;
        }
    }

    return successor;
}
```

## 15. Recover BST

BST mein two nodes swapped hain. Inorder sorted hona chahiye. Jahan order break hota hai, wahi swapped nodes detect hote hain.

```java
TreeNode first = null;
TreeNode second = null;
TreeNode prev = null;

void recoverTree(TreeNode root) {
    inorderRecover(root);

    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}

void inorderRecover(TreeNode root) {
    if (root == null) return;

    inorderRecover(root.left);

    if (prev != null && prev.val > root.val) {
        if (first == null) first = prev;
        second = root;
    }

    prev = root;
    inorderRecover(root.right);
}
```

## 16. Trim BST

Range ke bahar nodes remove karne hain.

```java
TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) return null;

    if (root.val < low) {
        return trimBST(root.right, low, high);
    }

    if (root.val > high) {
        return trimBST(root.left, low, high);
    }

    root.left = trimBST(root.left, low, high);
    root.right = trimBST(root.right, low, high);

    return root;
}
```

## 17. Convert BST to Greater Tree

Reverse inorder use hota hai: Right -> Root -> Left.

```java
int sum = 0;

TreeNode convertBST(TreeNode root) {
    if (root == null) return null;

    convertBST(root.right);

    sum += root.val;
    root.val = sum;

    convertBST(root.left);

    return root;
}
```

## 18. Balance a BST

Idea:
1. Inorder se sorted list banao.
2. Sorted list se balanced BST build karo.

```java
TreeNode balanceBST(TreeNode root) {
    List<Integer> nums = new ArrayList<>();
    inorder(root, nums);
    return build(nums, 0, nums.size() - 1);
}

void inorder(TreeNode root, List<Integer> nums) {
    if (root == null) return;
    inorder(root.left, nums);
    nums.add(root.val);
    inorder(root.right, nums);
}

TreeNode build(List<Integer> nums, int left, int right) {
    if (left > right) return null;

    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(nums.get(mid));
    root.left = build(nums, left, mid - 1);
    root.right = build(nums, mid + 1, right);

    return root;
}
```

## 19. Common BST Patterns

| Pattern | Use Cases |
|---|---|
| Inorder sorted | Kth smallest, validate, recover |
| Range recursion | Validate BST, trim BST |
| Direction choosing | Search, insert, delete, LCA |
| Binary-search style | Closest value, successor |
| DFS + HashSet | Two Sum IV |
| Sorted input build | Sorted array/list to BST |
| Reverse inorder | Greater tree |

## 20. Important BST Problems

| # | Problem | LC | Level | Pattern |
|---|---|---|---|---|
| 1 | Search in a BST | 700 | Easy | Direction search |
| 2 | Insert into a BST | 701 | Medium | Direction insert |
| 3 | Delete Node in a BST | 450 | Medium | Successor |
| 4 | Validate Binary Search Tree | 98 | Medium | Range DFS |
| 5 | Lowest Common Ancestor of BST | 235 | Medium | Direction search |
| 6 | Kth Smallest Element in BST | 230 | Medium | Inorder |
| 7 | Convert Sorted Array to BST | 108 | Easy | Divide and conquer |
| 8 | Range Sum of BST | 938 | Easy | Pruning |
| 9 | Two Sum IV | 653 | Easy | DFS + Set |
| 10 | BST Iterator | 173 | Medium | Controlled inorder |
| 11 | Inorder Successor in BST | 285 | Medium | Next greater |
| 12 | Recover Binary Search Tree | 99 | Medium | Inorder anomaly |
| 13 | Trim a BST | 669 | Medium | Range recursion |
| 14 | Convert BST to Greater Tree | 538 | Medium | Reverse inorder |
| 15 | Balance a BST | 1382 | Medium | Inorder + rebuild |

## 21. Company-Wise Expectation

| Company | Kya Expect Karein |
|---|---|
| TCS / Wipro | Search, insert, inorder, validate basics |
| Infosys / Cognizant | LCA of BST, sorted array to BST |
| Adobe / Flipkart | Kth smallest, delete node, range sum |
| Amazon | Validate BST, BST iterator, recover BST |
| Microsoft | Delete node, kth smallest, LCA |
| Google | Recover BST, iterator variants, balance BST |
| Meta | Validate BST, LCA, two sum in BST |

## 22. Complexity Summary

| Operation | Balanced BST | Skewed BST |
|---|---|---|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Min/Max | O(log n) | O(n) |
| Inorder traversal | O(n) | O(n) |
| Kth smallest | O(h + k) | O(n) |

Space:
- Recursive operations: O(h)
- Full inorder list: O(n)
- Iterator: O(h)

## 23. Interview Mistakes

- Validate BST mein sirf parent-child compare karna.
- Range validation mein `int` min/max use karna; safer `long` hai.
- Delete node ke two-child case mein successor handle na karna.
- BST LCA aur Binary Tree LCA logic mix karna.
- Kth smallest mein global `count` reset na karna.
- Duplicate values ka rule clear na karna.

## 24. Must Do Problems

1. Search in BST
2. Insert into BST
3. Delete Node in BST
4. Validate BST
5. Lowest Common Ancestor of BST
6. Kth Smallest Element in BST
7. BST Iterator
8. Range Sum of BST
9. Two Sum IV
10. Recover Binary Search Tree

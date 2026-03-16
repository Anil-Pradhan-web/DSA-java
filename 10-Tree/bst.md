# Binary Search Trees in Java for DSA

## 1. BST kya hota hai?

Binary Search Tree ek binary tree hota hai jahan har node ke liye:

- left subtree ke values < root
- right subtree ke values > root

### Java node structure

```java
static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
```

## 2. Important properties of BST

- search average case me fast hota hai
- inorder traversal sorted order deta hai
- insertion aur deletion tree height `h` par depend karte hain
- search complexity = `O(h)`

## 3. Search in BST

```java
public static TreeNode searchBST(TreeNode root, int key) {
    while (root != null && root.val != key) {
        if (key < root.val) {
            root = root.left;
        } else {
            root = root.right;
        }
    }
    return root;
}
```

## 4. Insertion in BST

```java
public static TreeNode insertIntoBST(TreeNode root, int val) {
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

## 5. Deletion in BST

3 cases:

- leaf node
- one child
- two children

```java
public static TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
        return null;
    }

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

public static TreeNode findMin(TreeNode root) {
    while (root.left != null) {
        root = root.left;
    }
    return root;
}
```

## 6. Inorder traversal of BST gives sorted order

```java
public static void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

## 7. Validate if a tree is a valid BST

```java
public static boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private static boolean validate(TreeNode root, long min, long max) {
    if (root == null) return true;
    if (root.val <= min || root.val >= max) return false;
    return validate(root.left, min, root.val) && validate(root.right, root.val, max);
}
```

## 8. Find floor and ceil in BST

```java
public static Integer floorInBST(TreeNode root, int key) {
    Integer floor = null;

    while (root != null) {
        if (root.val == key) return root.val;

        if (root.val > key) {
            root = root.left;
        } else {
            floor = root.val;
            root = root.right;
        }
    }

    return floor;
}

public static Integer ceilInBST(TreeNode root, int key) {
    Integer ceil = null;

    while (root != null) {
        if (root.val == key) return root.val;

        if (root.val < key) {
            root = root.right;
        } else {
            ceil = root.val;
            root = root.left;
        }
    }

    return ceil;
}
```

## 9. BST vs Balanced BST

### BST

Normal BST skewed bhi ho sakta hai.

### Balanced BST

Height controlled hoti hai, isliye operations fast rehte hain.

Examples:

- AVL Tree
- Red-Black Tree

## 10. Self-balancing trees and AVL rotations

AVL tree me har node ka balance factor maintain hota hai.

Balance factor:

- height(left) - height(right)

Imbalance cases:

- LL
- RR
- LR
- RL

Inko fix karne ke liye rotations use hoti hain.

## 11. Practice Problems

## 11.1 Search in BST

```java
public static TreeNode searchInBST(TreeNode root, int val) {
    return searchBST(root, val);
}
```

## 11.2 Insert into BST

```java
public static TreeNode insertBST(TreeNode root, int val) {
    return insertIntoBST(root, val);
}
```

## 11.3 Delete node from BST

```java
public static TreeNode deleteFromBST(TreeNode root, int key) {
    return deleteNode(root, key);
}
```

## 11.4 Find kth smallest element in BST

```java
static int count = 0;
static int kthAnswer = -1;

public static int kthSmallest(TreeNode root, int k) {
    count = 0;
    kthAnswer = -1;
    kthSmallestHelper(root, k);
    return kthAnswer;
}

private static void kthSmallestHelper(TreeNode root, int k) {
    if (root == null || kthAnswer != -1) return;
    kthSmallestHelper(root.left, k);
    count++;
    if (count == k) {
        kthAnswer = root.val;
        return;
    }
    kthSmallestHelper(root.right, k);
}
```

## 11.5 Lowest common ancestor in BST

```java
public static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
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

## 11.6 Convert sorted array to balanced BST

```java
public static TreeNode sortedArrayToBST(int[] nums) {
    return buildBST(nums, 0, nums.length - 1);
}

private static TreeNode buildBST(int[] nums, int left, int right) {
    if (left > right) return null;
    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = buildBST(nums, left, mid - 1);
    root.right = buildBST(nums, mid + 1, right);
    return root;
}
```

## 11.7 Inorder successor and predecessor in BST

```java
public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
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

public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
    TreeNode predecessor = null;
    while (root != null) {
        if (p.val > root.val) {
            predecessor = root;
            root = root.right;
        } else {
            root = root.left;
        }
    }
    return predecessor;
}
```

## 11.8 Convert BST to sorted doubly linked list

```java
static TreeNode dllPrev = null;
static TreeNode dllHead = null;

public static TreeNode bstToDoublyList(TreeNode root) {
    dllPrev = null;
    dllHead = null;
    convertToDLL(root);
    return dllHead;
}

private static void convertToDLL(TreeNode root) {
    if (root == null) return;

    convertToDLL(root.left);

    if (dllPrev == null) {
        dllHead = root;
    } else {
        dllPrev.right = root;
        root.left = dllPrev;
    }
    dllPrev = root;

    convertToDLL(root.right);
}
```

## 11.9 Two sum in BST

```java
public static boolean findTarget(TreeNode root, int k) {
    java.util.HashSet<Integer> set = new java.util.HashSet<>();
    return twoSumDFS(root, k, set);
}

private static boolean twoSumDFS(TreeNode root, int k, java.util.Set<Integer> set) {
    if (root == null) return false;
    if (set.contains(k - root.val)) return true;
    set.add(root.val);
    return twoSumDFS(root.left, k, set) || twoSumDFS(root.right, k, set);
}
```

## 12. Time complexity summary

- search / insert / delete = `O(h)`
- validate BST = `O(n)`
- kth smallest = `O(h + k)` typically
- sorted array to BST = `O(n)`
- successor/predecessor = `O(h)`

## 13. Quick revision summary

- BST property: left < root < right
- inorder traversal sorted order deta hai
- search, insert, delete height dependent hote hain
- floor/ceil, LCA, kth smallest classic BST problems hain
- balanced BST concepts AVL and Red-Black trees ko samajhna useful hai

## 14. Final takeaway

BST binary tree ka ordered version hai jo searching problems ko efficient banata hai.

Java interview ke liye most important practical points:

- BST property mastery
- search / insert / delete
- validation
- inorder sorted insight
- successor / predecessor
- balanced BST concept

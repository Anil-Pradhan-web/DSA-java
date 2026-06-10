# Binary Tree Complete Notes

## 1. Binary Tree Kya Hota Hai?

Binary Tree ek hierarchical data structure hai jisme har node ke maximum 2 children ho sakte hain: left child aur right child.

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

Tree linear data structure nahi hai. Array/Linked List mein ek direction mein traversal hota hai, lekin tree mein branches hoti hain, isliye recursion aur BFS/DFS bahut important hain.

## 2. Important Terms

| Term | Meaning |
|---|---|
| Root | Tree ka top node |
| Parent | Jiske child nodes hote hain |
| Child | Kisi node ke neeche connected node |
| Leaf Node | Jiska koi child nahi hota |
| Sibling | Same parent ke children |
| Edge | Do nodes ke beech connection |
| Height | Node se deepest leaf tak longest path |
| Depth | Root se current node tak distance |
| Level | Same depth wale nodes |
| Subtree | Kisi node se start hone wala tree |

## 3. Types of Binary Tree

| Type | Explanation |
|---|---|
| Full Binary Tree | Har node ke ya to 0 ya 2 children hote hain |
| Complete Binary Tree | Last level ko chhod ke sab full, last level left se filled |
| Perfect Binary Tree | Sab internal nodes ke 2 children aur leaves same level par |
| Balanced Binary Tree | Left/right subtree height difference controlled hota hai |
| Skewed Tree | Tree linked list jaisa ban jata hai |

## 4. DFS Traversals

DFS ka matlab depth mein jaana. Tree DFS mostly recursion se easy hota hai.

### Inorder Traversal

Order: Left -> Root -> Right

BST mein inorder sorted order deta hai.

```java
void inorder(TreeNode root) {
    if (root == null) return;

    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

### Preorder Traversal

Order: Root -> Left -> Right

Use cases:
- Tree copy/clone
- Serialize tree
- Root-first processing

```java
void preorder(TreeNode root) {
    if (root == null) return;

    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
}
```

### Postorder Traversal

Order: Left -> Right -> Root

Use cases:
- Delete tree
- Height, diameter, max path type bottom-up problems
- Jab child ka answer pehle chahiye

```java
void postorder(TreeNode root) {
    if (root == null) return;

    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
}
```

## 5. Iterative DFS Using Stack

Recursion internally stack use karta hai. Interview mein kabhi iterative bhi pooch sakte hain.

```java
List<Integer> inorderIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
    }

    return result;
}
```

## 6. BFS / Level Order Traversal

BFS level by level process karta hai. Queue use hoti hai.

```java
List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            level.add(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        result.add(level);
    }

    return result;
}
```

Important: `queue.size()` ko level start par store karo. Agar loop ke andar dynamic size use karoge to level mix ho sakta hai.

## 7. Universal Tree Recursion Template

Tree problems mein hamesha ye socho:

```text
1. Base case kya hai?
2. Left subtree se kya answer chahiye?
3. Right subtree se kya answer chahiye?
4. Root par dono answers combine kaise honge?
```

```java
ReturnType solve(TreeNode root) {
    if (root == null) {
        return baseValue;
    }

    ReturnType left = solve(root.left);
    ReturnType right = solve(root.right);

    return combine(root, left, right);
}
```

## 8. Height / Maximum Depth

```java
int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    return 1 + Math.max(left, right);
}
```

Time: O(n)  
Space: O(h)

## 9. Count Nodes

```java
int countNodes(TreeNode root) {
    if (root == null) return 0;

    return 1 + countNodes(root.left) + countNodes(root.right);
}
```

## 10. Minimum Depth

Common mistake: agar ek child null hai to us side ka depth 0 choose mat karo.

```java
int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null) return 1 + minDepth(root.right);
    if (root.right == null) return 1 + minDepth(root.left);

    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
}
```

## 11. Diameter of Binary Tree

Diameter = longest path between any two nodes. Path root se pass ho bhi sakta hai, nahi bhi.

```java
int diameter = 0;

int height(TreeNode root) {
    if (root == null) return 0;

    int left = height(root.left);
    int right = height(root.right);

    diameter = Math.max(diameter, left + right);

    return 1 + Math.max(left, right);
}
```

## 12. Balanced Binary Tree

Balanced tree mein har node par left aur right height difference <= 1 hota hai.

```java
boolean isBalanced(TreeNode root) {
    return checkHeight(root) != -1;
}

int checkHeight(TreeNode root) {
    if (root == null) return 0;

    int left = checkHeight(root.left);
    if (left == -1) return -1;

    int right = checkHeight(root.right);
    if (right == -1) return -1;

    if (Math.abs(left - right) > 1) return -1;

    return 1 + Math.max(left, right);
}
```

## 13. Same Tree

Structure aur values dono same hone chahiye.

```java
boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;

    return p.val == q.val
        && isSameTree(p.left, q.left)
        && isSameTree(p.right, q.right);
}
```

## 14. Symmetric Tree

Left subtree aur right subtree mirror hone chahiye.

```java
boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isMirror(root.left, root.right);
}

boolean isMirror(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;

    return a.val == b.val
        && isMirror(a.left, b.right)
        && isMirror(a.right, b.left);
}
```

## 15. Invert Binary Tree

Har node par left aur right child swap karo.

```java
TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;
}
```

## 16. Path Sum

Root se leaf tak path ka sum target ke equal hai ya nahi.

```java
boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;

    if (root.left == null && root.right == null) {
        return targetSum == root.val;
    }

    return hasPathSum(root.left, targetSum - root.val)
        || hasPathSum(root.right, targetSum - root.val);
}
```

## 17. Lowest Common Ancestor in Binary Tree

Binary Tree mein BST ordering nahi hoti, isliye left aur right dono side search karte hain.

```java
TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
        return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) return root;

    return left != null ? left : right;
}
```

## 18. Right Side View

Har level ka last node right side se visible hota hai.

```java
List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();

            if (i == size - 1) result.add(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    return result;
}
```

## 19. Zigzag Level Order

Level direction alternate hota hai.

```java
List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean leftToRight = true;

    while (!queue.isEmpty()) {
        int size = queue.size();
        LinkedList<Integer> level = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();

            if (leftToRight) level.addLast(node.val);
            else level.addFirst(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        result.add(level);
        leftToRight = !leftToRight;
    }

    return result;
}
```

## 20. Construct Tree from Preorder and Inorder

Preorder ka first element root hota hai. Inorder mein root ke left side left subtree aur right side right subtree hota hai.

```java
Map<Integer, Integer> map = new HashMap<>();
int preIndex = 0;

TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
    }
    return build(preorder, 0, inorder.length - 1);
}

TreeNode build(int[] preorder, int left, int right) {
    if (left > right) return null;

    int rootVal = preorder[preIndex++];
    TreeNode root = new TreeNode(rootVal);
    int mid = map.get(rootVal);

    root.left = build(preorder, left, mid - 1);
    root.right = build(preorder, mid + 1, right);

    return root;
}
```

## 21. Serialize and Deserialize Binary Tree

Tree ko string mein convert karna serialize, aur string se tree wapas banana deserialize.

```java
String serialize(TreeNode root) {
    if (root == null) return "#,";

    return root.val + "," + serialize(root.left) + serialize(root.right);
}

TreeNode deserialize(Queue<String> queue) {
    String value = queue.poll();
    if (value.equals("#")) return null;

    TreeNode root = new TreeNode(Integer.parseInt(value));
    root.left = deserialize(queue);
    root.right = deserialize(queue);

    return root;
}
```

## 22. Binary Tree Maximum Path Sum

Har node par 2 cheeze calculate hoti hain:
- Ek side ka best gain parent ko return karna hai.
- Left + root + right se global max update karna hai.

```java
int maxSum = Integer.MIN_VALUE;

int maxGain(TreeNode root) {
    if (root == null) return 0;

    int left = Math.max(0, maxGain(root.left));
    int right = Math.max(0, maxGain(root.right));

    maxSum = Math.max(maxSum, root.val + left + right);

    return root.val + Math.max(left, right);
}
```

## 23. Pattern Mapping

| Pattern | Problems |
|---|---|
| Basic DFS | Traversals, max depth, count nodes |
| Bottom-up DFS | Diameter, balanced tree, max path sum |
| Mirror recursion | Symmetric tree, invert tree |
| BFS Queue | Level order, zigzag, right side view, min depth |
| Root-to-leaf path | Path sum, all paths |
| LCA recursion | Lowest common ancestor |
| Build tree | Preorder + inorder, inorder + postorder |
| Serialization | Encode/decode tree |

## 24. Important Binary Tree Problems

| # | Problem | LC | Level | Pattern |
|---|---|---|---|---|
| 1 | Binary Tree Inorder Traversal | 94 | Easy | DFS |
| 2 | Preorder Traversal | 144 | Easy | DFS |
| 3 | Postorder Traversal | 145 | Easy | DFS |
| 4 | Maximum Depth | 104 | Easy | DFS |
| 5 | Same Tree | 100 | Easy | DFS |
| 6 | Symmetric Tree | 101 | Easy | Mirror DFS |
| 7 | Invert Binary Tree | 226 | Easy | DFS |
| 8 | Path Sum | 112 | Easy | Root-to-leaf |
| 9 | Level Order Traversal | 102 | Medium | BFS |
| 10 | Zigzag Level Order | 103 | Medium | BFS |
| 11 | Right Side View | 199 | Medium | BFS |
| 12 | Diameter of Binary Tree | 543 | Easy | Bottom-up DFS |
| 13 | Balanced Binary Tree | 110 | Easy | Bottom-up DFS |
| 14 | Lowest Common Ancestor | 236 | Medium | DFS |
| 15 | Construct Tree from Preorder/Inorder | 105 | Medium | Recursion + Map |
| 16 | Flatten Binary Tree to Linked List | 114 | Medium | DFS |
| 17 | Count Complete Tree Nodes | 222 | Medium | Complete tree |
| 18 | Binary Tree Maximum Path Sum | 124 | Hard | Hard DFS |
| 19 | Serialize and Deserialize Binary Tree | 297 | Hard | DFS/BFS |
| 20 | Populating Next Right Pointers | 116 | Medium | BFS/Pointer |

## 25. Company-Wise Expectation

| Company | Kya Expect Karein |
|---|---|
| TCS / Wipro | Traversals, height, count nodes, mirror |
| Infosys / Cognizant | Same tree, symmetric tree, path sum |
| Adobe / Flipkart | Level order, zigzag, diameter |
| Amazon | LCA, right view, serialize/deserialize, max path |
| Microsoft | Build tree, level order, flatten tree |
| Google | Max path sum, serialization, hard recursion variants |
| Meta | Right side view, LCA, BFS variants |

## 26. Complexity Summary

| Operation | Time | Space |
|---|---|---|
| DFS traversal | O(n) | O(h) |
| BFS traversal | O(n) | O(w) |
| Height | O(n) | O(h) |
| Diameter optimized | O(n) | O(h) |
| LCA binary tree | O(n) | O(h) |
| Build from traversal | O(n) | O(n) |

Here:
- n = number of nodes
- h = height of tree
- w = maximum width of tree

## 27. Common Mistakes

- `root == null` base case bhoolna.
- Minimum depth mein null child ko 0 maan lena.
- Diameter mein height aur diameter confuse karna.
- BFS mein `queue.size()` level start par store na karna.
- Global variable reset na karna.
- BST aur Binary Tree ka LCA logic mix kar dena.

## 28. Must Do Problems

1. Binary Tree Level Order Traversal
2. Maximum Depth of Binary Tree
3. Diameter of Binary Tree
4. Balanced Binary Tree
5. Symmetric Tree
6. Path Sum
7. Binary Tree Right Side View
8. Lowest Common Ancestor
9. Construct Tree from Preorder and Inorder
10. Serialize and Deserialize Binary Tree

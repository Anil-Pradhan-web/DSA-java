# Binary Trees in Java for DSA

## 1. Binary Tree kya hota hai?

Binary tree ek hierarchical data structure hota hai jahan har node ke maximum 2 children ho sakte hain:

- left child
- right child

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

## 2. Important terminology

- `root` -> topmost node
- `leaf` -> jiska koi child nahi
- `parent` -> jo kisi node ke upar hota hai
- `child` -> parent ke niche wala node
- `sibling` -> same parent ke children
- `height` -> node se leaf tak longest path edges count
- `depth` -> root se node tak distance
- `level` -> same depth wale nodes

## 3. Types of binary trees

### Full binary tree

Har node ke ya to 0 ya 2 children hote hain.

### Complete binary tree

Saare levels filled hote hain except last, aur last level left se filled hota hai.

### Perfect binary tree

Har internal node ke 2 children hote hain aur saare leaves same level par hote hain.

### Balanced binary tree

Har node ke left aur right subtree ki height difference controlled hoti hai.

### Degenerate binary tree

Tree linked list jaisa ban jata hai; har node ka ek hi child hota hai.

## 4. DFS Traversals

## 4.1 Inorder

Left -> Root -> Right

### Recursive

```java
public static void inorder(TreeNode root) {
    if (root == null) {
        return;
    }
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

### Iterative using stack

```java
public static java.util.List<Integer> inorderIterative(TreeNode root) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    java.util.Deque<TreeNode> stack = new java.util.ArrayDeque<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        result.add(current.val);
        current = current.right;
    }

    return result;
}
```

## 4.2 Preorder

Root -> Left -> Right

### Recursive

```java
public static void preorder(TreeNode root) {
    if (root == null) {
        return;
    }
    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
}
```

### Iterative using stack

```java
public static java.util.List<Integer> preorderIterative(TreeNode root) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    if (root == null) {
        return result;
    }

    java.util.Deque<TreeNode> stack = new java.util.ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);

        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
    }

    return result;
}
```

## 4.3 Postorder

Left -> Right -> Root

### Recursive

```java
public static void postorder(TreeNode root) {
    if (root == null) {
        return;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
}
```

### Iterative using stack

```java
public static java.util.List<Integer> postorderIterative(TreeNode root) {
    java.util.LinkedList<Integer> result = new java.util.LinkedList<>();
    if (root == null) {
        return result;
    }

    java.util.Deque<TreeNode> stack = new java.util.ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.addFirst(node.val);

        if (node.left != null) {
            stack.push(node.left);
        }
        if (node.right != null) {
            stack.push(node.right);
        }
    }

    return result;
}
```

## 5. Level order traversal (BFS using queue)

```java
public static java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
    java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
    if (root == null) {
        return result;
    }

    java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int size = queue.size();
        java.util.List<Integer> level = new java.util.ArrayList<>();

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

## 6. Reverse level order traversal

```java
public static java.util.List<Integer> reverseLevelOrder(TreeNode root) {
    java.util.LinkedList<Integer> result = new java.util.LinkedList<>();
    if (root == null) {
        return result;
    }

    java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        result.addFirst(node.val);

        if (node.right != null) queue.offer(node.right);
        if (node.left != null) queue.offer(node.left);
    }

    return result;
}
```

## 7. Construct tree from traversals

## 7.1 Inorder + Preorder

```java
static int preorderIndex = 0;

public static TreeNode buildFromPreIn(int[] preorder, int[] inorder, int inStart, int inEnd,
                                      java.util.Map<Integer, Integer> inMap) {
    if (inStart > inEnd) {
        return null;
    }

    int rootVal = preorder[preorderIndex++];
    TreeNode root = new TreeNode(rootVal);
    int inIndex = inMap.get(rootVal);

    root.left = buildFromPreIn(preorder, inorder, inStart, inIndex - 1, inMap);
    root.right = buildFromPreIn(preorder, inorder, inIndex + 1, inEnd, inMap);
    return root;
}
```

## 7.2 Inorder + Postorder

```java
static int postorderIndex;

public static TreeNode buildFromPostIn(int[] postorder, int[] inorder, int inStart, int inEnd,
                                       java.util.Map<Integer, Integer> inMap) {
    if (inStart > inEnd) {
        return null;
    }

    int rootVal = postorder[postorderIndex--];
    TreeNode root = new TreeNode(rootVal);
    int inIndex = inMap.get(rootVal);

    root.right = buildFromPostIn(postorder, inorder, inIndex + 1, inEnd, inMap);
    root.left = buildFromPostIn(postorder, inorder, inStart, inIndex - 1, inMap);
    return root;
}
```

## 8. Morris Traversal (O(1) space inorder)

```java
public static java.util.List<Integer> morrisInorder(TreeNode root) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    TreeNode current = root;

    while (current != null) {
        if (current.left == null) {
            result.add(current.val);
            current = current.right;
        } else {
            TreeNode predecessor = current.left;
            while (predecessor.right != null && predecessor.right != current) {
                predecessor = predecessor.right;
            }

            if (predecessor.right == null) {
                predecessor.right = current;
                current = current.left;
            } else {
                predecessor.right = null;
                result.add(current.val);
                current = current.right;
            }
        }
    }

    return result;
}
```

## 9. Practice Problems

## 9.1 Find height of binary tree

```java
public static int height(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(height(root.left), height(root.right));
}
```

## 9.2 Find depth of a node from root

```java
public static int depth(TreeNode root, int target, int level) {
    if (root == null) return -1;
    if (root.val == target) return level;

    int left = depth(root.left, target, level + 1);
    if (left != -1) return left;
    return depth(root.right, target, level + 1);
}
```

## 9.3 Check if two trees are identical

```java
public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null || p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}
```

## 9.4 Diameter of binary tree

```java
static int diameter = 0;

public static int diameterOfBinaryTree(TreeNode root) {
    diameter = 0;
    diameterHeight(root);
    return diameter;
}

private static int diameterHeight(TreeNode root) {
    if (root == null) return 0;
    int left = diameterHeight(root.left);
    int right = diameterHeight(root.right);
    diameter = Math.max(diameter, left + right);
    return 1 + Math.max(left, right);
}
```

## 9.5 Lowest common ancestor

```java
public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    if (left != null && right != null) return root;
    return left != null ? left : right;
}
```

## 9.6 Mirror / invert a binary tree

```java
public static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode temp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(temp);
    return root;
}
```

## 9.7 Zigzag level order traversal

```java
public static java.util.List<java.util.List<Integer>> zigzagLevelOrder(TreeNode root) {
    java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
    if (root == null) return result;

    java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
    queue.offer(root);
    boolean leftToRight = true;

    while (!queue.isEmpty()) {
        int size = queue.size();
        java.util.LinkedList<Integer> level = new java.util.LinkedList<>();

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

## 9.8 Check if tree is balanced

```java
public static boolean isBalanced(TreeNode root) {
    return checkBalanced(root) != -1;
}

private static int checkBalanced(TreeNode root) {
    if (root == null) return 0;
    int left = checkBalanced(root.left);
    if (left == -1) return -1;
    int right = checkBalanced(root.right);
    if (right == -1) return -1;
    if (Math.abs(left - right) > 1) return -1;
    return 1 + Math.max(left, right);
}
```

## 9.9 Right side view / Left side view

```java
public static java.util.List<Integer> rightSideView(TreeNode root) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    if (root == null) return result;
    java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
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

```java
public static java.util.List<Integer> leftSideView(TreeNode root) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    if (root == null) return result;
    java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (i == 0) result.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
    return result;
}
```

## 9.10 Vertical order traversal

```java
static class Pair {
    TreeNode node;
    int col;

    Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

public static java.util.List<java.util.List<Integer>> verticalOrder(TreeNode root) {
    java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
    if (root == null) return result;

    java.util.Map<Integer, java.util.List<Integer>> map = new java.util.TreeMap<>();
    java.util.Queue<Pair> queue = new java.util.LinkedList<>();
    queue.offer(new Pair(root, 0));

    while (!queue.isEmpty()) {
        Pair pair = queue.poll();
        map.computeIfAbsent(pair.col, k -> new java.util.ArrayList<>()).add(pair.node.val);
        if (pair.node.left != null) queue.offer(new Pair(pair.node.left, pair.col - 1));
        if (pair.node.right != null) queue.offer(new Pair(pair.node.right, pair.col + 1));
    }

    result.addAll(map.values());
    return result;
}
```

## 9.11 Serialize and deserialize binary tree

```java
public static String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializeHelper(root, sb);
    return sb.toString();
}

private static void serializeHelper(TreeNode root, StringBuilder sb) {
    if (root == null) {
        sb.append("null,");
        return;
    }
    sb.append(root.val).append(',');
    serializeHelper(root.left, sb);
    serializeHelper(root.right, sb);
}

static int deserializeIndex = 0;

public static TreeNode deserialize(String data) {
    String[] values = data.split(",");
    deserializeIndex = 0;
    return deserializeHelper(values);
}

private static TreeNode deserializeHelper(String[] values) {
    if (values[deserializeIndex].equals("null")) {
        deserializeIndex++;
        return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(values[deserializeIndex++]));
    node.left = deserializeHelper(values);
    node.right = deserializeHelper(values);
    return node;
}
```

## 9.12 Maximum path sum in binary tree

```java
static int maxPath = Integer.MIN_VALUE;

public static int maxPathSum(TreeNode root) {
    maxPath = Integer.MIN_VALUE;
    maxPathGain(root);
    return maxPath;
}

private static int maxPathGain(TreeNode root) {
    if (root == null) return 0;
    int left = Math.max(0, maxPathGain(root.left));
    int right = Math.max(0, maxPathGain(root.right));
    maxPath = Math.max(maxPath, root.val + left + right);
    return root.val + Math.max(left, right);
}
```

## 10. Time complexity summary

- DFS traversals = `O(n)`
- level order = `O(n)`
- height = `O(n)`
- diameter = `O(n)`
- LCA = `O(n)`
- serialize/deserialize = `O(n)`
- Morris traversal = `O(n)` time and `O(1)` extra space

## 11. Quick revision summary

- binary tree me har node ke max 2 children hote hain
- DFS traversals: inorder, preorder, postorder
- BFS traversal queue se hota hai
- Morris traversal inorder ko `O(1)` extra space me karta hai
- balanced, full, complete, perfect tree definitions important hain
- diameter, LCA, views, serialization classic interview topics hain

## 12. Final takeaway

Binary tree DSA ka bohot important foundation hai.

Java interview ke liye most important practical points:

- traversal mastery
- DFS vs BFS understanding
- recursive thinking
- height, diameter, LCA, balance check
- construction and serialization

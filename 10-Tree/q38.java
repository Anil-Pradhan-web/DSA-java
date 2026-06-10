/*
 * Pattern: Parent Pointer LCA
 * Company Names: Meta
 * Difficulty: Medium
 * Problem: Lowest Common Ancestor of a Binary Tree III
 * LeetCode: 1650
 *
 * Hinglish Explanation:
 * Har node ke paas parent pointer hai. Ye linked list intersection jaisa solve
 * hota hai. Pointer a p se start, pointer b q se start. Jab null ho to doosre
 * node par jump karo. Dono same distance align hoke LCA par milenge.
 *
 * Time Complexity: O(h)
 * Space Complexity: O(1)
 */
public class q38 {
    static class Node {
        int val;
        Node left, right, parent;
        Node(int val) { this.val = val; }
    }

    public static Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;

        while (a != b) {
            a = (a == null) ? q : a.parent;
            b = (b == null) ? p : b.parent;
        }

        return a;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        Node left = new Node(5);
        Node right = new Node(1);
        root.left = left;
        root.right = right;
        left.parent = root;
        right.parent = root;
        System.out.println(lowestCommonAncestor(left, right).val);
    }
}

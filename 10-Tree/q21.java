import java.util.*;

/*
 * Pattern: Tree Serialization DFS
 * Company Names: Google, Meta, Amazon, All FAANG
 * Difficulty: Hard
 * Problem: Serialize and Deserialize Binary Tree
 * LeetCode: 297
 *
 * Hinglish Explanation:
 * Serialize ka matlab tree ko string mein convert karna. Deserialize ka matlab
 * string se same tree wapas banana. Null nodes ko # se mark karna zaroori hai,
 * warna structure lose ho jayega.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class q21 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static class Codec {
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeDfs(root, sb);
            return sb.toString();
        }

        private void serializeDfs(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(',');
            serializeDfs(root.left, sb);
            serializeDfs(root.right, sb);
        }

        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserializeDfs(queue);
        }

        private TreeNode deserializeDfs(Queue<String> queue) {
            String value = queue.poll();
            if (value.equals("#")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(value));
            root.left = deserializeDfs(queue);
            root.right = deserializeDfs(queue);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
    }
}

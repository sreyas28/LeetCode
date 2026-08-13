import java.util.Arrays;

public class ProblemNo2213 {
    public static void main(String[] args) {
        Solution a = new ProblemNo2213().new Solution();
        System.out.println(Arrays.toString(a.longestRepeating("aabb", "", new int[]{})));
    }

    class Solution {

        class Node {
            int maxLen;

            int suffixLen;
            char suffixChar;

            int prefixLen;
            char prefixChar;

            Node left, right;

            public Node() {
            }

            // only for LeafNode
            public Node(char character) {
                maxLen = 1;
                suffixLen = 1;
                suffixChar = character;
                prefixLen = 1;
                prefixChar = character;
                left = right = null;
            }
        }

        public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
            final int sLen = s.length(), qLen = queryCharacters.length();
            Node head = buildTree(s, 0, sLen - 1);

            int[] res = new int[qLen];
            for (int i = 0; i < qLen; i++) {
                updateTree(queryIndices[i], queryCharacters.charAt(i), head, 0, sLen - 1);
                res[i] = head.maxLen;
            }

            return res;
        }

        private Node buildTree(String s, int start, int end) {
            if (start == end) return new Node(s.charAt(start));

            Node root = new Node();
            int mid = start + (end - start) / 2;
            Node left = buildTree(s, start, mid);
            Node right = buildTree(s, mid + 1, end);

            root.maxLen = Math.max(left.maxLen, right.maxLen);
            if (left.suffixChar == right.prefixChar)
                root.maxLen = Math.max(root.maxLen, left.suffixLen + right.prefixLen);

            root.prefixChar = left.prefixChar;
            root.suffixChar = right.suffixChar;

            root.prefixLen = left.prefixLen;
            if (left.suffixLen == mid - start + 1 && left.suffixChar == right.prefixChar)
                root.prefixLen = Math.max(root.prefixLen, left.suffixLen + right.prefixLen);

            root.suffixLen = right.suffixLen;
            if (right.prefixLen == end - mid && left.suffixChar == right.prefixChar)
                root.suffixLen = Math.max(root.suffixLen, left.suffixLen + right.prefixLen);

            root.left = left;
            root.right = right;

            return root;
        }

        private void updateTree(int i, char c, Node root, int start, int end) {
            if (i == start && start == end) {
                root.suffixChar = c;
                root.prefixChar = c;
                return;
            }

            int mid = start + (end - start) / 2;

            if (i <= mid) updateTree(i, c, root.left, start, mid);
            else updateTree(i, c, root.right, mid + 1, end);

            root.maxLen = Math.max(root.left.maxLen, root.right.maxLen);
            if (root.left.suffixChar == root.right.prefixChar)
                root.maxLen = Math.max(root.maxLen, root.left.suffixLen + root.right.prefixLen);

            root.prefixChar = root.left.prefixChar;
            root.suffixChar = root.right.suffixChar;

            root.prefixLen = root.left.prefixLen;
            if (root.left.suffixLen == mid - start + 1 && root.left.suffixChar == root.right.prefixChar)
                root.prefixLen = Math.max(root.prefixLen, root.left.suffixLen + root.right.prefixLen);

            root.suffixLen = root.right.suffixLen;
            if (root.right.prefixLen == end - mid && root.left.suffixChar == root.right.prefixChar)
                root.suffixLen = Math.max(root.suffixLen, root.left.suffixLen + root.right.prefixLen);
        }

    }

}

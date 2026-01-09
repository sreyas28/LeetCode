public class ProblemNo865 {
    public static void main(String[] args) {

    }

    class Solution {
        private TreeNode Answer = null;
        private int maxLevel = -1;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            DFS(root, 0);
            return Answer;
        }

        private int DFS(TreeNode root, int level) {
            if (root == null) return -1;

            if (root.left == null && root.right == null) {
                if (level > maxLevel) {
                    Answer = root;
                    maxLevel = level;
                }
                return level;
            }

            int left = DFS(root.left, level + 1);
            int right = DFS(root.right, level + 1);

            if(left == right && left == maxLevel) {
                Answer = root;
                return left;
            }
            return Math.max(left, right);
        }

    }

}

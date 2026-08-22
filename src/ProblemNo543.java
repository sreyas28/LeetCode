public class ProblemNo543 {
    public static void main(String[] args) {

    }

    class Solution {
        private int max;

        public int diameterOfBinaryTree(TreeNode root) {
            this.max = 0;
            depth(root);

            return max;
        }

        private int depth(TreeNode root) {
            if (root == null) return 0;

            int left = 0, right = 0;
            if (root.left != null) left = depth(root.left);
            if (root.right != null) right = depth(root.right);

            if (left + right > max) max = Math.max(max, left + right);
            return Math.max(left, right) + 1;
        }
    }

}

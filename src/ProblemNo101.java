public class ProblemNo101 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return mirror(root.left, root.right);
        }

        private boolean mirror(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            return mirror(left.left, right.right) && mirror(left.right, right.left);
        }
    }

}

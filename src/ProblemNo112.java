
public class ProblemNo112 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);

        Solution a = new ProblemNo112().new Solution();
        a.hasPathSum(root, -5);

    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            return sumFinderDFS(root, targetSum, 0);
        }

        private boolean sumFinderDFS(TreeNode root, int targetSum, int currentSum) {
            if (root == null) return currentSum == targetSum;

            boolean left = sumFinderDFS(root.left, targetSum, currentSum + root.val);
            boolean right = sumFinderDFS(root.right, targetSum, currentSum + root.val);

            if (root.left != null && root.right == null) return left;
            if (root.left == null && root.right != null) return right;
            return left || right;
        }
    }

}

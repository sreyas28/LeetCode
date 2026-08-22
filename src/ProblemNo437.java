public class ProblemNo437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);



        Solution solution = new ProblemNo437().new Solution();
        System.out.println(solution.pathSum(root, 8));

    }

    class Solution {
        private int count;

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;

            this.count = 0;
            explore(root, targetSum, false);
            return count;
        }

        private void explore(TreeNode root, long targetSum, boolean startedTaking) {
            long newTargetSum = targetSum - root.val;
            if (newTargetSum == 0) this.count++;

            // take it
            if (root.left != null) explore(root.left, newTargetSum, true);
            if (root.right != null) explore(root.right, newTargetSum, true);

            if (!startedTaking) {
                // don't take it only possible when nothing is taken
                if (root.left != null) explore(root.left, targetSum, false);
                if (root.right != null) explore(root.right, targetSum, false);
            }
        }

    }

}

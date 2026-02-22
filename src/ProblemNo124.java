public class ProblemNo124 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new  TreeNode(3));

        ProblemNo124.Solution a = new ProblemNo124().new Solution();
        System.out.println(a.maxPathSum(root));
    }

    class Solution {
        private int max;

        public int maxPathSum(TreeNode root) {
            max = Integer.MIN_VALUE;
            DFSBottomsUp(root);
            return max;
        }

        private int DFSBottomsUp(TreeNode root) {
            max = Math.max(max, root.val);

            int globalMax = root.val;
            int localSum = root.val;

            if (root.left != null) {
                int left = DFSBottomsUp(root.left);
                globalMax = Math.max(globalMax, left + root.val);
                localSum += left;
            }
            if (root.right != null) {
                int right = DFSBottomsUp(root.right);
                globalMax = Math.max(globalMax, right + root.val);
                localSum += right;
            }

            max = Math.max(max, localSum);
            max = Math.max(max, globalMax);

            return globalMax;
        }
    }

}

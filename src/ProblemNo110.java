public class ProblemNo110 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return DFS(root) != -1;
        }

        private int DFS(TreeNode root) {

            if(root == null) return 0;

            int leftSide = DFS(root.left);
            if(leftSide == -1) return -1;

            int rightSide = DFS(root.right);
            if(rightSide == -1) return -1;

            if(Math.abs(leftSide - rightSide) > 1) return -1;

            return Math.max(leftSide, rightSide) + 1;
        }
    }

}

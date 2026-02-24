public class ProblemNo1022 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);


        ProblemNo1022.Solution p = new ProblemNo1022().new Solution();
        System.out.println(p.sumRootToLeaf(root));

    }

    class Solution {
        private int sum;
        public int sumRootToLeaf(TreeNode root) {
            sum = 0;
            DFS(0, root);
            return sum;
        }

        private void DFS(int current, TreeNode root) {

            current = (current << 1) + root.val;

            if(root.left == null && root.right == null) {
                sum += current;
                return;
            }

            if(root.left != null) DFS(current, root.left);
            if(root.right != null) DFS(current, root.right);

        }
    }
}

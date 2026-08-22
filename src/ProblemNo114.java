public class ProblemNo114 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.right.right = new TreeNode(6);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        Solution a = new ProblemNo114().new Solution();
        a.flatten(root);
    }

    class Solution {
        public void flatten(TreeNode root) {
            flattener(root);
        }

        private TreeNode flattener(TreeNode root) {
            if (root == null) return null;
            if (root.left == null && root.right == null) return root;

            TreeNode leftLast = flattener(root.left);
            TreeNode right = flattener(root.right);

            TreeNode tempL = root.left, tempR = root.right;
            root.left = null;
            if (tempL != null) {
                root.right = tempL;
                leftLast.right = tempR;
            }

            return right == null ? leftLast : right;
        }
    }

}

public class ProblemNo236 {
    public static void main(String[] args) {

    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            return depth(root, p, q);
        }

        private TreeNode depth(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p || root == q) return root;

            TreeNode left = depth(root.left, p, q);
            TreeNode right = depth(root.right, p, q);

            if (left != null && right != null) return root;
            else if (left != null) return left;
            else return right;
        }

    }

}

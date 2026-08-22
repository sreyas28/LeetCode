public class ProblemNo226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(9);

        Solution a = new ProblemNo226().new Solution();
        System.out.println(a.invertTree(root));

    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            inverter(root);
            return root;
        }

        private void inverter(TreeNode root) {
            if (root == null) return;

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            inverter(root.left);
            inverter(root.right);
        }
    }

}

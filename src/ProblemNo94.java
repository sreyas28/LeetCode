import java.util.*;

public class ProblemNo94 {
    public static void main(String[] args) {

    }

    class Solution {
        private List<Integer> res;

        public List<Integer> inorderTraversal(TreeNode root) {
            this.res = new ArrayList<>();
            if (root != null) inOrder(root);
            return res;
        }

        private void inOrder(TreeNode root) {
            if (root.left != null) inOrder(root.left);
            res.add(root.val);
            if (root.right != null) inOrder(root.right);
        }

        private void preOrder(TreeNode root) {
            res.add(root.val);
            if (root.left != null) preOrder(root.left);
            if (root.right != null) preOrder(root.right);
        }

        private void postOrder(TreeNode root) {
            if (root.left != null) postOrder(root.left);
            if (root.right != null) postOrder(root.right);
            res.add(root.val);
        }

    }

}

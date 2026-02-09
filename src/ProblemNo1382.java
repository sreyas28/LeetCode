import com.sun.source.tree.Tree;

import java.util.*;

public class ProblemNo1382 {
    public static void main(String[] args) {

    }

    class Solution {
        public TreeNode balanceBST(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            inorderTraversal(inorder, root);


            return Balancer(inorder, 0,  inorder.size()-1);
        }

        private void inorderTraversal(List<Integer> inorder, TreeNode root) {
            if(root == null) return;

            inorderTraversal(inorder, root.left);
            inorder.add(root.val);
            inorderTraversal(inorder, root.right);
        }

        private TreeNode Balancer(List<Integer> inorder, int start, int end) {
            if(start > end) return null;

            int mid = start + (end - start) / 2;
            TreeNode left = Balancer(inorder, start, mid-1);
            TreeNode right = Balancer(inorder, mid+1, end);

            return new TreeNode(inorder.get(mid), left, right);
        }

    }

}

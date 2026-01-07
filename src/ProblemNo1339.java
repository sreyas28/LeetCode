import java.util.HashMap;
import java.util.PriorityQueue;

public class ProblemNo1339 {
    public static void main(String[] args) {

    }

    class Solution {
        private long globalMax = Long.MIN_VALUE;

        public int maxProduct(TreeNode root) {
            long totalSum = treeSum(root);
            breaker(root, totalSum);

            int MOD = (int) (1e9 + 7);
            return (int)(globalMax % MOD);
        }

        HashMap<TreeNode, Long> sums = new HashMap<>();
        private long treeSum(TreeNode root) {
            if(sums.containsKey(root)) return sums.get(root);

            if(root ==  null) return 0;
            sums.put(root, ((treeSum(root.left) + treeSum(root.right) + root.val)));
            return sums.get(root);
        }

        private void breaker(TreeNode root, long totalSum) {
            if(root == null) return;
            long leftSum = treeSum(root.left);
            long rightSum = treeSum(root.right);

            long leftProduct = (leftSum * (totalSum - leftSum));
            long rightProduct = (rightSum * (totalSum - rightSum));

            long max = Math.max(leftProduct, rightProduct);

            globalMax = Math.max(globalMax, max);
            breaker(root.left, totalSum);
            breaker(root.right, totalSum);
        }
    }

}

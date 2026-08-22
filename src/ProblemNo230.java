import java.util.PriorityQueue;

public class ProblemNo230 {
    public static void main(String[] args) {

    }

    class Solution {
        private int count, ans;

        public int kthSmallest(TreeNode root, int k) {
            this.count = 0;
            this.ans = 0;

            dfs(root, k);
            return ans;
        }

        private void dfs(TreeNode root, int k) {
            if (root == null) return;

            dfs(root.left, k);
            count++;
            if (count == k) {
                ans = root.val;
                return;
            }
            dfs(root.right, k);
        }
    }

}

import java.util.HashSet;
import java.util.Set;

public class ProblemNo2265 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(8);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(1);
//        root.right.right = new TreeNode(6);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(3);

//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(1);
//        root.right.right.right = new TreeNode(3);

        Solution a = new ProblemNo2265().new Solution();
        System.out.println(a.averageOfSubtree(root));

    }

    class Solution {
        private int count;

        public int averageOfSubtree(TreeNode root) {
            dfs(root);
            return count;
        }

        // It take Over head but still it look cool and also easy to read
        private class Box{
            int sum;
            int count;

            Box(){
                sum = 0;
                count = 0;
            }
            Box(int sum, int count){
                this.sum = sum;
                this.count = count;
            }
        }

        private Box dfs (TreeNode root){
            if (root == null) return new Box();
            Box left = dfs(root.left), right = dfs(root.right);

            int newCount = left.count + right.count + 1;
            int newSum = left.sum + right.sum + root.val;

            int avg = newSum / newCount;

            if (avg == root.val) count++;
            return new Box(newSum, newCount);
        }
    }
}

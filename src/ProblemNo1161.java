import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo1161 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        ProblemNo1161.Solution obj = new ProblemNo1161().new Solution();
        System.out.println(obj.maxLevelSum(root));

    }

    class Solution {
        public int maxLevelSum(TreeNode root) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int max = Integer.MIN_VALUE;
            int level = 0, i = 0;

            while(!queue.isEmpty()){
                Queue<TreeNode> tempQueue = new LinkedList<>();
                int sum = 0;
                i++;

                while(!queue.isEmpty()){
                    TreeNode node = queue.poll();
                    sum += node.val;

                    if(node.left != null) tempQueue.add(node.left);
                    if(node.right != null) tempQueue.add(node.right);
                }

                queue = tempQueue;
                if(sum > max) {
                    max = sum;
                    level = i;
                }
            }


            return level;
        }
    }

}

import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo104 {

    public static void main(String[] args) {

    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                count++;

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }

            }

            return count;
        }
    }


}

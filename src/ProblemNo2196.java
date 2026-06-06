import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProblemNo2196 {
    public static void main(String[] args) {
        Solution solution = new ProblemNo2196().new Solution();
//        printer(solution.createBinaryTree(new int[][] {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}}));
        printer(solution.createBinaryTree(new int[][] {{85,74,0},{38,82,0},{39,70,0},{82,85,0},{74,13,0},{13,39,0}}));
    }

    private static void printer(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printer(root.left);
        printer(root.right);
    }

    class Solution {
        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, TreeNode> map = new HashMap<>();
            Set<Integer> childSet = new HashSet<>();
            TreeNode parentNode = null;

            for(int[] description: descriptions) {
                int parent = description[0];
                int child = description[1];
                boolean leftOrRight = description[2] == 1; // true ->> left: false ->> right

                map.computeIfAbsent(child, k -> new TreeNode(k));
                map.computeIfAbsent(parent, k -> new TreeNode(k));

                if (leftOrRight) map.get(parent).left = map.get(child);
                else map.get(parent).right = map.get(child);

                childSet.add(child);
            }

            for(int[] description: descriptions) {
                int parent = description[0];

                if (!childSet.contains(parent)) parentNode = map.get(parent);
            }

            return parentNode;
        }
    }

}

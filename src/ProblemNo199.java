import java.util.ArrayList;
import java.util.List;

public class ProblemNo199 {
    public static void main(String[] args) {

    }

    class Solution {

        List<Integer> value;

        public List<Integer> rightSideView(TreeNode root) {
            value = new ArrayList<>();
            DFS(0, root);
            return value;
        }

        private void DFS(int level, TreeNode node){
            if(node == null) return;

            if ((value.size()-1) < level)  value.add(node.val);

            DFS(level+1, node.right);
            DFS(level+1, node.left);
        }
    }

}

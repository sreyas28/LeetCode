public class ProblemNo108 {
    public static void main(String[] args) {

    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return maker(0, nums.length - 1, nums);
        }

        private TreeNode maker(int start, int end, int[] nums) {
            if (start > end) return null;

            int mid = start + (end - start) / 2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = maker(start, mid - 1, nums);
            root.right = maker(mid + 1, end, nums);

            return root;
        }
    }

}

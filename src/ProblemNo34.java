public class ProblemNo34 {
    public static void main(String[] args) {

        Solution a = new ProblemNo34().new Solution();
        System.out.println(a.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));

    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            final int n = nums.length;

            int left = 0, right = nums.length - 1;
            int r = -1, l = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) right = mid - 1;
                else {
                    left = mid + 1;
                    r = mid;
                }
            }
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                    l = mid;
                } else left = mid + 1;
            }

            if (l >= 0 && l < n && r >= 0 && r < n && nums[l] == target && nums[r] == target)return new int[]{l, r};

            return new int[]{-1, -1};
        }
    }

}

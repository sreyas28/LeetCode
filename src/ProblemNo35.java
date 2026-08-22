public class ProblemNo35 {
    public static void main(String[] args) {

    }

    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums[nums.length-1] < target) return nums.length;

            int left = 0, right = nums.length-1;
            int res = -1;

            while (left <= right) {
                int mid = left + (right - left)/2;
                if (nums[mid] >=  target) {
                    right = mid - 1;
                    res = mid;
                }
                else left = mid + 1;
            }

            return res;
        }
    }

}

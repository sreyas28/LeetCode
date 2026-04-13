public class ProblemNo1848 {
    public static void main(String[] args) {

    }

    class Solution {
        public int getMinDistance(int[] nums, int target, int start) {
            int dif = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) dif = Math.min(dif, Math.abs(i - start));
            }

            return dif;
        }
    }

}

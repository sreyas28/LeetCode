import java.util.*;

public class ProblemNo3507 {
    public static void main(String[] args) {


    }

    class Solution {
        public int minimumPairRemoval(int[] nums) {
            int count = 0;
            while (!increasing(nums)) {
                count++;
                nums = pairs(nums);
            }

            return count;
        }

        private int[] pairs(int[] nums) {
            int[] res = new int[nums.length - 1];

            int min = Integer.MAX_VALUE, id = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < min) {
                    min = sum;
                    id = i;
                }
            }

            for (int i = 0; i < nums.length-1; i++) {
                if (i < id) res[i] = nums[i];
                else if (i == id) res[i] = min;
                else res[i] = nums[i+1];
            }

            return res;
        }

        private boolean increasing(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] < nums[i]) return false;
            }
            return true;
        }

    }

}

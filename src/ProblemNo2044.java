import java.util.ArrayList;
import java.util.List;

public class ProblemNo2044 {
    public static void main(String[] args) {

        ProblemNo2044.Solution a = new ProblemNo2044().new Solution();
        System.out.println(a.countMaxOrSubsets(new int[] {3,2,1,5}));

    }

    class Solution {
        private int count = 0;
        public int countMaxOrSubsets(int[] nums) {
            int max = 0;
            for(int i: nums) max |= i;

            generateSubset(0, 0, max, nums);

            return count;
        }

        private void generateSubset(int index, int current, int max, int[] nums){
            if(index == nums.length) {
                if (current == max) count++;
                return;
            }

            generateSubset(index + 1, current, max, nums);
            int temp = current | nums[index];
            generateSubset(index + 1, temp, max, nums);
        }


    }

}

import java.util.Arrays;

public class ProblemNo80 {
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,1,2,3,3};
        ProblemNo80.Solution a = new ProblemNo80().new Solution();

        System.out.println(a.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int previous = -1, occurred = 0;
            int last = 0;

            for(int index = 0; index < nums.length; index++){
                int current = nums[index];

                if(current == previous) occurred++;

                else{
                    previous = current;
                    occurred = 1;
                }

                if(occurred <= 2){
                    nums[last] = current;
                    last++;
                }
            }

            return last;
        }
    }

}

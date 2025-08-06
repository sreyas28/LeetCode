import java.util.Arrays;

public class ProblemNo2294 {
    public static void main(String[] args) {
        ProblemNo2294.Solution a = new ProblemNo2294().new Solution();
        System.out.println(a.partitionArray(new int[]{3,6,1,2,5}, 2));

    }

    class Solution {
        public int partitionArray(int[] nums, int k) {
            Arrays.sort(nums);
            int result = 1, rec = nums[0];
            for(int i = 0; i < nums.length; i++){
                if(nums[i] - rec > k){
                    result++;
                    rec = nums[i];
                }
            }

            return result;
        }
    }

}

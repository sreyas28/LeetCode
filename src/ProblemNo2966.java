import java.util.Arrays;

public class ProblemNo2966 {
    public static void main(String[] args) {

        ProblemNo2966.Solution a = new ProblemNo2966().new Solution();

        System.out.println(Arrays.deepToString(a.divideArray(new int[]{2,4,2,2,5,2}, 2)));

    }

    class Solution {
        public int[][] divideArray(int[] nums, int k) {
            int n = nums.length;
            int[][] result = new int[n/3][3];

            Arrays.sort(nums);

            for(int i=1, j=0; i < n; i += 3){
                if(nums[i+1] - nums[i-1] <= k){
                    result[j][0] = nums[i-1];
                    result[j][1] = nums[i];
                    result[j][2] = nums[i+1];
                    j++;
                }

                else return new int[][]{};
            }

            return result;
        }
    }
}

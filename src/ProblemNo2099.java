import java.util.Arrays;

public class ProblemNo2099 {
    public static void main(String[] args) {

        ProblemNo2099.Solution a = new ProblemNo2099().new Solution();
        System.out.println(Arrays.toString(a.maxSubsequence(new int[]{2, 1, 3, 3}, 2)));

    }

    class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            int[][] map = new int[nums.length][2];

            for(int i = 0; i< nums.length; i++){
                map[i][0] = nums[i];
                map[i][1] = i;
            }
            Arrays.sort(map, (x, y) -> x[0] - y[0]);

            int[] result = new int[k];
            for(int i = k-1, j = nums.length - 1; i >= 0 ; i--) result[i] = map[j--][1];

            Arrays.sort(result);

            for(int i = 0; i < result.length; i++) result[i] = nums[result[i]];
            return result;
        }
    }

}

import java.util.ArrayList;

public class ProblemNo2348 {

    public static void main(String[] args) {

        ProblemNo2348.Solution a = new ProblemNo2348().new Solution();
        System.out.println(a.zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
    }

    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            ArrayList<Integer> zeroes = new ArrayList<>();

            int count_temp = 0;
            for(int num: nums){
                if (num == 0) count_temp++;
                else {
                    zeroes.add(count_temp);
                    count_temp = 0;
                }
            }
            zeroes.add(count_temp);

            long result = 0;

            for(int val: zeroes){
                result += (long) val *(val+1)/2;
            }

            return result;
        }
    }

}

import java.util.Arrays;

public class ProblemNo2154 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findFinalValue(int[] nums, int original) {
            Arrays.sort(nums);
            for(int i : nums){
                if(i == original) original *= 2;
            }
            return original;
        }
    }

    class Solution_ {
        public int findFinalValue(int[] nums, int original) {
            boolean[] dp = new boolean[1001];
            for(int i: nums) dp[i]=true;
            while(original < 1001 && dp[original]) original <<= 1;
            return original;
        }
    }

}

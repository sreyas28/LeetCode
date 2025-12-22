import java.util.Arrays;

public class ProblemNo960 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minDeletionSize(String[] strs) {
            int len = strs[0].length();
            int[] dp = new int[len];
            Arrays.fill(dp, 1);

            for(int i=1; i < len; i++){
                for(int j=0; j<i; j++){
                    boolean flag = true;
                    for(String s: strs){
                        if (s.charAt(j) > s.charAt(i)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            int max = 0;
            for(int i: dp) max = Math.max(max,i);

            return len - max;
        }
    }

}

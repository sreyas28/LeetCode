import javax.swing.*;
import java.util.Arrays;

public class ProblemNo3381 {
    public static void main(String[] args) {

    }

    class Solution {
        public long maxSubarraySum(int[] nums, int k) {
            int n = nums.length;
            long[] prefixSum = new long[n+1];
            for (int i = 0; i < nums.length; i++) prefixSum[i+1] = prefixSum[i] + nums[i];

            long Max = Long.MIN_VALUE;;
            long[] best = new long[k];
            Arrays.fill(best, Long.MAX_VALUE);

            for(int i = 0; i <= n; i++){
                int mod = i % k;
                if(best[mod] != Long.MAX_VALUE) Max = Math.max(Max, prefixSum[i] - best[mod]);
                best[mod] = Math.min(best[mod], prefixSum[i]);
            }

            return Max;
        }
    }
}

import java.util.*;

public class ProblemNo3578 {
    public static void main(String[] args) {

        ProblemNo3578.Solution a = new ProblemNo3578().new Solution();
        System.out.println(a.countPartitions(new int[]{9,4,1,3,7}, 4));

    }

    class Solution {

        public int countPartitions(int[] nums, int k) {
            int n = nums.length;
            long mod = (long) 1e9 + 7;
            long[] dp = new long[n + 1];
            long[] prefix = new long[n + 1];
            TreeMap<Integer, Integer> cnt = new TreeMap<>();

            dp[0] = 1;
            prefix[0] = 1;
            for (int i = 0, j = 0; i < n; i++) {
                cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
                // adjust window
                while (j <= i && cnt.lastKey() - cnt.firstKey() > k) {
                    cnt.put(nums[j], cnt.get(nums[j]) - 1);
                    if (cnt.get(nums[j]) == 0) {
                        cnt.remove(nums[j]);
                    }
                    j++;
                }

                dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + mod) % mod;
                prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
            }

            return (int) dp[n];
        }
    }

}

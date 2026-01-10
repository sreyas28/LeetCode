import java.util.Arrays;

public class ProblemNo712 {
    public static void main(String[] args) {
        ProblemNo712.Solution p = new ProblemNo712().new Solution();
        System.out.println(p.minimumDeleteSum("delete", "leet"));
    }

    class Solution {
        public int minimumDeleteSum(String s1, String s2) {

            long totalSum = 0;

            for (int i = 0; i < s1.length(); i++) totalSum += s1.charAt(i);
            for (int i = 0; i < s2.length(); i++) totalSum += s2.charAt(i);

            int[][] dp = new int[s1.length() + 1][s2.length() + 1];

            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            return (int)totalSum - 2*dp[s1.length()][s2.length()];
        }
    }

}

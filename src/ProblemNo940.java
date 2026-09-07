import java.util.HashSet;
import java.util.Set;

public class ProblemNo940 {
    public static void main(String[] args) {
        Solution a = new ProblemNo940().new Solution();
        System.out.println(a.distinctSubseqII("abc"));
        System.out.println(a.distinctSubseqII("aba"));
        System.out.println(a.distinctSubseqII("aaa"));
    }

    class Solution {
        public int distinctSubseqII(String s) {
            final int MOD = 1_000_000_007;
            final int N = s.length();

            Integer[] lastIndex = new Integer[26];
            int[] dp = new int[N + 1];
            dp[0] = 1;

            for (int i = 1; i <= N; i++) {
                int cur = s.charAt(i - 1) - 'a';

                dp[i] = (dp[i - 1] * 2) % MOD - (lastIndex[cur] != null ? dp[lastIndex[cur] - 1] : 0);
                dp[i] %= MOD;
                lastIndex[cur] = i;
            }

            dp[N]--;
            if (dp[N] < 0) dp[N] += MOD;
            return dp[N];
        }
    }

    // it will give MLE and TLE
    class Solution_ {
        Set<String> unique; // it can store max to 2^32 and here count can easily go more than that
        // max it can take a string of max 32 distinct character but Alphabets are only 26

        public int distinctSubseqII(String s) {
            unique = new HashSet<>();
            solve(s, "", 0);

            return unique.size() - 1;
        }

        private void solve(String s, String curr, int i) {
            if (i == s.length()) {
                unique.add(curr);
                return;
            }

            // taking
            solve(s, curr + s.charAt(i), i + 1);

            // not taking
            solve(s, curr, i + 1);
        }
    }

}

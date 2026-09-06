import javax.security.auth.login.CredentialException;

public class ProblemNo115 {
    public static void main(String[] args) {

        Solution solution = new ProblemNo115().new Solution();
        System.out.println(solution.numDistinct("rabbbit", "rabbit"));
        System.out.println(solution.numDistinct("babgbag", "bag"));

    }

    class Solution {
        private int count;

        public int numDistinct(String s, String t) {
            this.count = 0;

//            DFS(0, 0, s, t, "");
//            return count;

            return recursion(0, 0, s, t, new Integer[s.length() + 1][t.length() + 1]);
        }

        // Top-Down Approach Takes time 2^N, exponential, will give TLE
        private void DFS(int i, int j, String s, String t, String soFar) {
            if (i == s.length() || j == t.length()) {
                if (soFar.equals(t)) count++;
                return;
            }
            // not matched OR not Taking
            DFS(i + 1, j, s, t, soFar);

            // matched
            if (s.charAt(i) == t.charAt(j)) {
                DFS(i + 1, j + 1, s, t, soFar + t.charAt(j));
            }
        }

        // recursion with memo O(N*M)
        private int recursion(int i, int j, String s, String t, Integer[][] memo) {
            if (j == t.length()) return 1;
            else if (i == s.length()) return 0;

            if (memo[i][j] != null) return memo[i][j];

            if (s.charAt(i) == t.charAt(j))
                memo[i][j] = recursion(i + 1, j + 1, s, t, memo) + recursion(i + 1, j, s, t, memo);
            else memo[i][j] = recursion(i + 1, j, s, t, memo);

            return memo[i][j];
        }

    }

}

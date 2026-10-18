import java.util.ArrayList;
import java.util.List;

public class ProblemNo1569 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1569().new Solution();
//        System.out.println(a.numOfWays(new int[]{2,1,3}));
        System.out.println(a.numOfWays(new int[]{3, 4, 5, 1, 2}));


    }

    class Solution {

        private final int MOD = 1000000007;
        private long[][] combinationTable;

        public int numOfWays(int[] nums) {
            final int N = nums.length;

            this.combinationTable = new long[N][N];
            for (int i = 0; i < N; ++i) {
                combinationTable[i][0] = combinationTable[i][i] = 1;
            }
            for (int i = 2; i < N; i++) {
                for (int j = 1; j < i; j++) {
                    combinationTable[i][j] = (combinationTable[i - 1][j - 1] + combinationTable[i - 1][j]) % MOD;
                }
            }

            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);

            return (int) ((DFS(list) - 1) % MOD);
        }

        private long DFS(List<Integer> list) {
            final int N = list.size();
            if (N < 3) return 1;

            int root = list.getFirst();
            List<Integer> leftSide = new ArrayList<>();
            List<Integer> rightSide = new ArrayList<>();
            for (int i = 1; i < N; i++) {
                int cur = list.get(i);

                if (cur > root) rightSide.add(cur);
                else leftSide.add(cur);
            }

            long left = ((DFS(leftSide)) % MOD);
            long right = ((DFS(rightSide)) % MOD);

            return ((this.combinationTable[N-1][leftSide.size()] % MOD) * ((left * right) % MOD) ) % MOD;
        }
    }

    // Combination is taking time.
    class Solution_ {
        private final int MOD = 1000000007;

        public int numOfWays(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);

            return (int) ((DFS(list) - 1) % MOD);
        }

        private long DFS(List<Integer> list) {
            final int N = list.size();
            if (N < 3) return 1;

            int root = list.getFirst();
            List<Integer> leftSide = new ArrayList<>();
            List<Integer> rightSide = new ArrayList<>();
            for (int i = 1; i < N; i++) {
                int cur = list.get(i);

                if (cur > root) rightSide.add(cur);
                else leftSide.add(cur);
            }

            long left = ((DFS(leftSide)) % MOD);
            long right = ((DFS(rightSide)) % MOD);

            return ((nCr(N - 1, rightSide.size()) % MOD) * ((left * right) % MOD) ) % MOD;
        }

        private long nCr(int n, int r) {
            if (r == 0 || n == r) return 1;
            return (nCr(n - 1, r - 1) + nCr(n - 1, r)) % MOD;
        }

    }

}

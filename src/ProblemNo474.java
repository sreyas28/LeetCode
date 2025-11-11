import java.util.Arrays;
import java.util.HashMap;

public class ProblemNo474 {
    public static void main(String[] args) {
        ProblemNo474.Solution a = new ProblemNo474().new Solution();
        System.out.println(a.findMaxForm(new String[]{"10","0","1"}, 1, 1));
    }

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {

            int[][] DP= new int[strs.length][2];

            for(int i=0; i<strs.length; i++){
                for(char c: strs[i].toCharArray()){
                    DP[i][c - 48] += 1;
                }
            }

            Integer[][][] memo = new Integer[strs.length][m+1][n+1];
            return noAndTake(0, DP, m, n, 0, 0, memo);
        }

        private int noAndTake(int i, int[][] DP, int m, int n, int currentZeros, int currentOnes, Integer[][][] memo){
            if(i == DP.length) return 0;
            if(memo[i][currentZeros][currentOnes] != null) return memo[i][currentZeros][currentOnes];

            // not selecting
            int skip = noAndTake(i+1, DP, m, n, currentZeros, currentOnes, memo);

            int zeroes = DP[i][0] + currentZeros;
            int ones = DP[i][1] + currentOnes;

            int take = 0;
            if(zeroes <= m && ones <= n)
                take = 1 + noAndTake(i+1, DP, m, n, zeroes, ones, memo);

            memo[i][currentZeros][currentOnes] = Math.max(skip,take);

            return memo[i][currentZeros][currentOnes];
        }

    }

}

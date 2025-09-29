public class ProblemNo1039 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minScoreTriangulation(int[] values) {
            Integer[][] DP = new Integer[values.length][values.length];
            return solve(values, 0, values.length-1, DP);
        }

        private int solve(int[] values, int i, int j, Integer[][] DP){
            if( (j-i+1) < 3 ) return 0;

            if(DP[i][j] != null) return DP[i][j];

            int result = Integer.MAX_VALUE;

            for(int k = i+1; k<j; k++){
                int val = values[i] * values[j] * values[k];
                result = Math.min(result, solve(values, i, k, DP) + val + solve(values, k, j, DP) );
            }

            DP[i][j] = result;

            return DP[i][j];
        }
    }

}

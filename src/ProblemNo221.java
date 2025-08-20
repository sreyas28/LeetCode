import java.util.Arrays;

public class ProblemNo221 {
    public static void main(String[] args) {

        ProblemNo221.Solution a= new ProblemNo221().new Solution();
        System.out.println(a.maximalSquare(new char[][]{{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}}));
    }

    class Solution {
        public int maximalSquare(char[][] matrix) {
            int[][] DP = new int[matrix.length][matrix[0].length];
            int max = 0;

            for(int n = 0; n < matrix.length; n++){
                for (int m = 0; m < matrix[0].length; m++){
                    if (n == 0 || m == 0) DP[n][m] = matrix[n][m] - 48;
                    else if (matrix[n][m] == '0') DP[n][m] = 0;
                    else{
                        int up = DP[n-1][m];
                        int side = DP[n][m-1];
                        int diagonal = DP[n-1][m-1];
                        DP[n][m] = Math.min(Math.min(up,side),diagonal) + 1;
                    }
                    max = Math.max(DP[n][m], max);
                }
            }

            for(int[] a: DP){
                System.out.println(Arrays.toString(a));
            }

            return max*max;
        }
    }

}

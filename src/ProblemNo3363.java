import java.util.Arrays;

public class ProblemNo3363 {

    public static void main(String[] args) {

        ProblemNo3363.Solution a = new ProblemNo3363().new Solution();
        System.out.println(a.maxCollectedFruits(new int[][]
                        {       {4,2,1,15,20,6,1,3,11},
                                {1,13,19,18,15,13,6,14,13},
                                {20,12,10,8,7,12,20,5,17},
                                {18,9,15,9,16,6,13,1,18},
                                {12,19,12,7,1,15,16,13,9},
                                {17,19,15,17,16,11,14,4,15},
                                {10,16,7,4,8,19,13,2,10},
                                {1,2,14,6,0,13,11,5,16},
                                {16,17,12,8,2,12,19,4,7}}
                ));

    }

    class Solution {
        public int maxCollectedFruits(int[][] fruits) {
            int sum = 0, n = fruits.length;

            int[][] DP = new int[n][n];
            DP[n-1][0] = fruits[n-1][0];

            // top left corner man
            for(int i = 0; i < n; i++) sum += fruits[i][i];

            //bottom left corner man
            for(int col = 1; col < n-1; col++){
                for(int row = n-1; row >= (n-1-col); row-- ){
                    // {row}{col-1} && row+i >= n-col && row+i < n
                    for(int i = -1; i <= 1; i++ ){
                        int val = row + i;
                        if(val >= n-col && val < n){
                            DP[row][col] = Math.max(DP[row][col], fruits[row][col] + DP[val][col-1]);
                        }
                    }
                }
            }
            sum += DP[n-1][n-2];

            //top right corner man
            DP = new int[n][n];
            DP[0][n-1] = fruits[0][n-1];

            for(int row = 1; row < n-1; row++){
                for(int col = n-1; col >= n-1-row; col--){
                    for(int i=-1; i<=1; i++){
                        int val = col + i;
                        if(val >= n-row && val < n){
                            DP[row][col] = Math.max(DP[row][col], fruits[row][col] + DP[row-1][val]);
                        }
                    }
                }
            }
            sum += DP[n-2][n-1];


            return sum;
        }
    }

}

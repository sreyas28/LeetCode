import java.util.Arrays;

public class ProblemNo2536 {
    public static void main(String[] args) {

        ProblemNo2536.Solution a = new ProblemNo2536().new Solution();
        System.out.println(Arrays.deepToString(a.rangeAddQueries(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}})));

    }

    class Solution {
        public int[][] rangeAddQueries(int n, int[][] queries) {

            int[][] grid = new int[n][n];

            for (int[] query: queries){
                for(int i = query[0] ; i <= query[2]; i++ ) grid[i][query[1]] += 1;

                if(query[3] + 1 < n){
                    for(int i = query[2]; i >= query[0]; i--){
                        grid[i][query[3] + 1] -= 1;
                    }
                }
            }

            for(int i = 0; i<n; i++){
                int sum = 0;
                for(int j=0; j<n; j++){
                    sum += grid[i][j];
                    grid[i][j] = sum;
                }
            }

            return grid;
        }
    }
}

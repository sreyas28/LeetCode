import java.util.Arrays;

public class ProblemNo59 {
    public static void main(String[] args) {
        ProblemNo59.Solution p = new ProblemNo59().new Solution();
        System.out.println(Arrays.deepToString(p.generateMatrix(5)));
    }

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];

            int top = 0, bottom = n-1, left = 0, right = n-1;
            int val = 1;
            while(top <= bottom && left <= right){
                for(int i=left; i<=right; i++) matrix[top][i] = val++;
                top++;

                for(int i=top; i<=bottom; i++) matrix[i][right] = val++;
                right--;

                for(int i=right; i>=left; i--) matrix[bottom][i] = val++;
                bottom--;

                for(int i=bottom; i>=top; i--) matrix[i][left] = val++;
                left++;
            }

            return matrix;
        }
    }

}

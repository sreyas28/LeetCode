import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemNo118 {
    public static void main(String[] args) {

        ProblemNo118.Solution a = new ProblemNo118().new Solution();

        System.out.println(a.generate(6));
    }

    class Solution {
        public List<List<Integer>> generate(int numRows) {

            int[][] pascal = new int[numRows][numRows];
            Arrays.fill(pascal[0], 1);

            for(int i=1; i<numRows; i++){
                for(int j=0; j <= (numRows - i - 1); j++){
                    if(j == 0) pascal[i][j] = 1;
                    else pascal[i][j] = pascal[i][j-1] + pascal[i-1][j];
                }
            }

            List<List<Integer>> result = new ArrayList<>();
            for(int i=1; i<=numRows; i++){
                List<Integer> temp = new ArrayList<>();
                int col = 0, row = i-1;
                while (row >= 0){
                    temp.add(pascal[row--][col++]);
                }
                result.add(temp);
            }

            return result;
        }
    }

}

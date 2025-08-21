import java.util.Arrays;

public class ProblemNo1504 {
    public static void main(String[] args) {

        ProblemNo1504.Solution a = new ProblemNo1504().new Solution();
        System.out.println(a.numSubmat(new int[][]{{0,1,1,0},{0,1,1,1},{1,1,1,0}}));

    }

    class Solution {
        public int numSubmat(int[][] mat) {

            int result = 0;

            for(int start = 0; start < mat.length; start++){
                for(int end = start; end < mat.length; end++){

                    int[] andArray = new int[mat[0].length];
                    Arrays.fill(andArray, 1);

                    for(int col = 0; col < andArray.length; col++){
                        for(int row = start; row <= end ; row++){
                            andArray[col] &= mat[row][col];
                        }
                    }

                    int x = 0;
                    for(int i: andArray){
                        if(i == 0) x = 0;
                        else{
                            x++;
                            result += x;
                        }
                    }

                }

            }

            return result;
        }
    }

}

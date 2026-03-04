import java.util.Arrays;

public class ProblemNo1582 {
    public static void main(String[] args) {
        ProblemNo1582.Solution p = new ProblemNo1582().new Solution();
        System.out.println(p.numSpecial(new int[][]{ {0,0,1,0},{0,0,0,0},{0,0,0,0},{0,1,0,0} }));
    }

    class Solution {
        public int numSpecial(int[][] mat) {

            int[] rows = new int[mat.length];
            int[] cols = new int[mat[0].length];

            for(int row = 0; row < mat.length; row++){
                for(int col = 0; col < mat[0].length; col++){
                    if (mat[row][col] == 1){
                        rows[row]++;
                        cols[col]++;
                    }
                }
            }

//            System.out.println(Arrays.toString(rows));
//            System.out.println(Arrays.toString(cols));

            int count = 0;
            for(int row =  0; row < mat.length; row++){
                for(int col = 0; col < mat[0].length; col++){
                    if (mat[row][col] == 1 && rows[row] == 1  && cols[col] == 1) count++;
                }
            }

            return count;
        }
    }

}

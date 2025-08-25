import java.util.Arrays;

public class ProblemNo498 {

    public static void main(String[] args) {

        ProblemNo498.Solution a = new ProblemNo498().new Solution();
        System.out.println(
                Arrays.toString(a.findDiagonalOrder(new int[][]{
                        {1,2},{3,4}
                }))
        );

    }

    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int[] result = new int[mat.length * mat[0].length];

            int x = 0, y = 0, j = 0;

            result[j++] = mat[x][y];

            while(true){
                if( y+1 < mat[0].length) y++;
                else if(x+1 < mat.length) x++;
                else break;

                while(x+1 < mat.length && y-1 >= 0 ){
                    result[j++] = mat[x++][y--];
                }
                result[j++] = mat[x][y];

                if( x+1 < mat.length) x++;
                else if(y+1 < mat[0].length) y++;
                else break;

                while(x-1 >= 0 && y+1 < mat[0].length ){
                    result[j++] = mat[x--][y++];
                }
                result[j++] = mat[x][y];
            }

            return result;
        }
    }

}

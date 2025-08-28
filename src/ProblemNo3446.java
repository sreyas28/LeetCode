import java.util.ArrayList;
import java.util.Arrays;

public class ProblemNo3446 {
    public static void main(String[] args) {

        ProblemNo3446.Solution a = new ProblemNo3446().new Solution();
        System.out.println(Arrays.deepToString(a.sortMatrix(new int[][]{
                {1, 7, 3}, {9, 8, 2}, {4, 5, 6}
        })));

    }

    class Solution {
        public int[][] sortMatrix(int[][] grid) {
            //principle Diagonal
            ArrayList<Integer> diagonal = new ArrayList<>();
            for(int i=0, j=0; i<grid.length && j<grid.length; j++, i++){
                diagonal.add(grid[i][j]);
            }
            diagonal.sort((a,b) -> b-a);

            for(int i=0, j=0, k=0; i<grid.length; j++, i++, k++){
                grid[i][j] = diagonal.get(k);
            }

            // Rest Diagonals
            for(int Dag = 1; Dag<grid.length; Dag++){
                DiagonalSort(grid, Dag, 0, true);
                DiagonalSort(grid, 0, Dag, false);
            }
            return grid;
        }

        private void DiagonalSort(int[][] grid, int row , int col, boolean isDown){
            ArrayList<Integer> diagonal = new ArrayList<>();
            for(int i=row, j=col; i<grid.length && j<grid.length; j++, i++){
                diagonal.add(grid[i][j]);
            }
            if (isDown) diagonal.sort((a, b) -> b - a);
            else diagonal.sort((a, b) -> a - b);

            for(int i=row, j=col, k=0; i<grid.length && j<grid.length; j++, i++, k++){
                grid[i][j] = diagonal.get(k);
            }
        }
    }

}

public class ProblemNo840 {
    public static void main(String[] args) {

    }

    class Solution {

        private int[][] grid;

        public int numMagicSquaresInside(int[][] grid) {
            int ans = 0;
            int rows = grid.length;
            int cols = grid[0].length;

            this.grid = grid;

            for(int row = 0; row < rows; row++){
                for(int col = 0; col < cols; col++){
                    if(isMagicMat(row, col)) ans++;
                }
            }

            return ans;
        }

        private boolean isMagicMat(int row, int col){
            boolean[] visited = new boolean[10];

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    int num =  grid[row+i][col+j];

                    if(num < 1 || num > 9) return false;
                    else if(visited[num]) return false;
                    visited[num] = true;
                }
            }

            int[] sumRow = new int[3];
            int[] sumCol = new int[3];

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    int num = grid[row+i][col+j];
                    sumRow[i] += num;
                    sumCol[j] += num;
                }
            }

            int[] diagonal = new int[2];
            diagonal[0] = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
            diagonal[1] = grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col];

            int val = sumRow[0];
            for(int i=0; i<3; i++) if(val != sumRow[i]) return false;
            for(int i=0; i<3; i++) if(val != sumCol[i]) return false;
            for(int i=0; i<2; i++) if(val != diagonal[i]) return false;

            return true;
        }
    }

}

import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo1970 {
    public static void main(String[] args) {
        ProblemNo1970.Solution p = new ProblemNo1970().new Solution();
//        System.out.println(p.latestDayToCross(2,2, new int[][] {{1,1},{2,1},{1,2},{2,2}}));
        System.out.println(p.latestDayToCross(3,3, new int[][] {{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}}));
    }

    class Solution {
        public int latestDayToCross(int row, int col, int[][] cells) {
            int left = 0,  right = cells.length - 1;
            while(left < right) {
                int mid =  left + (right - left)/2;
                int[][] mat = new  int[row][col];

                // mat fill
                for(int i=0; i<=mid; i++){
                    int r = cells[i][0]-1;
                    int c = cells[i][1]-1;
                    mat[r][c] = 1;
                }

                if(way(mat)) left = mid + 1;
                else right = mid;
            }

            return left;
        }

        private boolean way(int[][] grid){
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[grid.length][grid[0].length];

            // initial start row
            for(int col=0; col<grid[0].length; col++){
                if(grid[0][col] == 0) {
                    queue.offer(new int[]{0,col});
                    visited[0][col] = true;
                }
            }

            int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
            while(!queue.isEmpty()){
                int[] cor = queue.poll();

                int  row = cor[0];
                int col = cor[1];

                if(row == grid.length-1) return true;

                for(int[] dir: direction){
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    if(nextCol >= 0 && nextRow < grid.length && nextRow >= 0 && nextCol < grid[0].length
                            && !visited[nextRow][nextCol] &&  grid[nextRow][nextCol] == 0) {
                        queue.offer(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }

            return false;
        }
    }

}

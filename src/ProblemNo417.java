import java.sql.ClientInfoStatus;
import java.util.*;

public class ProblemNo417 {
    public static void main(String[] args) {

        ProblemNo417.Solution a = new ProblemNo417().new Solution();
        System.out.println(a.pacificAtlantic(new int[][]{
                {1,2,3},{8,9,4},{7,6,5}
        }));

    }

    class Solution {
        
        private final int[][] direction = {{0,-1}, {-1,0}, {0,1}, {1,0}};
        
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> result = new ArrayList<>();

            int rows = heights.length;
            int cols = heights[0].length;
            boolean[][] pacific = new boolean[rows][cols];
            boolean[][] atlantic = new boolean[rows][cols];

            for(int i=0; i<rows; i++){
                DFS(heights, i, 0, pacific, heights[i][0]);
                DFS(heights, i, cols-1, atlantic, heights[i][cols-1]);
            }

            for(int i=0; i<cols; i++){
                DFS(heights, 0, i, pacific, heights[0][i]);
                DFS(heights, rows-1, i, atlantic, heights[rows-1][i]);
            }

            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i,j));
                }
            }

            return result;
        }

        private void DFS(int[][] height, int i, int j, boolean[][] ocean, int prevHeight){
            int rows = ocean.length;
            int cols = ocean[0].length;

            if(i < 0 || j < 0 || i >= rows || j >= cols || ocean[i][j] || prevHeight > height[i][j]) return;

            ocean[i][j] = true;
            
            for(int[] dir: direction) {
                DFS(height, dir[0] + i, dir[1] + j, ocean, height[i][j]);
            }
        }
    }

    // wrong and Old Solution
//    class Solution {
//        private boolean[][][] visit_Pacific;
//        private boolean[][][] visit_Atlantic;
//
//        public List<List<Integer>> pacificAtlantic(int[][] heights) {
//
//            int rows = heights.length;
//            int cols = heights[0].length;
//
//            visit_Pacific = new boolean[rows][cols][2];
//            visit_Atlantic = new boolean[rows][cols][2];
//
//            List<List<Integer>> result = new ArrayList<>();
//
//            for(int i=0; i<rows; i++){
//                for(int j=0; j<cols; j++){
//                    if(reachedPacific( i, j, rows, cols, heights) && reachedAtlantic( i, j, rows, cols, heights)){
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(i);
//                        temp.add(j);
//                        result.add(temp);
//                    }
//                }
//            }
//
//            return result;
//        }
//
//        private boolean reachedPacific(int i, int j, int rows, int cols, int[][] heights){
//            if(visit_Pacific[i][j][0]) return visit_Pacific[i][j][1];
//            visit_Pacific[i][j][0] = true;
//
//            int top_i = i-1;
//            int side_j = j-1;
//            int currVal = heights[i][j];
//
//            if(top_i < 0 || side_j < 0) visit_Pacific[i][j][1] = true;
//            else if(top_i >= 0 && currVal >= heights[top_i][j] && reachedPacific(top_i, j, rows, cols, heights)) visit_Pacific[i][j][1] = true;
//            else if(side_j >= 0 && currVal >= heights[i][side_j] && reachedPacific(i, side_j, rows, cols, heights)) visit_Pacific[i][j][1] = true;
//
//            return visit_Pacific[i][j][1];
//        }
//
//        private boolean reachedAtlantic(int i, int j, int rows, int cols, int[][] heights){
//            if(visit_Atlantic[i][j][0]) return visit_Atlantic[i][j][1];
//            visit_Atlantic[i][j][0] = true;
//
//            int bottom_i = i+1;
//            int side_j = j+1;
//            int currVal = heights[i][j];
//
//            if(bottom_i == rows || side_j == cols) visit_Atlantic[i][j][1] = true;
//            else if(bottom_i < rows && currVal >= heights[bottom_i][j] && reachedAtlantic(bottom_i, j, rows, cols, heights)) visit_Atlantic[i][j][1] = true;
//            else if(side_j < cols && currVal >= heights[i][side_j] && reachedAtlantic(i, side_j, rows, cols, heights)) visit_Atlantic[i][j][1] = true;
//
//            return visit_Atlantic[i][j][1];
//        }
//    }

}

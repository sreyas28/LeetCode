public class ProblemNo3197 {
    public static void main(String[] args) {

        ProblemNo3197.Solution a= new ProblemNo3197().new Solution();
        System.out.println(
                a.minimumSum(new int[][]  {
                        {1,0,1},{1,1,1}
                })
        );

    }

    class Solution {
        public int minimumSum(int[][] grid) {
            int Result = Integer.MAX_VALUE;

            // Case 1: -|-

            for(int RowSplit = 1; RowSplit < grid.length; RowSplit++){
                int RowUpperArea = minimumArea(grid, 0, RowSplit, 0, grid[0].length );
                int RowLowerArea = minimumArea(grid, RowSplit, grid.length, 0, grid[0].length );

                for (int ColSpilt = 1; ColSpilt < grid[0].length; ColSpilt++){
                    int ColRightAreaBottom = minimumArea(grid, RowSplit, grid.length, 0, ColSpilt);
                    int ColLeftAreaBottom = minimumArea(grid, RowSplit, grid.length, ColSpilt, grid[0].length);

                    int ColRightAreaUpper = minimumArea(grid, 0, RowSplit, 0, ColSpilt);
                    int ColLeftAreaUpper = minimumArea(grid, 0, RowSplit, ColSpilt, grid[0].length);

                    Result = Math.min(Result, RowUpperArea + ColRightAreaBottom + ColLeftAreaBottom);
                    Result = Math.min(Result, RowLowerArea + ColRightAreaUpper + ColLeftAreaUpper);
                }
            }

            for (int ColSpilt = 1; ColSpilt < grid[0].length; ColSpilt++) {
                int ColLeftArea = minimumArea(grid, 0, grid.length, 0, ColSpilt);
                int ColRightArea = minimumArea(grid, 0, grid.length, ColSpilt, grid[0].length);

                for (int RowSplit = 1; RowSplit < grid.length; RowSplit++){
                    int RowUpperAreaRight = minimumArea(grid, 0, RowSplit, ColSpilt, grid[0].length);
                    int RowBottomAreaRight = minimumArea(grid, RowSplit, grid.length, ColSpilt, grid[0].length);

                    int RowUpperAreaLeft = minimumArea(grid, 0, RowSplit, 0, ColSpilt);
                    int RowBottomAreaLeft = minimumArea(grid, RowSplit, grid.length, 0, ColSpilt);

                    Result = Math.min(Result, ColLeftArea + RowUpperAreaRight + RowBottomAreaRight);
                    Result = Math.min(Result, ColRightArea + RowUpperAreaLeft + RowBottomAreaLeft);
                }
            }


            // Case 2: ==

            for(int RowSplit_I = 1; RowSplit_I < grid.length; RowSplit_I++){

                int RowUpperArea = minimumArea(grid, 0, RowSplit_I, 0, grid[0].length);

                for (int RowSplit_II = RowSplit_I + 1; RowSplit_II < grid.length; RowSplit_II++){
                    int RowMidArea = minimumArea(grid, RowSplit_I, RowSplit_II, 0, grid[0].length);
                    int RowLowerArea = minimumArea(grid, RowSplit_II, grid.length, 0, grid[0].length);

                    Result = Math.min(Result, RowUpperArea + RowMidArea + RowLowerArea);
                }
            }


            //Case 3: ||

            for(int ColSplit_I = 1; ColSplit_I < grid[0].length; ColSplit_I++){
                int ColUpperArea = minimumArea(grid, 0, grid.length, 0, ColSplit_I);

                for (int ColSplit_II = ColSplit_I + 1; ColSplit_II < grid[0].length; ColSplit_II++){
                    int ColMidArea = minimumArea(grid, 0, grid.length, ColSplit_I, ColSplit_II);
                    int ColLowerArea = minimumArea(grid,0, grid.length, ColSplit_II, grid[0].length);

                    Result = Math.min(Result, ColUpperArea + ColMidArea + ColLowerArea);
                }
            }

            return Result;
        }

        private int minimumArea(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {

            int[] minMaxI = {Integer.MAX_VALUE, Integer.MIN_VALUE};
            int[] minMaxII = {Integer.MAX_VALUE, Integer.MIN_VALUE};

            for(int i=rowStart; i < rowEnd; i++){
                for (int j=colStart; j< colEnd; j++){
                    if(grid[i][j] == 1){
                        minMaxI[0] = Math.min(minMaxI[0], j);
                        minMaxI[1] = Math.max(minMaxI[1], j);
                        minMaxII[0] = Math.min(minMaxII[0], i);
                        minMaxII[1] = Math.max(minMaxII[1], i);
                    }
                }
            }

            return (minMaxI[1]-minMaxI[0] + 1) * (minMaxII[1]-minMaxII[0] + 1);
        }
    }

}

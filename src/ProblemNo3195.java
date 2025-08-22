import java.util.Arrays;

public class ProblemNo3195 {
    public static void main(String[] args) {

        ProblemNo3195.Solution a = new ProblemNo3195().new Solution();
        System.out.println(a.minimumArea(new int[][]{
                {0,1,0},{1,0,1}
        }));

    }

    class Solution {
        public int minimumArea(int[][] grid) {

            int[] minMaxI = {Integer.MAX_VALUE, Integer.MIN_VALUE};
            int[] minMaxII = {Integer.MAX_VALUE, Integer.MIN_VALUE};

            for(int i=0; i< grid.length; i++){
                for (int j=0; j< grid[0].length; j++){
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

//class Solution {
//    public int minimumArea(int[][] grid) {
//
//        int[] minMax = {Integer.MAX_VALUE, Integer.MIN_VALUE};
//
//        for(int i=0; i< grid.length; i++){
//            for (int j=0; j< grid[0].length; j++){
//                if(grid[i][j] == 1){
//                    minMax[0] = Math.min(minMax[0], j);
//                    minMax[1] = Math.max(minMax[1], j);
//                }
//            }
//        }
//
//        int result = minMax[1] - minMax[0] + 1;
//        System.out.println(Arrays.toString(minMax));
//
//        minMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
//
//        for(int i=0; i< grid[0].length; i++){
//            for (int j=0; j< grid.length; j++){
//                if(grid[j][i] == 1){
//                    minMax[0] = Math.min(minMax[0], j);
//                    minMax[1] = Math.max(minMax[1], j);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(minMax));
//
//        result *= (minMax[1]-minMax[0]) + 1;
//
//        return result;
//    }
//}

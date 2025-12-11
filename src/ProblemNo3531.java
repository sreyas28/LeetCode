import java.util.Arrays;

public class ProblemNo3531 {
    public static void main(String[] args) {

        ProblemNo3531.Solution a = new ProblemNo3531().new Solution();
        System.out.println(a.countCoveredBuildings(3, new int[][]{{1,1},{2,3},{3,3},{2,2},{1,3}}));

    }

    class Solution {
        public int countCoveredBuildings(int n, int[][] buildings) {

            int[][] xMinMax = new int[n+1][2];
            int[][] yMinMax = new int[n+1][2];

            for(int i=0; i < n+1; i++){
                xMinMax[i] = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
                yMinMax[i] = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
            }

//            System.out.println(Arrays.deepToString(xMinMax));
//            System.out.println(Arrays.deepToString(yMinMax));

            for(int[] building: buildings){
                int x = building[0], y = building[1];

                xMinMax[x][0] = Math.min(xMinMax[x][0], y);
                xMinMax[x][1] = Math.max(xMinMax[x][1], y);

                yMinMax[y][0] = Math.min(yMinMax[y][0], x);
                yMinMax[y][1] = Math.max(yMinMax[y][1], x);
            }

//            System.out.println(Arrays.deepToString(xMinMax));
//            System.out.println(Arrays.deepToString(yMinMax));

            int count = 0;

            for(int[] building: buildings){
                int x = building[0], y = building[1];

                int[] xLimit = xMinMax[x];
                int[] yLimit = yMinMax[y];

                if( x>yLimit[0] && x<yLimit[1] &&
                    y>xLimit[0] && y<xLimit[1]) count++;
            }

            return count;
        }
    }

}

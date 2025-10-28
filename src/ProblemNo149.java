public class ProblemNo149 {
    public static void main(String[] args) {

        ProblemNo149.Solution a = new ProblemNo149().new Solution();
        System.out.println(a.maxPoints(new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));

    }

    class Solution {
        public int maxPoints(int[][] points) {
            int max_Points = 1;
            for(int point_I = 0; point_I<points.length; point_I++){
                for(int point_II = point_I + 1; point_II < points.length; point_II++){
                    max_Points = Math.max(max_Points, oneLine(points[point_I], points[point_II], points));
                }
            }

            return max_Points;
        }

        private int oneLine(int[] point_I, int[] point_II, int[][] points){

            int a = point_II[0] - point_I[0], b = point_II[1] - point_I[1]; // a = x2-x1, b = y2-y1
            int rightSide = (point_I[1] * a) - (point_I[0] * b);

            int count = 0;
            for(int[] point: points){
                int leftSide = (point[1] * a) - (point[0] * b);
                if(leftSide == rightSide) count++;
            }

            return count;
        }

    }

}

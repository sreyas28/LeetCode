public class ProblemNo1266 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int dist = 0;

            for (int i = 1; i < points.length; i++) {
                int[] currPoint = points[i];
                int[] prevPoint = points[i-1];

                int diffX = Math.abs(prevPoint[0] - currPoint[0]);
                int diffY = Math.abs(prevPoint[1] - currPoint[1]);

                dist += Math.max(diffX, diffY);
            }

            return dist;
        }
    }

}

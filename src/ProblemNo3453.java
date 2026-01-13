import java.util.Arrays;

public class ProblemNo3453 {
    public static void main(String[] args) {

        ProblemNo3453.Solution p = new ProblemNo3453().new Solution();
        System.out.println(p.separateSquares(new int[][]{{0,0,2},{1,1,1}}));

    }

    class Solution {
        public double separateSquares(int[][] squares) {
            int maxY = Integer.MIN_VALUE;
            int minY = Integer.MAX_VALUE;

            final double epsilon = 1e-5;

            double[][] ranges = new double[squares.length][3];

            for (int i = 0; i < squares.length; i++) {
                int[] currSquare = squares[i];

                minY = Math.min(minY, currSquare[1]);
                maxY = Math.max(maxY, currSquare[1] + currSquare[2]);

                // 0 for minY, 1 for maxY and 2 for side len
                ranges[i][0] = currSquare[1];
                ranges[i][1] = currSquare[1] + currSquare[2];
                ranges[i][2] = currSquare[2];
            }

//            System.out.println(maxY + " " + minY);
//            System.out.println(Arrays.deepToString(ranges));

            double low = minY, high = maxY;

            while (high - low > epsilon) {
                double mid = (low + high) / 2;

                double sumUp = 0, sumDown = 0;
                for (double[] range : ranges) {
                    if (mid >= range[1]) sumDown += (range[2] * range[2]);
                    else if (mid <= range[0]) sumUp += (range[2] * range[2]);
                    else {
                        sumDown += (mid - range[0]) * range[2];
                        sumUp += (range[1] - mid) * range[2];
                    }
                }

                if (sumUp > sumDown) low = mid;
                else high = mid;

//                System.out.println("Low:" + low + " High" + high + " Mid:" + mid + " SumUP:" + sumUp + " SumDown:" + sumDown);
            }

            return (double) Math.round(low * 100000) / 100000;
        }
    }

}

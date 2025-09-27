public class ProblemNo812 {
    public static void main(String[] args) {

    }

    class Solution {
        public double largestTriangleArea(int[][] points) {
            int n = points.length;

            double area = 0;

            for(int i = 0; i < n - 2; i++){
                for(int j = i+1; j < n - 1; j++){
                    for(int k = j+1; k < n; k++){
                        area = Math.max(area, Area(points[i], points[j], points[k]));
                    }
                }
            }

            return area;
        }

        private double Area(int[] X, int[] Y, int[] Z){
            return 0.5 * Math.abs(X[0]*(Y[1] - Z[1])
                    + Y[0]*(Z[1] - X[1])
                    + Z[0]*(X[1] - Y[1])
            );
        }

    }

}


// Area = 0.5 |X1 (Y2-Y3) +X2(Y3-Y1) +X3(Y1-Y2)|
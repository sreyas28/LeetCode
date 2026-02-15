public class ProblemNo799 {
    public static void main(String[] args) {

        ProblemNo799.Solution p = new ProblemNo799().new Solution();
        System.out.println(p.champagneTower(25, 6, 1));

    }

    class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[][] A = new double[102][102];
            A[0][0] = (double) poured;
            for (int r = 0; r <= query_row; ++r) {
                for (int c = 0; c <= r; ++c) {
                    double q = (A[r][c] - 1.0) / 2.0;
                    if (q > 0) {
                        A[r + 1][c] += q;
                        A[r + 1][c + 1] += q;
                    }
                }
            }

            return Math.min(1, A[query_row][query_glass]);
        }
    }


    // does not respect 1.0 constrain
    class Solution_ {
        public double champagneTower(int poured, int query_row, int query_glass) {
            int rowsCompletelyFilled = (int) (2 * Math.sqrt(0.0625 + ((double) poured / 2)) - 0.5); // quadratic equation n(n+1)/2
            double extraCups = poured - ((double) (rowsCompletelyFilled * (rowsCompletelyFilled + 1)) / 2);

            if (rowsCompletelyFilled - 1 >= query_row) return 1.0; // if the water is filled too much glasses

            double res = nCr(query_row, query_glass) / Math.pow(2.0, query_row);

            return res * extraCups;
        }


        public static long nCr(int n, int r) {
            if (r > n) return 0;
            r = Math.min(r, n - r); // Use symmetry property
            long result = 1;

            for (int i = 1; i <= r; i++) {
                result = result * (n - i + 1) / i;
            }

            return result;
        }

    }

}

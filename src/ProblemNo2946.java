public class ProblemNo2946 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean areSimilar(int[][] mat, int k) {
            final int m = mat.length,  n = mat[0].length;
            k = k % n;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != mat[i][(j+k) % n]) return false;
                }
            }

            return true;
        }
    }

}

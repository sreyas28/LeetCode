public class ProblemNo1886 {
    public static void main(String[] args) {

        ProblemNo1886.Solution p = new ProblemNo1886().new Solution();
        System.out.println(p.findRotation(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}, new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}));

    }

    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            for (int i = 0; i < 4; i++) {
                if (equal(mat, target)) return true;
                mat = rotate(mat);
            }

            return false;
        }

        private int[][] rotate(int[][] matrix) {
            return transpose(shift(matrix));
        }

        private int[][] transpose(int[][] mat) {
            int[][] res = new int[mat[0].length][mat.length];

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    res[j][i] = mat[i][j];
                }
            }

            return res;
        }

        private int[][] shift(int[][] mat) {
            int[][] res = new int[mat.length][mat[0].length];

            for (int i = 0, j = mat.length - 1; i <= j; i++, j--) {
                res[i] = mat[j];
                res[j] = mat[i];
            }

            return res;
        }

        private boolean equal(int[][] mat1, int[][] mat2) {
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat1[0].length; j++) {
                    if (mat1[i][j] != mat2[i][j]) return false;
                }
            }

            return true;
        }
    }

}

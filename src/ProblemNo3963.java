public class ProblemNo3963 {
    class Solution {
        public String[] createGrid(int m, int n) {

            String[] grid = new String[m];


            for (int i = 0; i < m; i++) {
                StringBuilder sb = new StringBuilder();

                if (i == 0) sb.repeat(".", n);
                else {
                    sb.repeat("#", n - 1);
                    sb.append(".");
                }

                grid[i] = sb.toString();
            }

            return grid;
        }
    }
}

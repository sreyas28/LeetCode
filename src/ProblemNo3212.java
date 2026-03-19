public class ProblemNo3212 {
    public static void main(String[] args) {

        ProblemNo3212.Solution p = new ProblemNo3212().new Solution();
        System.out.println(p.numberOfSubmatrices(new char[][] {{'X','Y','.'},{'Y','.','.'}}));

    }

    class Solution {
        public int numberOfSubmatrices(char[][] grid) {
            int count = 0;
            int rows = grid.length,  cols = grid[0].length;
            int[][][] g = new int[rows][cols][2];

            if (grid[0][0] == 'X') g[0][0][0]++;
            else if (grid[0][0] == 'Y') g[0][0][1]++;

            for(int r = 1; r < rows; r++) {
                if (grid[r][0] == 'X') {
                    g[r][0][0] += g[r - 1][0][0] + 1;
                    g[r][0][1] += g[r - 1][0][1];
                }
                else if (grid[r][0] == 'Y') {
                    g[r][0][1] += g[r - 1][0][1] + 1;
                    g[r][0][0] += g[r - 1][0][0];
                }
                else {
                    g[r][0][0] = g[r-1][0][0];
                    g[r][0][1] = g[r-1][0][1];
                }

                if (g[r][0][0] != 0 && g[r][0][0] == g[r][0][1]) count++;
            }
            for(int c = 1; c < cols; c++) {
                if (grid[0][c] == 'X') {
                    g[0][c][0] += g[0][c - 1][0] + 1;
                    g[0][c][1] += g[0][c - 1][1];
                }
                else if (grid[0][c] == 'Y') {
                    g[0][c][1] += g[0][c - 1][1] + 1;
                    g[0][c][0] += g[0][c - 1][0];
                }
                else {
                    g[0][c][0] = g[0][c-1][0];
                    g[0][c][1] = g[0][c-1][1];
                }

                if (g[0][c][0] != 0 && g[0][c][0] == g[0][c][1]) count++;
            }

            for(int r = 1; r < rows; r++) {
                for(int c = 1; c < cols; c++) {

                    switch (grid[r][c]) {

                        case 'X':
                            g[r][c][0] += g[r-1][c][0] + g[r][c-1][0] - g[r-1][c-1][0] + 1;
                            g[r][c][1] += g[r-1][c][1] + g[r][c-1][1] - g[r-1][c-1][1];
                            break;

                        case 'Y':
                            g[r][c][0] += g[r-1][c][0] + g[r][c-1][0] - g[r-1][c-1][0];
                            g[r][c][1] += g[r-1][c][1] + g[r][c-1][1] - g[r-1][c-1][1] + 1;
                            break;

                        default:
                            g[r][c][0] += g[r-1][c][0] + g[r][c-1][0] - g[r-1][c-1][0];
                            g[r][c][1] += g[r-1][c][1] + g[r][c-1][1] - g[r-1][c-1][1];
                            break;
                    }

                    if (g[r][c][0] != 0 && g[r][c][0] == g[r][c][1]) count++;
                }
            }

            return count;
        }
    }

}

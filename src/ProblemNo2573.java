import java.util.Arrays;

public class ProblemNo2573 {
    public static void main(String[] args) {

        ProblemNo2573.Solution a = new ProblemNo2573().new Solution();
//        System.out.println(a.findTheString(new int[][]{{0}}));
//        System.out.println(a.findTheString(new int[][]{{4, 0, 2, 0}, {0, 3, 0, 1}, {2, 0, 2, 0}, {0, 1, 0, 1}}));
//        System.out.println(a.findTheString(new int[][]{{4, 3, 2, 1}, {3, 3, 2, 1}, {2, 2, 2, 1}, {1, 1, 1, 1}}));
        System.out.println(a.findTheString(new int[][]{
                {8, 0, 0, 0, 0, 1, 2, 0},
                {0, 7, 0, 1, 1, 0, 0, 1},
                {0, 0, 6, 0, 0, 0, 0, 0},
                {0, 1, 0, 5, 1, 0, 0, 1},
                {0, 1, 0, 1, 4, 0, 0, 1},
                {1, 0, 0, 0, 0, 3, 1, 0},
                {2, 0, 0, 0, 0, 1, 2, 0},
                {0, 1, 0, 1, 1, 0, 0, 1}}
        ));

    }

    class Solution {
        public String findTheString(int[][] lcp) {
            final int n = lcp.length;
            int[] resArray = new int[n];

            for (int i = 0; i < n; i++) resArray[i] = i;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] == 0) continue;

                    int range = n - j;
                    int current = lcp[i][j];
                    if (current > range) return "";

                    int temp = i;
                    for (int k = j; k < j + current; k++) {
                        resArray[k] = resArray[temp++];
                    }
                }
            }

            int[] remap = new int[n];
            Arrays.fill(remap, -1);
            int nextChar = 0;
            for (int i = 0; i < n; i++) {
                if (remap[resArray[i]] == -1) {
                    remap[resArray[i]] = nextChar++;
                }
                resArray[i] = remap[resArray[i]];
            }


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append((char) ((resArray[i] % 26) + 'a'));
            }

            return lcpMakerAndChecker(sb.toString(), lcp);
        }


        private String lcpMakerAndChecker(String str, int[][] givenMat) {
            int n = str.length();
            int[][] res = new int[n][n];


            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= i; j--) {
                    if (i == j) res[i][j] = n - i;
                    else {
                        boolean b = str.charAt(i) == str.charAt(j);
                        if (j == n - 1 && b) res[i][j] = 1;
                        else if (b) res[i][j] = 1 + res[i + 1][j + 1];

                        res[j][i] = res[i][j];
                    }

                    if (res[i][j] != givenMat[i][j] || res[i][j] != givenMat[j][i]) return "";

                }
            }

            return str;
        }

    }

}


//            if (n == 1 && lcp[0][0] == 0) return "";
//
//        for (int i = 0; i < n; i++) resArray[i] = i;
//
//            for (int i = 0; i < n; i++) {
//        for (int j = i; j < n; j++) {
//        int s1 = n - i, s2 = n - j;
//int range = Math.min(s1, s2);
//
//                    if (range < lcp[i][j] || lcp[i][j] != lcp[j][i]) return "";
//        if (lcp[i][j] == 0) continue;
//        else if (i == j && lcp[i][j] != n - i) return "";
//        else if (i != j) {
//int maxS1S2 = Math.max(s1, s2);
//                        for (int k = j, ex = 0; k < maxS1S2; k++, ex++) {
//resArray[k] = ex;
//                        }
//                                }
//                                }
//                                }
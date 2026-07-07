import java.util.Arrays;

public class ProblemNo1334 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1334().new Solution();
        System.out.println(a.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));

    }

    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] DP = new int[n][n];
            int[] res = new int[n];

            Arrays.fill(res, 0);

            for (int[] d : DP) Arrays.fill(d, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) DP[i][i] = 0;

            for (int[] edge : edges) {
                DP[edge[0]][edge[1]] = edge[2];
                DP[edge[1]][edge[0]] = edge[2];

                if (edge[2] <= distanceThreshold) {
                    res[edge[0]]++;
                    res[edge[1]]++;
                }
            }

            // check it, if there is a low-cost way present through kth node
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (i == k) continue;
                    for (int j = i + 1; j < n; j++) {
                        if (k == j) continue;

                        int edge1 = DP[i][k], edge2 = DP[k][j];
                        if (edge1 == Integer.MAX_VALUE || edge2 == Integer.MAX_VALUE) continue;

                        int sum = edge1 + edge2;
                        if (sum < DP[i][j]) {
                            if (DP[i][j] > distanceThreshold && sum <= distanceThreshold) {
                                res[i]++;
                                res[j]++;
                            }
                            DP[i][j] = sum;
                            DP[j][i] = sum;
                        }
                    }
                }
            }

            int min = res[0], index = 0;
            for (int i = 1; i < n; i++) {
                if (res[i] <= min) {
                    min = res[i];
                    index = i;
                }
            }

            return index;
        }
    }

}

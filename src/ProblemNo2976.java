import java.util.Arrays;

public class ProblemNo2976 {
    public static void main(String[] args) {

    }

    class Solution {
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            final int len = 26;
            long[][] costs = new long[len][len];

            for (long[] c : costs) Arrays.fill(c, Long.MAX_VALUE);
            for (int i = 0; i < len; i++) costs[i][i] = 0;

            for (int i = 0; i < original.length; i++) {
                int u = original[i] - 'a', v = changed[i] - 'a';
                costs[u][v] = Math.min(costs[u][v], cost[i]);
            }

            for (int k = 0; k < len; k++) {
                for (int i = 0; i < len; i++) {
                    if (i == k) continue;
                    for (int j = 0; j < len; j++) {
                        if (j == k) continue;

                        long edge1 = costs[i][k], edge2 =  costs[k][j];
                        if (edge1 == Long.MAX_VALUE || edge2 == Long.MAX_VALUE) continue;

                        long sum = edge1+edge2;
                        if (sum < costs[i][j])  costs[i][j] = sum;
                    }
                }
            }

            long result = 0;

            for(int i = 0; i < source.length(); i++){
                int sourceChar = source.charAt(i) - 'a';
                int targetChar = target.charAt(i) - 'a';

                if (sourceChar == targetChar) continue;

                long cst = costs[sourceChar][targetChar];
                if (cst == Long.MAX_VALUE) return -1;

                result += cst;
            }

            return result;
        }
    }

}

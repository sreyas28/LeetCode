import java.util.*;

public class ProblemNo877 {
    public static void main(String[] args) {

    }

    class Solution {
        private Long[][] DP1, DP2;

        public boolean stoneGame(int[] piles) {
            final int N = piles.length;

            long sum = Arrays.stream(piles).sum();
            DP1 = new Long[N][N];
            DP2 = new Long[N][N];

            long p1Score = recursionP1(0, N-1, piles);

            return (p1Score >= sum - p1Score);
        }

        private long recursionP1(int l, int r, int[] piles) {
            if (l == r) return piles[l];

            if  (DP1[l][r] != null) return DP1[l][r];

            long leftSum = recursionP2(l + 1, r, piles) + piles[l];
            long rightSum = recursionP2(l, r - 1, piles) + piles[r];

            DP1[l][r] = Math.max(leftSum, rightSum);

            return DP1[l][r];
        }

        private long recursionP2(int l, int r, int[] piles) {
            if (l == r) return piles[l];

            if (DP2[l][r] != null) return DP2[l][r];

            long leftSum = recursionP1(l + 1, r, piles);
            long rightSum = recursionP1(l, r - 1, piles);

            DP2[l][r] = Math.min(leftSum, rightSum);

            return DP2[l][r];
        }

    }

}

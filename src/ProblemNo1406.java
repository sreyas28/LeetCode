public class ProblemNo1406 {
    public static void main(String[] args) {
        Solution a = new ProblemNo1406().new Solution();
        System.out.println(a.stoneGameIII(new int[]{1,2,3,7}));
    }

    class Solution {
        private int N;
        private Long[] DP1, DP2;

        public String stoneGameIII(int[] stoneValue) {
            N = stoneValue.length;
            int[] prefixSums = new int[N+1];
            DP1 = new Long[N+1];
            DP2 = new Long[N+1];

            for  (int i = 1; i <= stoneValue.length; i++) {
                prefixSums[i] = prefixSums[i-1] + stoneValue[i-1];
            }

            long aliceScore = alice(0, prefixSums);
            long bobScore = prefixSums[N] - aliceScore;

            if (aliceScore > bobScore) return "Alice";
            else if (aliceScore == bobScore) return "Tie";
            else return "Bob";
        }

        private long alice(int i, int[] prefixSum){
            if (i > N-1) return 0;

            if (DP1[i] != null) return DP1[i];

            long first = (prefixSum[i+1] - prefixSum[i]) + bob(i+1, prefixSum);
            long second = i+2 <= N ? (prefixSum[i+2] - prefixSum[i]) + bob(i+2, prefixSum) : Integer.MIN_VALUE;
            long third = i+3 <= N ? (prefixSum[i+3] - prefixSum[i]) + bob(i+3, prefixSum)  : Integer.MIN_VALUE;

            DP1[i] = Math.max(first,Math.max(second,third));

            return DP1[i];
        }

        private long bob(int i, int[] prefixSum){
            if (i > N-1) return 0;

            if (DP2[i] != null) return DP2[i];

            long first = alice(i+1, prefixSum);
            long second = i+2 <= N ? alice(i+2, prefixSum) : Integer.MAX_VALUE;
            long third = i+3 <= N ? alice(i+3, prefixSum) : Integer.MAX_VALUE;

            DP2[i] = Math.min(first,Math.min(second,third));

            return DP2[i];
        }

    }

}

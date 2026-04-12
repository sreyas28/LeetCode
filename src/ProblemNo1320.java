public class ProblemNo1320 {
    public static void main(String[] args) {

        ProblemNo1320.Solution p = new ProblemNo1320().new Solution();
//        System.out.println(p.minimumDistance("HAPPY"));
        System.out.println(p.minimumDistance("QIBZR"));

    }

    class Solution {
        private int n;
        private Integer[][][] dp;
        private String word;

        public int minimumDistance(String word) {
            this.n = word.length();
            this.word = word;
            dp = new Integer[26][27][n];

            return dfsBottomsUps(word.charAt(0) - 'A', 26, 1);
        }

        private int dfsBottomsUps(int figI, int figII, int k) {
            if (k >= n) return 0;
            if (dp[figI][figII][k] != null) return dp[figI][figII][k];

            int currentLetter = word.charAt(k) - 'A';
            int costMovedFigI = (figI == 26 ? 0 : ManhattanDistance(figI, currentLetter)) + dfsBottomsUps(currentLetter, figII, k + 1);
            int costMovedFigII = (figII == 26 ? 0 : ManhattanDistance(figII, currentLetter)) + dfsBottomsUps(figI, currentLetter, k + 1);

            dp[figI][figII][k] = Math.min(costMovedFigI, costMovedFigII);
            return  dp[figI][figII][k];
        }

        private int ManhattanDistance(int A, int B) {
            int old_Row = A / 6;
            int old_Col = A % 6;
            int new_Row = B / 6;
            int new_Col = B % 6;

            return Math.abs(old_Row - new_Row) + Math.abs(old_Col - new_Col);
        }

    }

    // with Top down DFS but cant put DP here
    class Solution__ {
        private int n;
        private String word;
        private int sum = Integer.MAX_VALUE;

        public int minimumDistance(String word) {
            n = word.length();
            this.word = word;

            dfs(word.charAt(0) - 'A', 26, 0, 0);

            return sum;
        }

        private void dfs(int A, int B, int k, int sumSoFar) {
            if (k >= n) {
                sum = Math.min(sum, sumSoFar);
                return;
            }

            int currentLetter = word.charAt(k) - 'A';

            if (A == 26) dfs(currentLetter, B, k + 1, sumSoFar);
            else dfs(currentLetter, B, k + 1, sumSoFar + ManhattanDistance(A, currentLetter));

            if (B == 26) dfs(A, currentLetter, k + 1, sumSoFar);
            else dfs(A, currentLetter, k + 1, sumSoFar + ManhattanDistance(B, currentLetter));
        }

        private int ManhattanDistance(int A, int B) {
            int old_Row = A / 6;
            int old_Col = A % 6;
            int new_Row = B / 6;
            int new_Col = B % 6;

            return Math.abs(old_Row - new_Row) + Math.abs(old_Col - new_Col);
        }

    }

    // greedy will not work
    class Solution_ {
        public int minimumDistance(String word) {
            final int n = word.length();
            int sum = Integer.MAX_VALUE;

            int[] I_Finger = new int[n];

            for (int i = 1; i < n; i++) {
                I_Finger[i] = calculateDistance(word.charAt(i - 1), word.charAt(i));
            }

            int prevSum = 0;
            for (int i = 1; i < n; i++) {
                prevSum += I_Finger[i - 1];

                char I_Finger_Position = word.charAt(i - 1);
                char II_Finger_Position = word.charAt(i);
                int curSum = prevSum;

                for (int j = i + 1; j < n; j++) {
                    char curr = word.charAt(j);
                    int IFig_to_new_Distance = calculateDistance(I_Finger_Position, curr);
                    int IIFig_to_new_Distance = calculateDistance(II_Finger_Position, curr);

                    if (IFig_to_new_Distance <= IIFig_to_new_Distance) {
                        curSum += IFig_to_new_Distance;
                        I_Finger_Position = curr;
                    } else {
                        curSum += IIFig_to_new_Distance;
                        II_Finger_Position = curr;
                    }
                }

                sum = Math.min(sum, curSum);
            }


            return sum;
        }

        private int calculateDistance(char A, char B) {
            int old_Row = (A - 'A') / 6;
            int old_Col = (A - 'A') % 6;
            int new_Row = (B - 'A') / 6;
            int new_Col = (B - 'A') % 6;

            return Math.abs(old_Row - new_Row) + Math.abs(old_Col - new_Col);
        }

    }

}

import java.util.*;

public class ProblemNo1510 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1510().new Solution();
        System.out.println(a.winnerSquareGame(15));

    }

    class Solution {
        private static boolean[] DP;

        static {
            int size = 100_000;
            DP = new boolean[size + 1];

            for (int i = 1; i * i <= size; i++) DP[i * i] = true;

            for (int i = 1; i <= size; i++) {
                if (!DP[i]) {
                    int l = (int) Math.sqrt(i);
                    for (int j = 1; j <= l; j++) {
                        DP[i] |= !DP[i - j * j];
                    }
                }
            }
        }

        public boolean winnerSquareGame(int n) {
            return DP[n];
        }
    }

}

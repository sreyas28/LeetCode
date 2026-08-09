import java.util.Stack;

public class ProblemNo600 {
    public static void main(String[] args) {

        Solution a = new ProblemNo600().new Solution();
        System.out.println(a.findIntegers(5));
//        System.out.println(a.findIntegers(1));
//        System.out.println(a.findIntegers(2));

    }

    class Solution {
        private Integer[][][][] DP;

        public int findIntegers(int n) {
            String number = Integer.toBinaryString(n);
            this.DP = new Integer[number.length() + 1][2][2][3];

            return DFS(0, true, false, -1, number);
        }

        private int DFS(int idx, boolean tight, boolean start, int prev, String limit) {
            if (idx == limit.length()) return 1;

            if (DP[idx][tight ? 1 : 0][ start ? 1 : 0][prev + 1] != null) return DP[idx][tight ? 1 : 0][ start ? 1 : 0][prev + 1];

            int l = tight ? limit.charAt(idx) - '0' : 1;
            int count = 0;
            for (int i = 0; i <= l; i++) {
                if (start && i == 1 && prev == i) continue;
                else if (tight && i == l) count += DFS(idx + 1, true, start || i > 0, i, limit);
                else count += DFS(idx + 1, false, start || i > 0, i, limit);
            }

            DP[idx][tight ? 1 : 0][ start ? 1 : 0][prev + 1] = count;
            return count;
        }

    }

}

public class ProblemNo1411 {
    public static void main(String[] args) {
        ProblemNo1411.Solution p = new ProblemNo1411().new Solution();
        System.out.println(p.numOfWays(100));
    }


    class Solution {
        public int numOfWays(int n) {
            final int MOD = (int) (1e9+7);

            long X = 1;
            long Y = 1;
            for(int i = 1; i <= n; i++){
                long newX = (2*X + 2*Y) % MOD;
                long newY = (2*X + 3*Y) % MOD;

                X = newX;
                Y = newY;
            }

            return (int)((6 * X + 6 * Y) % MOD);
        }
    }


    // bruteForce take too much time
    class Solution_ {

        private final int MOD = (int) (1e9 + 7);

        public int numOfWays(int n) {
            return ((6*X(n-1) % MOD) + (6*Y(n-1) % MOD)) % MOD;
        }

        private int X(int i){
            if(i==0) return 1;
            if(i == 1) return 4;
            return ((2*X(i-1) % MOD) + (2*Y(i-1) % MOD)) % MOD;
        }

        private int Y(int i){
            if(i==0) return 1;
            if(i == 1) return 5;
            return ((2*X(i-1) % MOD) + (3*Y(i-1) % MOD)) % MOD;
        }

    }

}

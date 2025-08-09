public class ProblemNo808 {

    public static void main(String[] args) {
        ProblemNo808.Solution a = new ProblemNo808().new Solution();

        for(int i = 0; i < 1000000000; i += 50){
            System.out.println( i + " = " + a.soupServings(i));
        }
    }

    class Solution {
        public double soupServings(int n) {
            if(n >= 4500) return 1;
            double[][] memo = new double[n+1][n+1];
            return recurtion(n,n, memo);
        }

        private double recurtion(int x, int y, double[][] memo) {
            if(x <=0 && y <= 0) return 0.5;
            else if (x <= 0) return 1;
            else if ( y <= 0) return 0;
            else if (memo[x][y] != 0) return memo[x][y];

            memo[x][y] = 0.25 * (
                    recurtion(x-100, y, memo) + recurtion(x-75, y-25, memo) +
                    recurtion(x-50, y-50, memo) + recurtion(x-25, y-75, memo)
                    );

            return memo[x][y];
        }

    }

}

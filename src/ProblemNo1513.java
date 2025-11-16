public class ProblemNo1513 {
    public static void main(String[] args) {

    }

    class Solution {

        final int MOD = (int) (1e9 + 7);

        public int numSub(String s) {
            int ones = 0, result = 0;
            for(char c: s.toCharArray()){
                if(c == '1') ones++;
                else{
                    result += (int) (calculate(ones) % MOD);
                    ones = 0;
                }
            }
            result += (int) (calculate(ones) % MOD);
            return result;
        }

        private long calculate(int n){
            long temp = ((long) (n + 1) * n) % MOD;
            return temp / 2;
        }
    }

}

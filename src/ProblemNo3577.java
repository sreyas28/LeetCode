public class ProblemNo3577 {
    public static void main(String[] args) {

    }

    class Solution {
        public int countPermutations(int[] complexity) {
            final int MOD = (int) 1e9 + 7;
            int target = complexity[0];

            for(int i=1; i<complexity.length; i++){
                if(complexity[i] <= target) return 0;
            }

            int ans = 1;
            for(int i = 2; i < complexity.length; i++){
                ans = (int) (((long) ans * i) % MOD);
            }
            return ans;
        }
    }


    class Solution_ {
        private final int MOD = (int) 1e9+7;
        public int countPermutations(int[] complexity) {
            int target = complexity[0];

            for(int i=1; i<complexity.length; i++){
                if(complexity[i] <= target) return 0;
            }

            return (int) factorization(complexity.length - 1) % MOD;
        }

        private long factorization(int n){
            if(n == 2) return 2;
            return ((long)factorization(n-1)*n) % MOD;
        }
    }

}

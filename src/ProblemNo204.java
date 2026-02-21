public class ProblemNo204 {
    class Solution {
        public int countPrimes(int n) {
            if ( n <= 1) return 0;
            boolean[] isPrime = new boolean[n+1];
            isPrime[0] = true;
            isPrime[1] = true;
            int count = 0;

            for (int i = 2; i < n; i++) {
                if (!isPrime[i]) {
                    for (int j = i; j <= n; j += i) {
                        isPrime[j] = true;
                    }

                    count++;
                }
            }

            return count;
        }
    }
}

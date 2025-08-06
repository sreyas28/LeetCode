public class ProblemNo3405 {
    public static void main(String[] args) {
        ProblemNo3405.Solution a = new ProblemNo3405().new Solution();

        System.out.println(a.countGoodArrays(10,10,0));
    }

    class Solution {
        private int MOD = (int)1e9 + 7;

        public int countGoodArrays(int n, int m, int k) {
            long temp = (nCr(n - 1, k) * (long) m) % MOD;
            long expo = power(m - 1, n - k - 1);

            long result = (temp * expo) % MOD;
            return (int) result;
        }

        private long nCr(int n, int r) {
            if (r > n) {
                return 0; // nCr is not defined for r > n
            }
            r = Math.min(r, n - r); // Use symmetry property nCr = nC(n-r)
            long result = 1;
            for (int i = 0; i < r; i++) {
                result = (result * (n - i)) % MOD;
                result = (result * modInverse(i + 1, MOD)) % MOD; // Corrected division using modular inverse
            }
            return result;
        }

        // Function to compute modular inverse using Fermat's Little Theorem
        private long modInverse(long a, int mod) {
            return power(a, mod - 2); // Computes a^(mod-2) % mod
        }

        // Function to compute power with modulus (Fast Exponentiation)
        private long power(long base, long exp) {
            long result = 1;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    result = (result * base) % MOD;
                }
                base = (base * base) % MOD;
                exp >>= 1;
            }
            return result;
        }
    }


}

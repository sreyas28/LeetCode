import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemNo1012 {
    public static void main(String[] args) {
        ProblemNo1012.Solution sol = new ProblemNo1012().new Solution();
        System.out.println(sol.numDupDigitsAtMostN(545));
    }

    class Solution {
        public int numDupDigitsAtMostN(int n) {
            return (int) (n - countUnique(n));
        }

        private long countUnique(int n) {
            List<Integer> digits = new ArrayList<>();
            while (n > 0) {
                digits.add(n % 10);
                n /= 10;
            }
            digits = digits.reversed();
            int len = digits.size();

            long res = 0;
            // counting unique numbers with different length
            for (int i = 1; i < len; i++) {
                res += 9 * permutation(9, i - 1);
            }

            // counting unique numbers with same length
            boolean[] visited = new boolean[10];

            for (int i = 0; i < len; i++) {
                int d = digits.get(i);

                for (int x = (i == 0 ? 1 : 0); x < d; x++) {
                    if (!visited[x]) {
                        res += permutation(9 - i, len - i - 1);
                    }
                }

                if (visited[d]) break;
                visited[d] = true;

                if (i == len - 1) res++;
            }


            return res;
        }

        private long permutation(int m, int k) {
            long res = 1;
            for (int i = 0; i < k; i++) res *= (m - i);
            return res;
        }
    }

    // good for rounded digits but fails for random digits
    class Solution__ {
        public int numDupDigitsAtMostN(int n) {
            if (n <= 10) return 0;

            long toMinus = 9;
            long current = 9;
            long pow = 100;
            for (int i = 1; pow <= n; pow *= 10, i++) {
                current *= 10 - i;
                toMinus += current;
            }
            pow /= 10;

            // for rounded values like 10 100 1000 10000 ...
            if (pow == n) return (int) (pow - toMinus);

            String nWord = String.valueOf(n);
            int len = nWord.length();
            long[] products = new long[len];
            products[0] = 9;

            for (int i = 9, count = 1; count < len; i--, count++) products[count] = i;
            for (int i = len - 2; i >= 0; i--) products[i] *= products[i + 1];

//            System.out.println(Arrays.toString(products));

            boolean[] visited = new boolean[10];

            for (int i = 0; i < len; i++) {
                int digit = nWord.charAt(i) - '0';
                int tempDigit = digit;

                if (i != 0) {
                    int prevDigit = nWord.charAt(i - 1) - '0';
                    if (digit < prevDigit) digit++;
//                    else if(visited[digit]) digit--;
                } else digit = digit - 1 == 0 ? 1 : digit - 1;

                current = digit * (i + 1 < len ? products[i + 1] : 1);
                toMinus += current;

                if (visited[tempDigit]) break;
                visited[tempDigit] = true;
            }

            return (int) (n - toMinus);
        }
    }

    private void valueFinder() {
        long[] vals = new long[10];

        long pow = 10;
        long toMinus = 9;
        long toMinus2 = 9;
        for (int i = 2; i < 10; i++) {
            pow *= 10;
            toMinus2 *= (11 - i);
            toMinus += toMinus2;

            vals[i] = pow - toMinus;
        }

        System.out.println(Arrays.toString(vals));
    }
}

public class ProblemNo3658 {
    public static void main(String[] args) {

    }

    class Solution {
        public int gcdOfOddEvenSums(int n) {
            return n;

            // as n^2 and n8(n+1) both have n that means GCD is n
        }
    }

    class Solution_ {
        public int gcdOfOddEvenSums(int n) {
            int sumEven = n * (n + 1);
            int sumOdd = n * n;

            return GCD(sumEven, sumOdd);
        }

        private int GCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }

            return a;
        }

    }

}

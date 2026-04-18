public class ProblemNo3783 {
    class Solution {
        public int mirrorDistance(int n) {
            return Math.abs(n - reverse(n));
        }

        private int reverse(int a) {
            int rev = 0;

            while (a > 0) {
                rev = rev * 10 + a % 10;
                a = a /10;
            }

            return rev;
        }
    }
}

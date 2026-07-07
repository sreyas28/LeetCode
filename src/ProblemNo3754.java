public class ProblemNo3754 {
    public static void main(String[] args) {

    }

    class Solution {
        public long sumAndMultiply(int n) {
            long sum = 0, multiply = 0;

            int i = 1;
            while (n > 0) {
                int val = n % 10;
                n /= 10;
                if (val == 0) continue;

                sum += val;
                multiply += ((long) val * i);
                i *= 10;
            }

            return sum * multiply;
        }
    }

}

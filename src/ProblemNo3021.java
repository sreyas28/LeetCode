public class ProblemNo3021 {

    public static void main(String[] args) {

    }

    class Solution {
        public long flowerGame(int n, int m) {
            int even_n = n / 2;
            int even_m = m / 2;
            int odd_n = n - even_n;
            int odd_m = m - even_m;

            return ((long) even_n * odd_m) + ((long) even_m * odd_n);
        }
    }

}

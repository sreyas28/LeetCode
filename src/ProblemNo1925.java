public class ProblemNo1925 {
    public static void main(String[] args) {

    }

    class Solution {
        public int countTriples(int n) {
            int count = 0;

            for(int a=1; a<=n; a++){
                int square_a = a*a;
                for(int b=a+1; b<=n; b++){
                    int square_a_b = square_a + (b*b);

                    double sqr_a_b = Math.sqrt(square_a_b);
                    int sqr_a_b_true = (int) sqr_a_b;

                    if((double)sqr_a_b_true == sqr_a_b && sqr_a_b_true <= n) count += 2;
                }
            }

            return count;
        }
    }

}

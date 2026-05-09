import java.util.ArrayList;
import java.util.List;

public class ProblemNo264 {
    public static void main(String[] args) {

        Solution a = new ProblemNo264().new Solution();
        System.out.println(a.nthUglyNumber(10));

    }

    class Solution {
        private static final List<Integer> ANSWERS;

        static {
            ANSWERS = new ArrayList<>();

            for (int five = 0; five < 15; five++) {
                final long FIVE = (long) Math.pow(5, five);

                if (FIVE > Integer.MAX_VALUE) break;
                for (int three = 0; three < 21; three++) {
                    final long THREE = (long) Math.pow(3, three);

                    if (THREE * FIVE > Integer.MAX_VALUE) break;
                    for (int two = 0; two < 32; two++) {
                        long val = (long) (THREE * FIVE * Math.pow(2, two));
                        if (val > Integer.MAX_VALUE) break;
                        else ANSWERS.add((int)val);
                    }
                }
            }

            ANSWERS.sort(Integer::compareTo);
        }


        public int nthUglyNumber(int n) {
            return ANSWERS.get(n-1);
        }
    }

}

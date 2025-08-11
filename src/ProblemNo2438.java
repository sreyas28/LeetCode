import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemNo2438 {
    public static void main(String[] args) {

        ProblemNo2438.Solution a = new ProblemNo2438().new Solution();
        System.out.println(Arrays.toString(a.productQueries(2, new int[][]{{0, 0}})));

    }

    class Solution {

        private final int MOD = 1000000007;

        public int[] productQueries(int n, int[][] queries) {
            List<Integer> power_2 = new ArrayList<>();
            int rep = 1;
            while (n > 0) {
                if (n % 2 == 1) {
                    power_2.add(rep);
                }
                n /= 2;
                rep *= 2;
            }

            int[] result = new int[queries.length];

            for(int i=0; i< queries.length; i++){
                int[] query = queries[i];
                long cur = 1;
                for(int range = query[0]; range <= query[1]; range++){
                    cur = (cur * power_2.get(range)) % MOD;
                }
                result[i] = (int) cur;
            }

            return result;
        }
    }

}

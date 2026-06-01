import java.util.*;

public class ProblemNo2144 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2144().new Solution();
        System.out.println(a.minimumCost(new int[]{6, 5, 7, 9, 2, 2}));

    }

    class Solution {
        public int minimumCost(int[] cost) {
            final int N = cost.length;
            Arrays.sort(cost);

            int sum = 0;
            for (int i = N - 1; i >= 0; i -= 3) {
                sum += cost[i] + (i - 1 >= 0 ? cost[i - 1] : 0);
            }

            return sum;
        }
    }

}

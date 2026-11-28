import java.util.*;

public class ProblemNo3947 {

    public static void main(String[] args) {

        Solution a = new ProblemNo3947().new Solution();
//        System.out.println(a.maximumSaleItems(new int[][]{{2, 8}, {1, 10}, {6, 6}, {4, 12}, {5, 20}, {5, 17}}, 35));
        System.out.println(a.maximumSaleItems(new int[][]{{2,10},{2,35},{4,19},{4,13},{4,19},{4,41},{4,10}}, 71));

    }

    class Solution {

        private final static int LIMIT = 1_00_000;
        private static ArrayList<Integer>[] factors;

        static {
            factors = new ArrayList[LIMIT + 1];

            for (int i = 2; i <= LIMIT; i++) {
                int multi = 2;

                while (i * multi <= LIMIT) {
                    int index = i * multi;
                    if (factors[index] == null) factors[index] = new ArrayList<>();
                    factors[index].add(i);

                    multi++;
                }
            }
        }

        public int maximumSaleItems(int[][] items, int budget) {
            Arrays.sort(items, (a, b) -> a[1] - b[1]);

            Map<Integer, Integer> freq = new HashMap<>();
            for (int[] item : items) freq.merge(item[0], 1, Integer::sum);

            Map<Integer, Integer> gain = new HashMap<>();
            for (int factor : freq.keySet()) {
                gain.merge(factor, freq.get(factor) - 1, Integer::sum);

                if (factors[factor] != null) {
                    for (int fac : factors[factor]) gain.merge(fac, freq.get(factor), Integer::sum);
                }
            }

            if (freq.containsKey(1)) gain.put(1, items.length - 1);

            int ans = 0, min = items[0][1];

            for (int[] item : items) {
                int factor = item[0], price = item[1];

                if (price - min > min) break;

                int take = Math.min(gain.get(factor), budget / price);
                ans += take * 2;
                budget -= take * price;
            }

            ans += budget / min;
            return ans;
        }
    }

}

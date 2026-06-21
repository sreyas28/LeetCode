import java.util.*;

public class ProblemNo1833 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1833().new Solution();
        System.out.println(a.maxIceCream(new int[]{1,3,2,4,1}, 7));

    }

    // with Counting Sort
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            int max = costs[0];
            for (int i = 1; i < costs.length; i++) max = Math.max(max, costs[i]);
            int[] map = new int[max+1];

            for (int i : costs) map[i]++;

            int count = 0;
            for (int price = 1; price <= max; price++) {
                if  (map[price] == 0) continue;

                int canBuy = Math.min(coins / price, map[price]);

                count += canBuy;
                coins -= canBuy * price;

                if (price > coins) break;
            }

            return count;
        }
    }

    // with HashMap Counting Sort
    class Solution__ {
        public int maxIceCream(int[] costs, int coins) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i : costs) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            int count = 0;
            for (int key : map.keySet()) {
                int canBuy = Math.min(coins / key,  map.get(key));

                count += canBuy;
                coins -= canBuy * key;
                if (coins < key) break;
            }

            return count;
        }
    }


    // without counting Sort
    class Solution_ {
        public int maxIceCream(int[] costs, int coins) {
            int count = 0;
            Arrays.sort(costs);

            for (int i = 0; i < costs.length && coins >= costs[i]; i++) {
                count++;
                coins -= costs[i];
            }

            return count;
        }
    }

}

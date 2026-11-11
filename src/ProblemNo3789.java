public class ProblemNo3789 {
    public static void main(String[] args) {

    }

    class Solution {
        public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
            long minCost = (long) need1 * cost1 + (long) need2 * cost2;
            minCost = Math.min(minCost, (long) costBoth * Math.max(need1, need2));

            int min = Math.min(need1, need2);
            minCost = Math.min(minCost, (long) costBoth * min + (long) cost1 * (need1 - min) + (long) cost2 * (need2 - min));

            return minCost;
        }
    }

}

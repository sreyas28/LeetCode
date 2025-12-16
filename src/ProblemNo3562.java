import java.util.*;

public class ProblemNo3562 {

    public static void main(String[] args) {

    }


    class Solution {

        private int n, currMaxProfit;
        private int[] present, future;
        private List<Integer>[] adj;

        public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
            this.n = n;
            this.currMaxProfit = 0;
            this.present = present;
            this.future = future;

            adj = new ArrayList[n];
            for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
            for(int[] h: hierarchy){
                int u = h[0]-1;
                int v = h[1]-1;
                adj[u].add(v);
            }

            int[][][] statesProfit = new int[n][2][budget + 1];

            dfs(0, budget,statesProfit);

            int ans = 0;
            for (int b = 0; b <= budget; b++) {
                ans = Math.max(ans, statesProfit[0][0][b]);
            }
            return ans;
        }

        private void dfs(int u, int budget, int[][][] stateProfit){
            List<int[][]> childrenProfit = new ArrayList<>();

            for(int v: adj[u]){
                dfs(v, budget, stateProfit);
                childrenProfit.add(new int[][] {stateProfit[v][0], stateProfit[v][1]});
            }

            for(int parentBrought = 0; parentBrought <= 1; parentBrought++){
                int price = (parentBrought == 1) ? present[u]/2 : present[u];
                int profit = future[u] - price;

                int[] maxProfitAtU = new int[budget+1];

                // U is not buying
                for(int[][] child: childrenProfit){
                    int[] notBroughtChildren = child[0];
                    int[] tempProfit = new int[budget+1];

                    for(int used=0; used<=budget; used++){
                        for(int taken=0; used+taken<=budget; taken++){
                            tempProfit[taken+used] = Math.max(tempProfit[taken+used], maxProfitAtU[used] + notBroughtChildren[taken]);
                        }
                    }
                    maxProfitAtU = tempProfit;
                }

                // U is brought
                if(price <= budget){
                    int[] childrenProfitIfUBrought = new int[budget+1];

                    for(int[][] child: childrenProfit){
                        int[] broughtChildren = child[1];
                        int[] tempProfit = new int[budget+1];

                        for(int used=0; used<=budget; used++){
                            for(int taken=0; used+taken<=budget; taken++){
                                tempProfit[taken+used] = Math.max(tempProfit[taken+used], childrenProfitIfUBrought[used] + broughtChildren[taken]);
                            }
                        }
                        childrenProfitIfUBrought = tempProfit;
                    }

                    for(int b=price; b<=budget; b++){
                        maxProfitAtU[b] = Math.max(maxProfitAtU[b], childrenProfitIfUBrought[b-price] + profit);
                    }

                }

                stateProfit[u][parentBrought] = maxProfitAtU;
            }
        }
    }

    // gives TLE only good for small value of n
    class Solution_ {

        private int n, currMaxProfit;
        private int[] present, future, owners, sequence;

        public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
            this.n = n;
            this.currMaxProfit = 0;
            this.present = present;
            this.future = future;
            this.sequence = new int[n];
            this.owners = new int[n];

            // mapping employee with Owners
            Map<Integer, List<Integer>> ownerEmployee = new HashMap<>();
            for(int i=0; i<n; i++) owners[i] = i;
            for(int[] h: hierarchy) {
                ownerEmployee.computeIfAbsent(h[0]-1, a-> new ArrayList<>()).add(h[1]-1);
                owners[h[1] - 1] = h[0] - 1;
            }

            // making sequence
            Stack<Integer> se = new Stack<>();
            int i = 0;
            se.push(0);
            while(!se.isEmpty()){
                int ow = se.pop();
                for(int emp: ownerEmployee.getOrDefault(ow, new ArrayList<>())) se.push(emp);
                sequence[i++] = ow;
            }

            takenNotTaken(0, budget, new boolean[n], 0);

            return currMaxProfit;
        }

        private void takenNotTaken(int index, int budget, boolean[] takenOrNot, int prevProfit){
            if(index >= n) return;
            int employee = sequence[index];

            // calculating cost
            int cost = present[employee];
            if(owners[employee] != employee && takenOrNot[owners[employee]]) cost = Math.floorDiv(cost, 2);

            // calculating profit
            int currProfit = future[employee] - cost;

            // taking
            if(cost <= budget){
                currMaxProfit = Math.max(currMaxProfit, prevProfit + currProfit);
                takenOrNot[employee] = true;
                takenNotTaken(index+1, budget-cost, takenOrNot, prevProfit+currProfit);
                takenOrNot[employee] = false;
            }

            // not taking
            currMaxProfit = Math.max(currMaxProfit, prevProfit);
            takenNotTaken(index+1, budget, takenOrNot, prevProfit);
        }
    }

}

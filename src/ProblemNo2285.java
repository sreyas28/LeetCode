import java.util.Arrays;

public class ProblemNo2285 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2285().new Solution();
        System.out.println(a.maximumImportance(5, new int[][] {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));

    }

    class Solution {
        public long maximumImportance(int n, int[][] roads) {
            int[] connections =  new int[n];

            for(int[] road : roads){
                connections[road[0]]++;
                connections[road[1]]++;
            }

            Arrays.sort(connections);
            long ans = 0;

            for(int i = 0; i < n; i++) ans += (long) connections[i] * (i+1);

            return ans;
        }
    }

}

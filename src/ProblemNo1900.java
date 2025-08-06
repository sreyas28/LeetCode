import java.util.ArrayList;
import java.util.Arrays;

public class ProblemNo1900 {
    public static void main(String[] args) {

        ProblemNo1900.Solution a = new ProblemNo1900().new Solution();
        System.out.println(Arrays.toString(a.earliestAndLatest(11, 2, 4)));
    }

    class Solution {

        ArrayList<Integer> minMax;

        public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
            minMax = new ArrayList<>();
            int[] players = new int[n];
            Arrays.fill(players, 1);
            System.out.println(Arrays.toString(players));

            dfs(players, firstPlayer-1, secondPlayer-1);

            return null;
        }

        private void dfs (int[] players, int firstPlayer, int secondPlayer){
            int i = 0, j = players.length - 1;
            while(i < j){
                if(players[i] == 0) i++;
                if(players[j] == 0) j++;

                


            }

        }


    }

}

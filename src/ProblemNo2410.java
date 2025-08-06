import java.util.Arrays;

public class ProblemNo2410 {
    public static void main(String[] args) {

        ProblemNo2410.Solution a = new ProblemNo2410().new Solution();

        System.out.println(a.matchPlayersAndTrainers(new int[] {1,1,1}, new int[]{10}));

    }

    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);

            int i = 0, j = 0, count = 0;
            int lenPlayer = players.length, lenTrainers = trainers.length;
            while(i < lenPlayer && j < lenTrainers){

                if(players[i] <= trainers[j]) {
                    count++; j++; i++;
                }
                else j++;
            }


            return count;
        }
    }
}

import java.util.*;

public class ProblemNo3635 {
    public static void main(String[] args) {

    }

    class Solution {
        public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

            int I = solve(landStartTime, landDuration, waterStartTime, waterDuration);
            int II = solve(waterStartTime, waterDuration,  landStartTime, landDuration);

            return Math.min(II, I);
        }

        private int solve(int[] startTime_I, int[] duration_I, int[] startTime_II, int[] duration_II){

            int finish_I = Integer.MAX_VALUE;
            for(int i = 0; i < startTime_I.length; i++){
                finish_I = Math.min(finish_I, startTime_I[i]+duration_I[i]);
            }

            int finish_II = Integer.MAX_VALUE;
            for(int i = 0; i < startTime_II.length; i++){
                finish_II = Math.min(finish_II, Math.max(finish_I, startTime_II[i]) + duration_II[i]);
            }

            return finish_II;
        }
    }

}

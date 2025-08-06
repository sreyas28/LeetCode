import java.util.ArrayList;
import java.util.Arrays;

public class ProblemNo3439 {
    public static void main(String[] args) {

        ProblemNo3439.Solution a = new ProblemNo3439().new Solution();


        System.out.println(a.maxFreeTime(21, 1, new int[] {7,10,16}, new int[] {10,14,18}));

    }

    class Solution {
        public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
            ArrayList<Integer> FreeTime = new ArrayList<>();

            FreeTime.add(startTime[0]);
            for(int i = 1; i < startTime.length; i++ ){
                FreeTime.add(startTime[i] - endTime[i-1]);
            }
            FreeTime.add(eventTime - endTime[endTime.length - 1]);

            System.out.println(FreeTime);
            int n = FreeTime.size();

            int window = 0, left = 0, right = 0;
            while(right < k+1 && right < n) window += FreeTime.get(right++);

            int max = window;
            while(right < n){
               window = window - FreeTime.get(left++) + FreeTime.get(right++);
               max = Math.max(window, max);
            }


            return max;
        }
    }

}

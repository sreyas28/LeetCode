import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class ProblemNo3440 {
    public static void main(String[] args) {
        ProblemNo3440.Solution a = new ProblemNo3440().new Solution();


        System.out.println(a.maxFreeTime(41, new int[] {17,24}, new int[] {19,25}));
    }

    class Solution {
        public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
            int n = startTime.length;
            int[] freeTime = new int[n + 1];

            freeTime[0] = startTime[0];
            for(int i = 1; i < freeTime.length - 1; i++){
                freeTime[i] = startTime[i] - endTime[i-1];
            }
            freeTime[n] = eventTime - endTime[n-1];
            System.out.println(Arrays.toString(freeTime));

            for(int i = 0; i < n; i++){

                    

            }


            return 0;
        }
    }

}

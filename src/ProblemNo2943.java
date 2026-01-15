import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemNo2943 {
    public static void main(String[] args) {

        ProblemNo2943.Solution p = new ProblemNo2943().new Solution();
        System.out.println(p.maximizeSquareHoleArea(2,3, new int[]{2,3}, new int[]{2,4}));

    }

    class Solution {
        public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

            Arrays.sort(hBars);
            Arrays.sort(vBars);

            int maxHGap = gapCal(n, hBars);
            int maxVGap = gapCal(m, vBars);

//            System.out.println(maxVGap + " " + maxHGap);

            return (int) Math.pow(Math.min(maxHGap, maxVGap), 2);
        }

        private int gapCal(int size, int[] boxes){
            int maxGap = Integer.MIN_VALUE;

            int gap = 2;
            for(int i = 1; i < boxes.length; i++){
                if(boxes[i] == boxes[i-1] + 1) gap++;
                else gap = 2;

                maxGap = Math.max(maxGap, gap);
            }

            maxGap = Math.max(maxGap, gap);

            return maxGap;
        }
    }

}

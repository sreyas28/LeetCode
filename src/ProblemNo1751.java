import java.util.Arrays;

public class ProblemNo1751 {
    public static void main(String[] args) {

        ProblemNo1751.Solution a = new ProblemNo1751().new Solution();
        System.out.println(a.maxValue(new int[][] {{1,2,4},{3,4,3},{2,3,1}}, 2));

    }

    class Solution {
        public int maxValue(int[][] events, int k) {

            Arrays.sort(events, (a,b) -> b[2] - a[2]);
            int[] window = {events[0][0], events[0][1]};
            System.out.println(Arrays.deepToString(events));

            return 0;
        }
    }

}

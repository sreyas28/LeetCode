import java.util.Arrays;

public class ProblemNo1353 {
    public static void main(String[] args) {

        ProblemNo1353.Solution a = new ProblemNo1353().new Solution();


        System.out.println(a.maxEvents(new int[][] { {1,2},{2,3},{3,4},{1,2}}));

    }

    class Solution {
        public int maxEvents(int[][] events) {

            Arrays.sort(events, (a, b) -> a[0] - b[0]);
            System.out.println(Arrays.deepToString(events));
            Arrays.sort(events, (a, b) -> a[1] - b[1]);
            System.out.println(Arrays.deepToString(events));

            return 0;
        }
    }

}

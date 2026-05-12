import java.util.Arrays;

public class ProblemNo1665 {
    public static void main(String[] args) {
        Solution a = new ProblemNo1665().new Solution();
        System.out.println(a.minimumEffort(new int[][]{{1, 1}, {1, 3}}));
    }

    class Solution {
        public int minimumEffort(int[][] tasks) {
//            Arrays.sort(tasks, (a, b) -> {
//                int diff_A = a[1] - a[0];
//                int diff_B = b[1] - b[0];
//
//                if (diff_A != diff_B) return diff_B - diff_A;
//                else if (a[0] != b[0]) return a[0] - b[0];
//                else return a[1] - b[1];
//            });

            Arrays.sort(tasks, (a, b) -> Integer.compare(b[1]-b[0], a[1]-a[0]));

            int req = 0;
            int old = 0;

            for (int[] task : tasks) {
                int temp = task[1] - old;

                req += Math.max(temp, 0);
                old = task[1] - task[0] + Math.abs(Math.min(temp,0));
            }


            return req;
        }
    }

}

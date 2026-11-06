import java.util.ArrayList;
import java.util.Arrays;

public class ProblemNo2747 {
    public static void main(String[] args) {

        Solution a = new ProblemNo2747().new Solution();
        System.out.println(Arrays.toString(a.countServers(3, new int[][]{{1, 3}, {2, 6}, {1, 5}}, 5, new int[]{10, 11})));
        System.out.println(Arrays.toString(a.countServers(3, new int[][]{{2,4},{2,1},{1,2},{3,1}}, 2, new int[]{3, 4})));

    }

    class Solution {
        public int[] countServers(int n, int[][] logs, int x, int[] queries) {
            final int queriesLength = queries.length;
            final int logsLength = logs.length;

            Arrays.sort(logs, (a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                else return a[1] - b[1];
            });

            ArrayList<int[]> queriesSorted = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) queriesSorted.add(new int[]{i, queries[i]}); // index, query
            queriesSorted.sort((a, b) -> a[1] - b[1]);

            int[] ans = new int[queriesLength];
            int[] freq = new int[n + 1];
            int count = 0;

            int left = 0, right = 0;

            for (int[] query : queriesSorted) {
                int index = query[0];

                int rangeUpper = query[1];
                int rangeLower = rangeUpper - x;

                while (right < logsLength && logs[right][1] <= rangeUpper) {
                    int localIndex = logs[right][0];
                    if (freq[localIndex] == 0) count++;

                    freq[localIndex]++;
                    right++;
                }

                while (left < logsLength && logs[left][1] < rangeLower) {
                    int localIndex = logs[left][0];

                    if (freq[localIndex] > 0) {
                        freq[localIndex]--;
                        if (freq[localIndex] == 0) count--;
                    }

                    left++;
                }


                ans[index] = n - count;
            }


            return ans;
        }
    }

}

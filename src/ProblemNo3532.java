import java.util.*;

public class ProblemNo3532 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3532().new Solution();
        System.out.println(Arrays.toString(a.pathExistenceQueries(4, new int[]{2, 5, 6, 8}, 2, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}})));

    }


    class Solution {
        public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
            int[] id = new int[n];

            for (int i = 1; i < n; i++) {
                id[i] = id[i-1] + ((nums[i] - nums[i-1] <= maxDiff) ? 0: 1);
            }

            boolean[] ans = new boolean[queries.length];
            for(int i = 0; i < queries.length; i++) {
                int leftVal = id[queries[i][0]],  rightVal = id[queries[i][1]];
                ans[i] = leftVal == rightVal;
            }

            return ans;
        }
    }

    // TLE
    class Solution_ {
        public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
            List<int[]> list = new ArrayList<>();

            int i = 0;
            while (i < n) {
                int weight = nums[i];

                int left = weight - maxDiff, right = weight + maxDiff;
                int leftIndex = i, rightIndex = i;

                while (leftIndex-1 >= 0 && left <= nums[leftIndex-1]) leftIndex--;
                while (rightIndex+1 < n && right >= nums[rightIndex+1]) rightIndex++;

                if (list.isEmpty()) list.add(new int[]{leftIndex, rightIndex});
                else {
                    int[] last = list.getLast();
                    if (last[0] <= leftIndex &&  leftIndex <= last[1] ) {
                        list.removeLast();
                        list.add(new int[]{last[0], Math.max(rightIndex, last[1])});
                    }
                    else list.add(new int[]{leftIndex, rightIndex});
                }

                i = rightIndex + 1;
            }


            i = 0;
            boolean[] ans = new boolean[queries.length];
            for(int[] query : queries) {
                for(int[] window : list) {
                    if(sanityCheck(query[0], query[1], window[0], window[1])) {
                        ans[i] = true;
                        break;
                    }
                }
                i++;
            }

            return ans;
        }

        private boolean sanityCheck(int left, int right, int windowLeft, int windowRight) {
            return windowLeft <= left && left <= windowRight && windowLeft <= right && right <= windowRight;
        }

    }

}

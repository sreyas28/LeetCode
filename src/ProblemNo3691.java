import java.util.*;

public class ProblemNo3691 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3691().new Solution();
        System.out.println(a.maxTotalValue(new int[]{18,36,6} , 6));

    }

    class Solution {
        int[][] segmentTree; // min = 0, max = 1

        private void segmentTreeMaker(int i, int left, int right, int[] nums) {
            if (left == right) {
                segmentTree[i][0] = nums[left];
                segmentTree[i][1] = nums[left];
                return;
            }

            int mid = (left + right) / 2;

            segmentTreeMaker(2 * i + 1, left, mid, nums);
            segmentTreeMaker(2 * i + 2, mid + 1, right, nums);

            segmentTree[i][0] = Math.min(segmentTree[2 * i + 1][0], segmentTree[2 * i + 2][0]);
            segmentTree[i][1] = Math.max(segmentTree[2 * i + 1][1], segmentTree[2 * i + 2][1]);
        }

        private int[] rangeQuery(int rangeLeft, int rangeRight ,int i ,int left, int right) {
            if (rangeRight < left || rangeLeft > right) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
            else if (rangeLeft <= left && rangeRight >= right) return segmentTree[i];

            int mid = (left + right) / 2;

            int[] leftMinMax = rangeQuery(rangeLeft, rangeRight, 2 * i + 1, left, mid);
            int[] rightMinMax = rangeQuery(rangeLeft, rangeRight, 2 * i + 2, mid + 1, right);

            return new int[]{Math.min(leftMinMax[0], rightMinMax[0]), Math.max(rightMinMax[1],  leftMinMax[1])};
        }

        public long maxTotalValue(int[] nums, int k) {
            final int N = nums.length;

            segmentTree = new int[N * 4][2];
            segmentTreeMaker(0, 0, N-1, nums);

            PriorityQueue<int[]> pq = new  PriorityQueue<>( (a, b) -> b[0] - a[0]); // here int[] have {val, l, r}

            long res = 0;
            int left = 0, right = N-1;

            for (int l = left; l < N; l++) {
                int[] minMax = rangeQuery(l, right, 0, 0, N-1);
                int val = minMax[1] - minMax[0];

                pq.offer(new int[]{val, l, right});
            }

            while (!pq.isEmpty() && k-- > 0) {
                int[] cur = pq.poll();
                res += cur[0];

                if (cur[1] <= cur[2] - 1) {
                    int[] minMax = rangeQuery( cur[1], cur[2] - 1, 0, 0, N-1);
                    int val = minMax[1] - minMax[0];
                    pq.offer(new int[]{val, cur[1], cur[2]-1});
                }
            }

            return res;
        }
    }


    // it can solve the problem of MLE but The >> TLE << can't be solved with this
    class Solution_ {
        public long maxTotalValue(int[] nums, int k) {
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i = 0; i < nums.length; i++) {
                int min = nums[i], max = nums[i];

                for(int j = i + 1; j < nums.length; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);

                    pq.offer((long)(max - min));
                    if (pq.size() > k) pq.poll();
                }
            }

            long res = 0;
            while(!pq.isEmpty()) res += pq.poll();

            return res;
        }
    }

}


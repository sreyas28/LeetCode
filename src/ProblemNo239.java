import java.util.Arrays;
import java.util.PriorityQueue;

public class ProblemNo239 {
    public static void main(String[] args) {

        Solution a = new ProblemNo239().new Solution();
        System.out.println(Arrays.toString(a.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            final int N = nums.length;
            int[] result = new int[N - k + 1];

            boolean[] visited = new boolean[N];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // {value, index}

            for (int i = 0; i < k; i++)
                pq.offer(new int[] { nums[i], i });
            result[0] = pq.peek()[0];

            for (int i = k; i < N; i++) {
                int last = i - k;
                visited[last] = true;

                while (!pq.isEmpty() && visited[pq.peek()[1]])
                    pq.poll();

                pq.offer(new int[] { nums[i], i });
                result[last + 1] = pq.peek()[0];
            }

            return result;
        }
    }

}

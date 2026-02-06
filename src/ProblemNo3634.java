import java.util.Arrays;
import java.util.PriorityQueue;

public class ProblemNo3634 {
    public static void main(String[] args) {

        ProblemNo3634.Solution problem = new ProblemNo3634().new Solution();
        System.out.println(problem.minRemoval(new int[]{2,1}, 1));

    }

    class Solution {
        public int minRemoval(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);

            int count = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                long val = nums[i];

                int s = i, e = n - 1;
                while (s < e) {
                    int mid = (int) Math.ceil((double) (s + e) / 2);

                    if (val * k >= nums[mid]) s = mid;
                    else e = mid-1;
                }

                count = Math.min(count, n - (e - i + 1));
            }

            return count;
        }
    }

    // it takes greedy approach to solve this but the problem is we are just counting for max vals
    class Solution_ {
        public int minRemoval(int[] nums, int k) {
            long min = Long.MAX_VALUE;

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

            for (int num : nums) {
                pq.offer(num);
                min = Math.min(min, num);
            }

            int count = 0;
            while (!pq.isEmpty() && pq.peek() > min * k) {
                pq.poll();
                count++;
            }

            return count;
        }
    }

}

import java.util.ArrayDeque;
import java.util.Queue;

public class ProblemNo3942 {
    public static void main(String[] args) {

        Solution solution = new ProblemNo3942().new Solution();
        System.out.println(solution.minOperations(new int[]{0, 2, 1}));
        System.out.println(solution.minOperations(new int[]{1, 0, 2}));

    }

    class Solution {
        public int minOperations(int[] nums) {
            final int N = nums.length;

            int indexOfZero = -1;
            for (int i = 0; i < N; i++) {
                if (nums[i] == 0) {
                    indexOfZero = i;
                    break;
                }
            }

            // traversing towards right
            boolean flag = true;
            int k = 1, i = (indexOfZero + 1) % N;

            while (nums[i] != 0) {
                if (nums[i] == k) {
                    k++;
                    i = (i + 1) % N;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) return Math.min(indexOfZero, 1 + (N - indexOfZero) + 1);

            // traversing towards Left
            k = 1;
            i = (indexOfZero - 1 + N) % N;
            flag = true;

            while (nums[i] != 0) {
                if (nums[i] == k) {
                    k++;
                    i = (i - 1 + N) % N;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) return Math.min(indexOfZero + 1 + 1, (N - indexOfZero - 1) + 1);

            return -1;
        }
    }

    // Intuition But Wrong 2^n and infinite no way to stop it (only way to stop is making a new visited 3d array)
    class Solution_ {
        public int minOperations(int[] nums) {
            final int N = nums.length;

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0, N - 1, 1, 0}); // start, end, direction(1,-1), countTillNow

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                int start = cur[0];
                int end = cur[1];
                int direction = cur[2];
                int countTillNow = cur[3];

                if (offSetGetter(nums, start, end, direction)) return countTillNow;

                // left shift
                queue.offer(new int[]{(start + 1) % N, (end + 1) % N, direction, countTillNow + 1});

                // reverse
                queue.offer(new int[]{end, start, direction * -1, countTillNow + 1});
            }

            return -1;
        }

        private boolean offSetGetter(int[] nums, int start, int end, int direction) {
            final int N = nums.length;

            for (int i = start; i != end; i = (i + direction + N) % N) {
                int cur = nums[i];
                int future = nums[(i + direction + N) % N];

                if (cur > future) return false;
            }

            return true;
        }

        private void reverse(int[] nums) {
            final int N = nums.length;

            for (int i = 0; i < N / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[N - 1 - i];
                nums[N - 1 - i] = temp;
            }

        }

    }

}

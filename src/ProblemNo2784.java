import java.util.Arrays;

public class ProblemNo2784 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isGood(int[] nums) {
            final int N = nums.length;
            int expected_N = Arrays.stream(nums).max().getAsInt() + 1;

            if (N != expected_N) return false;

            boolean[] visited = new boolean[N];
            int countN = 0;
            for (int num : nums) {
                if (visited[num] && num != N-1) return false;
                else if (num == N-1) countN++;
                visited[num] = true;
            }

            if (countN != 2) return false;

            for (int i = 1; i < N; i++) {
                if (!visited[i]) return false;
            }

            return true;
        }
    }

}

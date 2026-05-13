import java.util.HashSet;
import java.util.Set;

public class ProblemNo1674 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1674().new Solution();
        System.out.println(a.minMoves(new int[]{20744,7642,19090,9992,2457,16848,3458,15721}, 22891));

    }

    // great Question
    class Solution {
        public int minMoves(int[] nums, int limit) {
            final int n = nums.length;
            int[] diff = new int[2*limit + 2];

            for(int i = 0; i < n/2; i++){
                int a = Math.min(nums[i], nums[n-i-1]);
                int b = Math.max(nums[i], nums[n-i-1]);

                diff[2] += 2;
                diff[a+1] -= 1;
                diff[a+b] -= 1;
                diff[a+b+1] += 1;
                diff[b+limit+1] += 1;
            }

            int minOp = Integer.MAX_VALUE;
            int current = 0;

            for (int i = 2; i <= limit*2; i++) {
                current +=  diff[i];
                minOp = Math.min(minOp, current);
            }

            return minOp;
        }
    }

    // TLE
    class Solution_ {
        public int minMoves(int[] nums, int limit) {
            final int N = nums.length;

            int changes = Integer.MAX_VALUE;

            for (int toAchieve = 2; toAchieve <= 2*limit; toAchieve++) {
                int tempChange = 0;
                for (int i = 0; i < N/2; i++) {
                    tempChange += toChange(nums, i, N-i-1, limit, toAchieve);
                }
                changes = Math.min(changes, tempChange);
            }

            return changes;
        }

        private int toChange(int[] numbs, int left, int right, int limit, int toAchieve) {
            int a = numbs[left];
            int b = numbs[right];

            if (a + b == toAchieve) return 0;
            else if (toAchieve - a > 0 && toAchieve - a <= limit) return 1;
            else if (toAchieve - b > 0 && toAchieve - b <= limit) return 1;

            return 2;
        }

    }

}

import java.util.Arrays;

public class ProblemNo2654 {
    public static void main(String[] args) {
        ProblemNo2654.Solution a = new ProblemNo2654(). new Solution();
        System.out.println(a.minOperations(new int[]{2,6,3,4}));
    }

    class Solution {
        public int minOperations(int[] nums) {
            int countOne = 0;
            for(int i: nums) {
                if (i == 1) countOne++;
            }

            int n = nums.length;
            if(countOne != 0) return n - countOne;

            int minLen = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int g = nums[i];
                for (int j = i; j < n; j++) {
                    g = GCD(g, nums[j]);
                    if (g == 1) {
                        minLen = Math.min(minLen, j - i + 1);
                        break; // no need to extend further
                    }
                }
            }

            return minLen == Integer.MAX_VALUE ? -1 : (minLen - 1) + (n - 1);
        }

        private int GCD(int max, int min){
            while(true){
                int rem = max % min;

                if(rem == 0) return min;

                max = min;
                min = rem;
            }
        }

    }

}

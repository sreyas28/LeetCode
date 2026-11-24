public class ProblemNo3411 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3411().new Solution();
        System.out.println(a.maxLength(new int[]{1,2,1,2,1,1,1}));

    }

    class Solution {
        private static final int LIMIT = 2520;

        public int maxLength(int[] nums) {
            final int N = nums.length;
            int max = 1;

            for (int i = 0; i < N-1; i++) {
                long lastLCM = nums[i], lastHCF = lastLCM, product = lastLCM;

                for (int j = i + 1; j < N; j++) {
                    int current = nums[j];

                    lastLCM = LCM(lastLCM, current);
                    lastHCF = HCF(lastHCF, current);

                    product *= current;

                    if (product > LIMIT) break;
                    else if (product == lastLCM * lastHCF) max = Math.max(max, j - i + 1);
                }
            }


            return max;
        }

        private long LCM(long i, long j) {
            if (i == 0 || j == 0) return 0;
            return (i / HCF(i, j)) * j;
        }

        private long HCF(long i, long j) {
            while (j != 0) {
                long temp = j;
                j = i % j;
                i = temp;
            }

            return i;
        }

    }

}

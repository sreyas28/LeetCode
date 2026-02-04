import java.util.*;

public class ProblemNo3640 {
    public static void main(String[] args) {

        ProblemNo3640.Solution p = new ProblemNo3640().new Solution();
//        System.out.println(p.maxSumTrionic(new int[]{0, -2, -2, -1, -3, 0, 2, -1}));
//        System.out.println(p.maxSumTrionic(new int[]{159, 208, -920, -460, 295}));
        System.out.println(p.maxSumTrionic(new int[]{2, 993, -791, -635, -569}));

    }


    class Solution {
        public long maxSumTrionic(int[] nums) {
            int n = nums.length;

            Map<Integer, Integer> inc = new HashMap<>();
            Map<Integer, Integer> dec = new HashMap<>();

            long[] sumsForward = new long[n];
            long[] sumsBackward = new long[n];
            sumsForward[0] = nums[0];
            sumsBackward[n - 1] = nums[n - 1];

            // make inc and dec also it sums the nums in forward way
            for (int i = 1; i < n; i++) {
                int val = nums[i - 1] - nums[i];

                if (val < 0) inc.put(i - 1, i);
                else if (val > 0) dec.put(i - 1, i);

                sumsForward[i] = sumsForward[i - 1] + nums[i];
            }

            // it sums the nums in backward manner
            for (int i = n - 2; i >= 0; i--) {
                sumsBackward[i] = sumsBackward[i + 1] + nums[i];
            }

            compressChain(inc);
            compressChain(dec);

            return maxSum(inc, dec, sumsForward, sumsBackward, n);
        }

        private long maxSum(Map<Integer, Integer> inc, Map<Integer, Integer> dec, long[] sumsForward, long[] sumsBackward, int n) {
            long globalSum = Long.MIN_VALUE;

            for (int startKey : inc.keySet()) {
                // int startKey;
                int top_I = inc.get(startKey);
                int bottom = dec.getOrDefault(top_I, -1);
                int top_II = inc.getOrDefault(bottom, -1);

                if (bottom == -1 || top_II == -1) continue; // no Trionic Exists

                // Incline SUM
                long sumIncline = Long.MIN_VALUE;
                for (int i = startKey; i < top_I; i++) {
                    sumIncline = Math.max(sumsForward[top_I] - (i > 0 ? sumsForward[i - 1] : 0), sumIncline);
                }

                long sumDecline = sumsForward[bottom] - sumsForward[top_I];

                // Second incline sum (prefix sums backward)
                long sumInclineII = Long.MIN_VALUE;
                for (int i = bottom + 1; i <= top_II; i++) {
                    long subSum = sumsBackward[bottom + 1] - (i + 1 < n ? sumsBackward[i + 1] : 0);
                    sumInclineII = Math.max(sumInclineII, subSum);
                }


                globalSum = Math.max(sumIncline + sumDecline + sumInclineII, globalSum);
            }

            return globalSum;
        }

        private void compressChain(Map<Integer, Integer> map) {

            Set<Integer> keys = new HashSet<>(map.keySet());

            for (int startKey : keys) {
                if (map.containsKey(startKey)) {
                    int endKey = map.get(startKey);

                    while (map.containsKey(endKey)) {
                        int temp = map.get(endKey);
                        map.put(startKey, temp);

                        map.remove(endKey);
                        endKey = temp;
                    }
                }
            }
        }
    }


    // ideation
    class Solution_ {
        public long maxSumTrionic(int[] nums) {
            long ans = 0;

            int i = 1;
            while (i < nums.length && nums[i - 1] - nums[i] >= 0)
                i++; // skipping all the index which have decreasing numbers

            long tempSum = nums[i - 1];
            while (i < nums.length && nums[i - 1] - nums[i] < 0) i++;

            tempSum += nums[i - 1];
            while (i < nums.length && nums[i - 1] - nums[i] > 0) i++;

            tempSum += nums[i - 1];
            while (i < nums.length && nums[i - 1] - nums[i] < 0) i++;

            tempSum += nums[i - 1];


            System.out.println(tempSum);

            return ans;
        }
    }

}

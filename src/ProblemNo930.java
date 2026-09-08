import java.util.HashMap;

public class ProblemNo930 {
    public static void main(String[] args) {

        Solution a = new ProblemNo930().new Solution();
//        System.out.println(a.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
//        System.out.println(a.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(a.numSubarraysWithSum(new int[]{0,1,0,0,1,0,0,1,1,0,1,1,1,1,0}, 5));

    }

    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            HashMap<Integer, Integer> prefixSumCount = new HashMap<>(); // prefix sum and count

            int sum = 0;
            for (int i : nums) {
                sum += i;
                prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
            }

            int count = 0;
            if (goal == 0) {
                for (int iKey : prefixSumCount.keySet()) {
                    if (iKey == 0) {
                        int temp = prefixSumCount.get(iKey);
                        count += temp * (temp + 1) / 2;
                    } else {
                        int temp = prefixSumCount.get(iKey) - 1;
                        count += temp * (temp + 1) / 2;
                    }
                }

                return count;
            }

            for (int iKey : prefixSumCount.keySet()) {
                if (iKey < goal) continue;
                else if (iKey == goal) {
                    count += prefixSumCount.get(iKey) * (prefixSumCount.getOrDefault(0, 0) + 1);
                } else {
                    int toFind = iKey - goal;
                    count += prefixSumCount.getOrDefault(toFind, 0) * prefixSumCount.get(iKey);
                }
            }
            return count;
        }
    }

}

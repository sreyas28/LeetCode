import java.util.*;

public class ProblemNo3397 {
    public static void main(String[] args) {

        ProblemNo3397.Solution a = new ProblemNo3397().new Solution();
        System.out.println(a.maxDistinctElements(new int[]{1,1,1,1,1,1,1,1,5,5,5}, 3));

    }

    class Solution {
        public int maxDistinctElements(int[] nums, int k) {
            Arrays.sort(nums);
            int cnt = 0;
            int prev = Integer.MIN_VALUE;
            for (int num : nums) {
                int curr = Math.min(Math.max(num - k, prev + 1), num + k);
                if (curr > prev) {
                    cnt++;
                    prev = curr;
                }
            }
            return cnt;
        }
    }

}
